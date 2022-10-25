package com.yunyou.xemcsrm.service;


import com.yunyou.xemcsrm.entity.*;

import java.util.List;

/**
 *
 */
public interface IUapbdService {
    boolean addDept(List<DeptEntity> dept);
    boolean addMaterial(List<MaterialEntity> material);
    boolean addOrg(List<OrgEntity> org);
    boolean addMaterialClass(List<MaterialclassEntity> materialclass);
    boolean addPson(List<PsonEntity> dept);
    boolean addStordoc(List<StordocEntity> stordoc);
    List<SupplierEntity> addSupplier();
    boolean addObject(List<ObjectEntity> object);

}
