package com.yunyou.xemcquartz.service;

/**
 * 后台任务接口
 */
public interface IAutoWorkPluginService{

    public String BomService();

    public String WmsMaterialClassService();

    public String WmsMaterialService();

    public String WmsMaterialPackService();

    public String WmsMeasService();

    public String WmsOrgService();

    public String WmsPsnService();

    public String  WmsExChangUnitService();

    public String WmsCaliberService();

    public String WmsArriveorderService();

    public String WmsDeliveryService();

    public String NCBeginMaterial();

    public String WMSMaterialFrameService();

    public String MESGongXuService();

    public String MESQuanXuService();

    //by zhangzhw 2022-11-09 新增一下接口，用于采购平台对接
    public String EcgDeptService();
    public String EcgMaterialService();
    public String EcgMaterialclassService();
    public String EcgOrgService();
    public String EcgObjectService();
    public String EcgPsonService();
    public String EcgStordocService();
    public String EcgsupplierService();
}
