package com.yunyou.xemceappendix.controller.file;



import com.yunyou.xemceappendix.common.ResponseCode;
import com.yunyou.xemceappendix.common.Result;
import com.yunyou.xemceappendix.entity.file.FileEntity;
import com.yunyou.xemceappendix.mapper.file.FileMapper;
import com.yunyou.xemceappendix.service.FileHelperService;
import com.yunyou.xemceappendix.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: FileController
 * @Author ZhangZw
 * @Date: 2022/4/25 15:56
 * @Version 1.0
 * 文件上传接口
 */
@RestController
@RequestMapping("/file")
public class FileController  {
    @Resource
    private FileService fileService;
    @Resource
    private FileHelperService fileHelperClass;

    @Resource
    private FileMapper fileMapper;
    //文件保存路劲路径
    @Value("${FileSaving_PATH}")
    private  String FileSaving_PATH ;
    /**
     * 上传数据
     * @param multipartFile
     * @return
     */
    @PostMapping(value = "/upload")
    public Result upLoadFiles(MultipartFile multipartFile){
        if (multipartFile.isEmpty()) {
            return new Result(ResponseCode.FILE_EMPTY.getCode(), ResponseCode.FILE_EMPTY.getMsg(), null, "", "");
        }
        return fileService.upLoadFiles(multipartFile);
    }

    /**
     * 下载数据
     * @param id
     * @param request
     * @param response
     */
    @GetMapping(value = "/download")
    public void downloadFiles(@RequestParam(value="id") String id, HttpServletRequest request, HttpServletResponse response){
        OutputStream outputStream=null;
        InputStream inputStream=null;
        BufferedInputStream bufferedInputStream=null;
        byte[] bytes=new byte[1024];
        FileEntity files = fileService.getFileById(id);
        String fileName = files.getFileName();
        // 获取输出流
        try {
            //解决下载文件时文件名乱码问题
            byte[] fileNameBytes = fileName.getBytes(StandardCharsets.UTF_8);
            fileName = new String(fileNameBytes, 0, fileNameBytes.length, StandardCharsets.ISO_8859_1);


            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/force-download");


            inputStream=fileService.getFileInputStream(files);
            bufferedInputStream=new BufferedInputStream(inputStream);
            outputStream = response.getOutputStream();
            int i=bufferedInputStream.read(bytes);
            while (i!=-1){
                outputStream.write(bytes,0,i);
                i=bufferedInputStream.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (inputStream!=null){
                    inputStream.close();
                }
                if (outputStream!=null){
                    outputStream.close();
                }
                if (bufferedInputStream!=null){
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    /*
     *  删除文件指定文件
     */
    @GetMapping("/remove")
    public Result removefile(@RequestParam(value="fileName") String fileName) throws FileNotFoundException, IOException {
        Map<String, String> map = new HashMap<String, String>();
        try {
            map= fileHelperClass.readfile(FileSaving_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, String> fileSite =  fileHelperClass.screenKeyNameToValue(map,fileName);
        if(fileSite.keySet().size()<=0){
            return new Result(ResponseCode.ERROR.getCode(),"删除失败，文件不存在",null,null,null);
        }
        List<FileEntity> list=fileMapper.selectFileByFileName(fileName);
        String url="1";
        //查询获取最新上传的记录
        for(FileEntity fileEntity : list){
            for(String lj : fileSite.keySet()){
                if(fileEntity.getFilePath().equals(lj)){
                    url=lj;
                    break;
                }
            }
            if(!"1".equals(url)) break;
        }
        //如果记录表不存在，则去文件夹该名称文档的第一个
        url="1".equals(url)?fileSite.keySet().iterator().next():url;
        url=fileSite.keySet().iterator().next();
        File myObj = new File(url);
        if (myObj.delete()) {
            //新增删除记录
            Date date=new Date();
            FileEntity files=new FileEntity(url,fileName,"","0","0",date);
            fileMapper.insertFile(files);
            fileMapper.updateFileByFilePath(url);
            fileHelperClass.deletePdfToName(fileName);
            return new Result(ResponseCode.SUCCESS.getCode(),"删除成功！","删除路径"+url,null,null);
        } else {
            return new Result(ResponseCode.ERROR.getCode(),"删除失败，文件不存在！",null,null,null);
        }

    }




}
