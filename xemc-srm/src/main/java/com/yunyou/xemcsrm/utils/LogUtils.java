package com.yunyou.xemcsrm.utils;


import com.yunyou.xemcsrm.entity.LogEntity;

/**
 * 日志工具类
 */
public  class LogUtils {
    public static LogEntity getEntity(String type, String request, String response){
        LogEntity entity = new LogEntity();
        entity.setXemclogtype(type);
        entity.setRequest(request);
        entity.setResponse(response);
        return entity;
    }
}
