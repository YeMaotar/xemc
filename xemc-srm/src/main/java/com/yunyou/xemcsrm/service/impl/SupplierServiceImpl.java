package com.yunyou.xemcsrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunyou.xemcsrm.entity.SupplierEntity;
import com.yunyou.xemcsrm.mapper.SupplierMapper;
import com.yunyou.xemcsrm.service.SupplierService;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl  extends ServiceImpl<SupplierMapper, SupplierEntity> implements SupplierService {
}
