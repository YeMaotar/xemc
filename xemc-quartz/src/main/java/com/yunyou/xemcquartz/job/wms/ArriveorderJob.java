package com.yunyou.xemcquartz.job.wms;

import cn.hutool.core.date.DateUtil;
import com.yunyou.xemcquartz.job.base.BaseAutoPluginWork;
import com.yunyou.xemcquartz.job.base.BaseJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * wms发货单job
 */
@Slf4j
public class ArriveorderJob extends BaseAutoPluginWork implements BaseJob {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String flag = super.service.WmsArriveorderService();
        log.warn("wms发货单 Job 执行时间: {}", DateUtil.now()+" "+flag);
    }
}

