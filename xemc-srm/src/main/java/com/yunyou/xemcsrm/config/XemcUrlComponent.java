package com.yunyou.xemcsrm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ecg.service")
/**
 * 中转url地址配置文件
 */
public class XemcUrlComponent {
    private String praybill;
    private String ctpu;
    private String ectpu;
    private String eplan;
    private String ctpurecall;
    private String praybillrecall;

    public String getCtpurecall() {
        return ctpurecall;
    }

    public void setCtpurecall(String ctpurecall) {
        this.ctpurecall = ctpurecall;
    }

    public String getPraybillrecall() {
        return praybillrecall;
    }

    public void setPraybillrecall(String praybillrecall) {
        this.praybillrecall = praybillrecall;
    }

    public String getPraybill() {
        return praybill;
    }

    public void setPraybill(String praybill) {
        this.praybill = praybill;
    }

    public String getCtpu() {
        return ctpu;
    }

    public void setCtpu(String ctpu) {
        this.ctpu = ctpu;
    }

    public String getEctpu() {
        return ectpu;
    }

    public void setEctpu(String ectpu) {
        this.ectpu = ectpu;
    }

    public String getEplan() {
        return eplan;
    }

    public void setEplan(String eplan) {
        this.eplan = eplan;
    }
}
