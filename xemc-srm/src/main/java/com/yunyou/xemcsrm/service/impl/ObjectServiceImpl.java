package com.yunyou.xemcsrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunyou.xemcsrm.entity.ObjectEntity;
import com.yunyou.xemcsrm.mapper.ObjectMapper;
import com.yunyou.xemcsrm.service.ObjectService;
import org.springframework.stereotype.Service;

@Service
public class ObjectServiceImpl extends ServiceImpl<ObjectMapper, ObjectEntity> implements ObjectService {
}
