package com.yunyou.xemcquartz.service.impl;


import com.yunyou.xemcquartz.entity.RestEntity;
import com.yunyou.xemcquartz.service.IAutoWorkPluginService;
import com.yunyou.xemcquartz.util.RestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 定时任务实现类
 */
@Service
public class AutoWorkPlugionSerivcerImpl implements IAutoWorkPluginService {

    @Autowired
    private RestEntity rest;

    /**
     * 打印输出信息
     */
    private String getPrintln(String json){
        StringBuilder pri = new StringBuilder();
        pri.append("请求参数：").append(json);
        String sr = RestUtils.doPostJson(rest.getUrl(), json);
        pri.append("返回参数：").append(sr).append("任务结束时间：").append(LocalDateTime.now());
        return  pri.toString();
    }

    /**
     * 打印输出信息
     */
    private String getPrintlnEcg(String json){
        StringBuilder pri = new StringBuilder();
        pri.append("采购平台请求参数：").append(json);
        String sr = RestUtils.doPostJson(rest.getEcgurl(), json);
        pri.append("返回参数：").append(sr).append("任务结束时间：").append(LocalDateTime.now());
        return  pri.toString();
    }

    /**
     * bom后台任务
     */
    @Override
    public String BomService() {
        return getPrintln(rest.getBomjson());
    }

    /**
     * wms物料分类服务
     */
    @Override
    public String WmsMaterialClassService() {
        return getPrintln(rest.getMaterialclassjson());
    }
    /**
     * wms物料服务
     */
    @Override
    public String WmsMaterialService() {
        return getPrintln(rest.getMaterialjson());
    }
    /**
     * wms物料包装服务
     */
    @Override
    public String WmsMaterialPackService() {
        return getPrintln(rest.getMaterialpackjson());
    }

    /**
     * wms计量单位服务
     */
    @Override
    public String WmsMeasService() {
        return getPrintln(rest.getMeasjson());
    }

    /**
     * wms组织服务
     */
    @Override
    public String WmsOrgService() {
        return getPrintln(rest.getOrgjson());
    }

    /**
     * wms人员服务
     */
    @Override
    public String WmsPsnService() {
        return getPrintln(rest.getPsnjson());
    }

    /**
     * wms往来单位服务
     */
    @Override
    public String WmsExChangUnitService() {
        return getPrintln(rest.getExchangunitjson());
    }

    /**
     * 物料统计口径服务
     */
    @Override
    public String WmsCaliberService() {
        return getPrintln(rest.getCaliberjson());
    }
    /**
     * wms发货单服务
     */
    @Override
    public String WmsArriveorderService() {
        return getPrintln(rest.getArriveorderjson());
    }
    /**
     * wms到货单服务
     */
    @Override
    public String WmsDeliveryService() {
        return getPrintln(rest.getDeliveryjson());
    }

    /**
     * NC物料期初
     * @return
     */
    @Override
    public String NCBeginMaterial() {
        return getPrintln(rest.getBeginmateialjson());
    }

    @Override
    public String WMSMaterialFrameService() {
        return getPrintln(rest.getWMSMaterialFramejson());
    }

    @Override
    public String MESGongXuService() {
        return getPrintln(rest.getMESGongXujson());
    }

    @Override
    public String MESQuanXuService() {
        return getPrintln(rest.getMESQuanXujson());
    }

    @Override
    public String EcgDeptService() {
        return getPrintlnEcg(rest.getEcgdeptjson());
    }

    @Override
    public String EcgMaterialService() {
        return getPrintlnEcg(rest.getEcgmaterialjson());
    }

    @Override
    public String EcgMaterialclassService() {
        return getPrintlnEcg(rest.getEcgmaterialclassjson());
    }

    @Override
    public String EcgOrgService() {
        return getPrintlnEcg(rest.getEcgorgjson());
    }

    @Override
    public String EcgObjectService() {
        return getPrintlnEcg(rest.getEcgobjectjson());
    }

    @Override
    public String EcgPsonService() {
        return getPrintlnEcg(rest.getEcgpsonjson());
    }

    @Override
    public String EcgStordocService() {
        return getPrintlnEcg(rest.getEcgstordocjson());
    }

    @Override
    public String EcgsupplierService() {
        return getPrintlnEcg(rest.getEcgsupplierjson());
    }
}
