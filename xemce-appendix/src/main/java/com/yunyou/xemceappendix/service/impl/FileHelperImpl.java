package com.yunyou.xemceappendix.service.impl;

import com.yunyou.xemceappendix.service.FileHelperService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class FileHelperImpl implements FileHelperService {
    //文件保存路劲路径
    @Value("${pdfSaving_PATH}")
    private  String pdfSaving_PATH ;
    /**
     * 读取某个文件夹下的所有文件(支持多级文件夹)
     */
    @Override
    public Map<String, String> readfile(String filepath) throws FileNotFoundException, IOException {
        //声明一个HashMap，用于存放源文件，格式：<文件名，绝对路径>，以文件名为KEY，可以得到整个文件所在的路径和文件名
        Map<String, String> fileMap = new HashMap<>();
        try {
            File file = new File(filepath);
            if (!file.isDirectory()) {
                //文件
                fileMap.put(file.getName(),file.getAbsolutePath());
            } else if (file.isDirectory()) {
                //文件夹
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        fileMap.put(readfile.getAbsolutePath(),readfile.getName());
                    } else if (readfile.isDirectory()) {
                        fileMap.putAll(readfile(filepath + "\\" + filelist[i]));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return fileMap;
    }


    /**
     * 根据值（文件名）获取键名地址 判断文件是否存在
     */
    @Override
    public Map<String,String> screenKeyNameToValue(Map<String,String> map, String value){
        Map<String,String> data = new HashMap<String,String>();
        for(String key : map.keySet()){
            if(value.equals(ridFileSuffix(map.get(key)))){
                data.put(key,map.get(key));
            }
        }
        return data;
    }

    /**
     * 判断指定文件夹是否存在
     */
    @Override
    public void judgeSite(String site){
        File file = new File(site);
        if(!file.exists()&& !file.isDirectory()){
            file.mkdirs();                        //把a.sql也当做文件夹名来创建
            file.getParentFile().mkdirs();       //获取路径的根路径领创建文件，到最后最后一级路径前E:\新建文件夹\20211110\
        }
    }

    /**
     * 将当月日期输出为yyyyMM格式用于生成文件夹名
     */
    @Override
    public  String getCurrTime(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMM");
        return "/"+simpleDateFormat.format(new Date());
    }


    /**
     * 去除文件后缀
     */
    @Override
    public  String ridFileSuffix(String fileName){
        int lastIndex=fileName.lastIndexOf(".");//字符串第一个字符最后出现的下标
        return  fileName.substring(0,lastIndex);
    }


    /**
     * 去除文件后缀
     */
    @Override
    public  void deletePdfToName(String fileName){
        try {
            Map<String, String> map=readfile(pdfSaving_PATH);
            for(String name : map.keySet()){
                if(ridFileSuffix(map.get(name)).equals(fileName)){
                    File myObj = new File(name);
                    myObj.delete();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
