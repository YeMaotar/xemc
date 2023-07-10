package com.yunyou.xemcquartz.job.mes;

import cn.hutool.core.date.DateUtil;
import com.yunyou.xemcquartz.job.base.BaseAutoPluginWork;
import com.yunyou.xemcquartz.job.base.BaseJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author wsq
 * @date 2023/6/28 14:55
 */
@Slf4j
public class MrpResponse extends BaseAutoPluginWork implements BaseJob {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String flag = super.service.MrpResponseService();
        log.warn("MRP计划结果反馈MES Job 执行时间: {}", DateUtil.now()+" "+flag);
    }
}
