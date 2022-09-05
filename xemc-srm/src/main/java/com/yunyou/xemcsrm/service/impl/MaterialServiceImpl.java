package com.yunyou.xemcsrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunyou.xemcsrm.entity.MaterialEntity;
import com.yunyou.xemcsrm.mapper.MaterialMapper;
import com.yunyou.xemcsrm.service.MaterialService;
import com.yunyou.xemcsrm.mapper.MaterialMapper;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, MaterialEntity> implements MaterialService {
}
