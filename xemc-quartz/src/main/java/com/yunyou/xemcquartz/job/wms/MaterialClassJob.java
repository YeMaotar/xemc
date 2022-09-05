package com.yunyou.xemcquartz.job.wms;

import cn.hutool.core.date.DateUtil;
import com.yunyou.xemcquartz.job.base.BaseAutoPluginWork;
import com.yunyou.xemcquartz.job.base.BaseJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * wms物料分类job
 */
@Slf4j
public class MaterialClassJob extends BaseAutoPluginWork implements BaseJob {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String flag = super.service.WmsMaterialClassService();
        log.warn("wms物料分类 Job 执行时间: {}", DateUtil.now()+" "+flag);
    }
}
