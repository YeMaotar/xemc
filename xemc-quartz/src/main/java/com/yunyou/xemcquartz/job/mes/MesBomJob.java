package com.yunyou.xemcquartz.job.mes;

import cn.hutool.core.date.DateUtil;
import com.yunyou.xemcquartz.job.base.BaseAutoPluginWork;
import com.yunyou.xemcquartz.job.base.BaseJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * bom任务
 */
@Slf4j
public class MesBomJob extends BaseAutoPluginWork implements BaseJob {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String flag = super.service.BomService();
        log.warn("BOM Job 执行时间: {}", DateUtil.now()+" "+flag);
    }
}
