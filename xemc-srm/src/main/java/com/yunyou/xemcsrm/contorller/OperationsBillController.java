package com.yunyou.xemcsrm.contorller;

import com.alibaba.fastjson.JSONObject;
import com.yunyou.xemcsrm.config.XemcUrlComponent;
import com.yunyou.xemcsrm.utils.LogUtils;
import com.yunyou.xemcsrm.service.LogSerivce;
import com.yunyou.xemcsrm.utils.RestClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 业务单据接口入口(请购单，NC采购合同，年度计划，采购平台采购合同)
 * @author zhangzhw
 * @date 2022-06-21
 */
@RestController
@RequestMapping("bill")
public class OperationsBillController {

    @Autowired
    private XemcUrlComponent ecgurl;
    /**
     * 注入日志接口服务
     */
    @Autowired
    LogSerivce logSerivce;

    /**
     * nc请购单调用该接口转发E采购
     * @param requesting
     * @return
     */
    @PostMapping("/praybill")
    public String NcPrayBillToEBill(@RequestBody String requesting){
        String response =  RestClientUtils.doPostJson(ecgurl.getPraybill(),requesting);
        logSerivce.save(LogUtils.getEntity("nc->ecg请购单",requesting,response));
        JSONObject strings = JSONObject.parseObject(response);
        if(strings.get("code").equals("0")){
            return "成功";
        }
        return strings.get("message").toString();
    }

    /**
     * nc采购合同调用该接口转发E采购
     * @param requesting
     * @return
     */
    @PostMapping("/ctpu")
    public String NcCtPuToEBill(@RequestBody String requesting){
        String response =  RestClientUtils.doPostJson(ecgurl.getCtpu(),requesting);
        logSerivce.save(LogUtils.getEntity("nc->ecg采购合同",requesting,response));
        JSONObject strings = JSONObject.parseObject(response);
        if(strings.get("code").equals("0")){
            return "成功";
        }
        return strings.get("message").toString();
    }
//
    /**
     * E采购采购合同调用该接口转发NC
     * @param requesting
     * @return
     */
    @PostMapping("/ectpu")
    public String EcgToNcCtPuBill(@RequestBody String requesting){
        String response =  RestClientUtils.doPostJson(ecgurl.getEctpu(),requesting);
        logSerivce.save(LogUtils.getEntity("ecg->nc采购合同",requesting,response));
        return response;
    }
    /**
     * E年标计划调用该接口转发NC
     * @param requesting
     * @return
     */
    @PostMapping("/eplan")
    public String EcgPlanToNcDefBill(@RequestBody String requesting){
        String response =  RestClientUtils.doPostJson(ecgurl.getEplan(),requesting);
        logSerivce.save(LogUtils.getEntity("ecg->nc年标合同",requesting,response));
        return response;
    }
}

