package com.yunyou.xemcsrm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 接口日志vo
 */
@TableName("bd_log")
public class LogEntity implements Serializable {
    /**接口类型*/
    @TableField("xemclogtype")
    private String xemclogtype;
    /**请求报文*/
    @TableField("request")
    private String request;
    /**响应报文*/
    @TableField("response")
    private String response;
    /**时间戳*/
    @TableField("ts")
    private String ts;

    public String getXemclogtype() {
        return xemclogtype;
    }

    public void setXemclogtype(String xemclogtype) {
        this.xemclogtype = xemclogtype;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }
}
