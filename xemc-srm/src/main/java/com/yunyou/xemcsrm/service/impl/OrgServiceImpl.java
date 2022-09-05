package com.yunyou.xemcsrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunyou.xemcsrm.entity.OrgEntity;
import com.yunyou.xemcsrm.mapper.OrgMapper;
import com.yunyou.xemcsrm.service.OrgService;
import org.springframework.stereotype.Service;

@Service
public class OrgServiceImpl extends ServiceImpl<OrgMapper, OrgEntity> implements OrgService {
}
