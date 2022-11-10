package com.yunyou.xemcquartz.job.ecg;

import cn.hutool.core.date.DateUtil;
import com.yunyou.xemcquartz.job.base.BaseAutoPluginWork;
import com.yunyou.xemcquartz.job.base.BaseJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class EcgSupplierJob extends BaseAutoPluginWork implements BaseJob {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String flag = super.service.EcgsupplierService();
        log.warn("采购平台供应商档案 Job 执行时间: {}", DateUtil.now()+" "+flag);
    }
}
