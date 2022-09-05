package com.yunyou.xemcquartz.job.wms;

import cn.hutool.core.date.DateUtil;
import com.yunyou.xemcquartz.job.base.BaseAutoPluginWork;
import com.yunyou.xemcquartz.job.base.BaseJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 物料包装job
 */
@Slf4j
public class MaterialPackJob extends BaseAutoPluginWork implements BaseJob {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String flag = super.service.WmsMaterialPackService();
        log.warn("wms物料包装 Job 执行时间: {}", DateUtil.now()+" "+flag);
    }
}
