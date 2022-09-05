package com.yunyou.xemcquartz.job.nc;

import cn.hutool.core.date.DateUtil;
import com.yunyou.xemcquartz.job.base.BaseAutoPluginWork;
import com.yunyou.xemcquartz.job.base.BaseJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 期初数据计算
 * @author wsq
 * @date 2022/4/24 14:26
 */
@Slf4j
public class BeginMaterialJob extends BaseAutoPluginWork implements BaseJob {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String flag = super.service.NCBeginMaterial();
        log.warn("BeginMaterial Job 执行时间: {}", DateUtil.now()+" "+flag);
    }
}
