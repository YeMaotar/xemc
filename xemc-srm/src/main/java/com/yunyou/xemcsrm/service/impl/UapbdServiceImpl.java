package com.yunyou.xemcsrm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yunyou.xemcsrm.entity.*;
import com.yunyou.xemcsrm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public  class UapbdServiceImpl implements IUapbdService {
    @Autowired
    private DeptService deptservice;
    @Autowired
    private MaterialService materialservice;
    @Autowired
    private OrgService orgservice;
    @Autowired
    private PsonService psonservice;
    @Autowired
    private StordocService stordocservice;
    @Autowired
    private SupplierService supplierservice;
    @Autowired
    private MaterialClassService materialClassService;
    @Autowired
    private ObjectService objectService;

    @Override
    public boolean addDept(List<DeptEntity> dept) {
        //deptservice.saveBatch(dept);
        deptservice.saveOrUpdateBatch(dept);
        return true;
    }

    @Override
    public boolean addMaterial(List<MaterialEntity> material) {
        materialservice.saveOrUpdateBatch(material);
        return true;
    }

    @Override
    public boolean addOrg(List<OrgEntity> org) {
        orgservice.saveOrUpdateBatch(org);
        return true;
    }

    @Override
    public boolean addMaterialClass(List<MaterialclassEntity> materialclass) {
        materialClassService.saveOrUpdateBatch(materialclass);
        return true;
    }

    @Override
    public boolean addPson(List<PsonEntity> pson) {
        psonservice.saveOrUpdateBatch(pson);
        return true;
    }

    @Override
    public boolean addStordoc(List<StordocEntity> stordoc) {
        stordocservice.saveOrUpdateBatch(stordoc);
        return true;
    }

    @Override
    public List<SupplierEntity> addSupplier() {
        //supplierservice.saveBatch(supplier);
        //by zhangzhw 20221018
        QueryWrapper<SupplierEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.notInSql("enablestate","'-1','-2'").isNotNull("code").gt("ts",getDate());
        List<SupplierEntity> listsuppler = supplierservice.list(queryWrapper);
        return listsuppler;
    }

    @Override
    public boolean addObject(List<ObjectEntity> object) {
        objectService.saveOrUpdateBatch(object);
        return true;
    }
    /**
     * 日期转化格式
     */
    public String getDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = format.format(date);
        return today;
    }
}
