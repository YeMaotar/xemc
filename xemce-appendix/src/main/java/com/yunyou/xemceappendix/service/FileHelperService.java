package com.yunyou.xemceappendix.service;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface FileHelperService {
    /**
     * 读取某个文件夹下的所有文件(支持多级文件夹)
     *  @return
     */
    public Map<String, String> readfile(String filepath) throws FileNotFoundException, IOException;

    /**
     * 根据值（文件名）获取键名地址 判断文件是否存在
      *  @return
     */
    public Map<String,String> screenKeyNameToValue(Map<String,String> map, String value);
    /**
     * 判断指定文件夹是否存在
     *  @return
     */
    public void judgeSite(String site);

    /**
     * 将当月日期输出为yyyyMM格式用于生成文件夹名
     *  @return
     */
    public  String getCurrTime();
    /**
     * 去除文件后缀
     *  @return
     */
    public  String ridFileSuffix(String fileName);
    /**
     * 根据名称删除PDF文件
     *  @return
     */
    public  void deletePdfToName(String fileName);
}
