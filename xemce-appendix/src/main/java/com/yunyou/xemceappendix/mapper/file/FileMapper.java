package com.yunyou.xemceappendix.mapper.file;

import com.yunyou.xemceappendix.entity.file.FileEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 文件数据服务
 * @author gosh
 */
@Mapper
public interface FileMapper{
    /**
     * 将数据信息插入到数据库
     * @param files
     */
    void insertFile(FileEntity files);

    /**
     * 根据id获取文件
     * @param id
     * @return
     */
    FileEntity selectFileById(String id);

    /**
     * 根据id获取文件
     * @param fileName
     * @return
     */
    List<FileEntity> selectFileByFileName(String fileName);
    /**
     * 根据id获取文件
     * @param filePath
     * @return
     */
    void updateFileByFilePath(String filePath);


}
