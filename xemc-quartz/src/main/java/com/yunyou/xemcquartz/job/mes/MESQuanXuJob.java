package com.yunyou.xemcquartz.job.mes;

import cn.hutool.core.date.DateUtil;
import com.yunyou.xemcquartz.job.base.BaseAutoPluginWork;
import com.yunyou.xemcquartz.job.base.BaseJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author wsq
 * @date 2022/9/7 15:25
 */
@Slf4j
public class MESQuanXuJob extends BaseAutoPluginWork implements BaseJob {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String flag = super.service.MESQuanXuService();
        log.warn("wms物料辅助属性设置 Job 执行时间: {}", DateUtil.now()+" "+flag);
    }
}
