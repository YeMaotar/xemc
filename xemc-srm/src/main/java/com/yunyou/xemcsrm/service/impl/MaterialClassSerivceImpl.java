package com.yunyou.xemcsrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunyou.xemcsrm.entity.MaterialclassEntity;
import com.yunyou.xemcsrm.mapper.MaterialClassMapper;
import com.yunyou.xemcsrm.service.MaterialClassService;
import org.springframework.stereotype.Service;

@Service
public class MaterialClassSerivceImpl extends ServiceImpl<MaterialClassMapper, MaterialclassEntity> implements MaterialClassService {
}
