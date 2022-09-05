package com.yunyou.xemcsrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunyou.xemcsrm.entity.LogEntity;
import com.yunyou.xemcsrm.mapper.LogMapper;
import com.yunyou.xemcsrm.service.LogSerivce;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, LogEntity> implements LogSerivce {
}
