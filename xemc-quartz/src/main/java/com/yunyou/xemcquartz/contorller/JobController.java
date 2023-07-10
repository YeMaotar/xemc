package com.yunyou.xemcquartz.contorller;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.yunyou.xemcquartz.common.ApiResponse;
import com.yunyou.xemcquartz.entity.JobAndTrigger;
import com.yunyou.xemcquartz.entity.JobForm;
import com.yunyou.xemcquartz.service.IAutoWorkPluginService;
import com.yunyou.xemcquartz.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * Job Controller
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-26 13:23
 */
@RestController
@RequestMapping("/job")
@Slf4j
public class JobController {
    @Resource
    private JobService jobService;

    @Resource
    private IAutoWorkPluginService workservice;

    /**
     * 保存定时任务
     */
    @PostMapping
    public ResponseEntity<ApiResponse> addJob(@Valid JobForm form) {
        try {
            jobService.addJob(form);
        } catch (Exception e) {
            return new ResponseEntity<>(ApiResponse.msg(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(ApiResponse.msg("操作成功"), HttpStatus.CREATED);
    }

    /**
     * 删除定时任务
     */
    @DeleteMapping
    public ResponseEntity<ApiResponse> deleteJob(JobForm form) throws SchedulerException {
        if (StrUtil.hasBlank(form.getJobGroupName(), form.getJobClassName())) {
            return new ResponseEntity<>(ApiResponse.msg("参数不能为空"), HttpStatus.BAD_REQUEST);
        }

        jobService.deleteJob(form);
        return new ResponseEntity<>(ApiResponse.msg("删除成功"), HttpStatus.OK);
    }

    /**
     * 暂停定时任务
     */
    @PutMapping(params = "pause")
    public ResponseEntity<ApiResponse> pauseJob(JobForm form) throws SchedulerException {
        if (StrUtil.hasBlank(form.getJobGroupName(), form.getJobClassName())) {
            return new ResponseEntity<>(ApiResponse.msg("参数不能为空"), HttpStatus.BAD_REQUEST);
        }

        jobService.pauseJob(form);
        return new ResponseEntity<>(ApiResponse.msg("暂停成功"), HttpStatus.OK);
    }

    /**
     * 恢复定时任务
     */
    @PutMapping(params = "resume")
    public ResponseEntity<ApiResponse> resumeJob(JobForm form) throws SchedulerException {
        if (StrUtil.hasBlank(form.getJobGroupName(), form.getJobClassName())) {
            return new ResponseEntity<>(ApiResponse.msg("参数不能为空"), HttpStatus.BAD_REQUEST);
        }

        jobService.resumeJob(form);
        return new ResponseEntity<>(ApiResponse.msg("恢复成功"), HttpStatus.OK);
    }

    /**
     * 修改定时任务，定时时间
     */
    @PutMapping(params = "cron")
    public ResponseEntity<ApiResponse> cronJob(@Valid JobForm form) {
        try {
            jobService.cronJob(form);
        } catch (Exception e) {
            return new ResponseEntity<>(ApiResponse.msg(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(ApiResponse.msg("修改成功"), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> jobList(Integer currentPage, Integer pageSize) {
        if (ObjectUtil.isNull(currentPage)) {
            currentPage = 1;
        }
        if (ObjectUtil.isNull(pageSize)) {
            pageSize = 10;
        }
        PageInfo<JobAndTrigger> all = jobService.list(currentPage, pageSize);
        return ResponseEntity.ok(ApiResponse.ok(Dict.create().set("total", all.getTotal()).set("data", all.getList())));
    }

    @PutMapping(params = "do")
    public ResponseEntity<ApiResponse> DoJob(@Valid JobForm form){
        String jobClassName = form.getJobClassName();
        String message;
        if("com.yunyou.xemcquartz.job.mes.MesBomJob".equals(jobClassName)){
            message= workservice.BomService();
        }else if("com.yunyou.xemcquartz.job.nc.BeginMaterialJob".equals(jobClassName)){
            message= workservice.NCBeginMaterial();
        }else if("com.yunyou.xemcquartz.job.wms.ArriveorderJob".equals(jobClassName)){
            message= workservice.WmsArriveorderService();
        }else if("com.yunyou.xemcquartz.job.wms.CaliberJob".equals(jobClassName)){
            message=workservice.WmsCaliberService();
        }else if("com.yunyou.xemcquartz.job.wms.DeliveryJob".equals(jobClassName)){
            message= workservice.WmsDeliveryService();
        }else if("com.yunyou.xemcquartz.job.wms.ExChangUnitJob".equals(jobClassName)){
            message= workservice.WmsExChangUnitService();
        }else if("com.yunyou.xemcquartz.job.wms.MaterialClassJob".equals(jobClassName)){
            message= workservice.WmsMaterialClassService();
        }else if("com.yunyou.xemcquartz.job.wms.MaterialJob".equals(jobClassName)){
            message= workservice.WmsMaterialService();
        }else if("com.yunyou.xemcquartz.job.wms.MaterialPackJob".equals(jobClassName)){
            message=workservice.WmsMaterialPackService();
        }else if("com.yunyou.xemcquartz.job.wms.MeasJob".equals(jobClassName)){
            message=workservice.WmsMeasService();
        }else if("com.yunyou.xemcquartz.job.wms.OrgJob".equals(jobClassName)){
            message=workservice.WmsOrgService();
        }else if("com.yunyou.xemcquartzjob.wms.PsnJob".equals(jobClassName)){
            message=workservice.WmsPsnService();
        }else if("com.yunyou.xemcquartz.job.mes.MaterialFrame".equals(jobClassName)){
            message=workservice.WMSMaterialFrameService();
        }else if("com.yunyou.xemcquartz.job.mes.MESQuanXuJob".equals(jobClassName)){
            message=workservice.MESQuanXuService();
        }else if("com.yunyou.xemcquartz.job.mes.MESGongXuJob".equals(jobClassName)){
            message=workservice.MESGongXuService();
        }
        //by zhangzhw7 20221109 新增采购平台的基础数据同步
        else if("com.yunyou.xemcquartz.job.ecg.EcgStordocJob".equals(jobClassName)){
            message=workservice.EcgStordocService();
        }else if("com.yunyou.xemcquartz.job.ecg.EcgDeptJob".equals(jobClassName)){
            message=workservice.EcgDeptService();
        }else if("com.yunyou.xemcquartz.job.ecg.EcgOrgJob".equals(jobClassName)){
            message=workservice.EcgOrgService();
        }else if("com.yunyou.xemcquartz.job.ecg.EcgObjectJob".equals(jobClassName)){
            message=workservice.EcgObjectService();
        }else if("com.yunyou.xemcquartz.job.ecg.EcgMaterialJob".equals(jobClassName)){
            message=workservice.EcgMaterialService();
        }else if("com.yunyou.xemcquartz.job.ecg.EcgMaterialClassJob".equals(jobClassName)){
            message=workservice.EcgMaterialclassService();
        }else if("com.yunyou.xemcquartz.job.ecg.EcgPsonJob".equals(jobClassName)){
            message=workservice.EcgPsonService();
        }else if("com.yunyou.xemcquartz.job.ecg.EcgSupplierJob".equals(jobClassName)){
            message=workservice.EcgsupplierService();
        }else if("com.yunyou.xemcquartz.job.oa.BudgetSyncJob".equals(jobClassName)){
            message=workservice.OABudgetbudget();
        }else if("com.yunyou.xemcquartz.job.mes.MrpResponse".equals(jobClassName)){
            message=workservice.MrpResponseService();
        }
        else{
            message ="没有找到该接口";
        }
        System.out.println(message);
        return new ResponseEntity<>(ApiResponse.msg("立即执行成功"), HttpStatus.OK);

    }


}