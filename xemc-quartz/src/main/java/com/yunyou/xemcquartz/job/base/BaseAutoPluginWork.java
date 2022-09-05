package com.yunyou.xemcquartz.job.base;

import com.yunyou.xemcquartz.service.IAutoWorkPluginService;

import javax.annotation.Resource;

/**
 * 后台任务父类
 */
public class BaseAutoPluginWork {
    @Resource
    protected IAutoWorkPluginService service;
}
