package com.yunyou.xemceappendix.controller.file;

import com.yunyou.xemceappendix.entity.file.FileEntity;
import com.yunyou.xemceappendix.mapper.file.FileMapper;
import com.yunyou.xemceappendix.service.FileHelperService;
import org.apache.commons.io.IOUtils;
import org.jodconverter.DocumentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ComponentScan
@Controller
public class MyContorller {

    @Autowired
    private DocumentConverter converter;

    @Autowired
    private HttpServletResponse response;

    @Resource
    private FileHelperService fileHelperClass;

    @Resource
    private FileMapper fileMapper;

    //pdf保存路径
    @Value("${pdfSaving_PATH}")
    private  String pdfSaving_PATH ;

    //文件保存路劲路径
    @Value("${FileSaving_PATH}")
    private  String FileSaving_PATH ;

    @GetMapping("read/{fileNames}")
    public void toPdfFile(@PathVariable String fileNames) {
        String url="1";
        Map<String, String> map = new HashMap<>();
        try {
            //查询文件夹下所有文件信息
            map= fileHelperClass.readfile(FileSaving_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //去除文件后缀名称
        String fileName=fileHelperClass.ridFileSuffix(fileNames);
        //判断指定文件名称是否存在
        Map<String, String> fileSite =  fileHelperClass.screenKeyNameToValue(map,fileName);
        if(fileSite.keySet().size()<=0){
            url=FileSaving_PATH+"/文件不存在.rtf";
            fileName="文件不存在";
        }else{
            List<FileEntity> list=fileMapper.selectFileByFileName(fileName);
            //查询获取最新上传的记录
            for(FileEntity fileEntity : list) {
                for (String lj : fileSite.keySet()) {
                    if (fileEntity.getFilePath().equals(lj)) {
                        url = lj;
                        break;
                    }
                }
                if (!"1".equals(url)) break;
            }
            //如果记录表不存在，则去文件夹该名称文档的第一个
            url="1".equals(url)?fileSite.keySet().iterator().next():url;
        }
        fileHelperClass.deletePdfToName(fileName);
        File file = new File(url);// 需要转换的文件
        try {
            //pd结尾不转换
            if(!"pdf".equals(url.substring(url.length()-3,url.length()))){
                File newFile = new File(pdfSaving_PATH + File.separator);// 转换之后文件生成的地址
                if (!newFile.exists()) {
                    newFile.mkdirs();
                }
                if (!new File(pdfSaving_PATH + File.separator + fileName + ".pdf").exists()) {
                    // 文件转化
                    converter.convert(file).to(new File(pdfSaving_PATH + File.separator + fileName + ".pdf")).execute();
                }
                url=pdfSaving_PATH + File.separator + fileName + ".pdf";
            }
            // 使用response,将pdf文件以流的方式发送的前段
            ServletOutputStream outputStream = response.getOutputStream();
            InputStream in = new FileInputStream(new File(url));// 读取文件
            // copy文件
            int i = IOUtils.copy(in, outputStream);
            in.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
