package com.yunyou.xemceappendix.service.impl;


import com.yunyou.xemceappendix.common.ResponseCode;
import com.yunyou.xemceappendix.common.Result;
import com.yunyou.xemceappendix.entity.file.FileEntity;
import com.yunyou.xemceappendix.mapper.file.FileMapper;
import com.yunyou.xemceappendix.service.FileHelperService;
import com.yunyou.xemceappendix.service.FileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * @title: FileServiceImpl
 * @Author ZhangZw
 * @Date: 2022/4/25 15:33
 * @Version 1.0
 */
@Service
public class FileServiceImpl  implements FileService {

    //文件保存路劲路径
    @Value("${FileSaving_PATH}")
    private  String FileSaving_PATH ;

    @Autowired
    private FileMapper fileMapper;

    @Resource
    private FileHelperService fileHelperClass;

    @Override
    public Result upLoadFiles(MultipartFile file) {
        long MAX_SIZE=2097152L;
        String fileName=file.getOriginalFilename();
        if (StringUtils.isEmpty(fileName)){
            return new Result(ResponseCode.FILE_NAME_EMPTY.getCode(),ResponseCode.FILE_NAME_EMPTY.getMsg(),null,null,null);
        }
        if (file.getSize()>MAX_SIZE){
            return new Result(ResponseCode.FILE_MAX_SIZE.getCode(),ResponseCode.FILE_MAX_SIZE.getMsg(),null,null,null);
        }
        String suffixName = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".")) : null;
        String newName = System.currentTimeMillis() + suffixName;
        String  site=FileSaving_PATH+fileHelperClass.getCurrTime();//生成当月文件夹所在地址
        fileHelperClass.judgeSite(site);//验证文件夹是否存在，不存在新建文件夹
        File newFile=new File(site,fileName);
        if (!newFile.getParentFile().exists()){
            newFile.getParentFile().mkdirs();
        }
        try {
            //文件写入
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Date date=new Date();
        FileEntity files=new FileEntity(newFile.getPath(),fileHelperClass.ridFileSuffix(fileName),suffixName,"1","1",date);
        fileMapper.insertFile(files);
        return new Result(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMsg(),"数据上传成功", FileSaving_PATH ,fileName);
    }

    @Override
    public FileEntity getFileById(String id) {
        FileEntity files = fileMapper.selectFileById(id);
        return files;
    }

    @Override
    public InputStream getFileInputStream(FileEntity files) {
        File file=new File(files.getFilePath());
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }





}
