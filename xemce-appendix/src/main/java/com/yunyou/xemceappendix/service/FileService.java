package com.yunyou.xemceappendix.service;

import com.yunyou.xemceappendix.common.Result;
import com.yunyou.xemceappendix.entity.file.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author gosh
 */
public interface FileService{
    /**
     * 文件上传接口
     * @param file
     * @return
     */
    Result upLoadFiles(MultipartFile file);

    /**
     * 根据id获取文件
     * @param id
     * @return
     */
    FileEntity getFileById(String id);

    /**
     * 根据id获取数据流
     * @param files
     * @return
     */
    InputStream getFileInputStream(FileEntity files);
}
