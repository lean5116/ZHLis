package com.RealLis.quartz.controller;

import com.RealLis.common.core.controller.BaseController;
import com.RealLis.common.core.domain.AjaxResult;
import com.RealLis.common.core.page.TableDataInfo;
import com.RealLis.common.enums.BusinessType;
import com.RealLis.common.utils.StringUtils;
import com.RealLis.common.utils.poi.ExcelUtil;
import com.RealLis.quartz.anno.Auth;
import com.RealLis.quartz.domain.SysJob;
import com.RealLis.quartz.domain.SysJobLog;
import com.RealLis.quartz.service.ISysJobLogService;
import com.RealLis.quartz.service.ISysJobService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 调度日志操作处理
 */
@Controller
@RequestMapping("/monitor/jobLog")
public class SysJobLogController extends BaseController
{
    private String prefix = "monitor/job";

    @Autowired
    private ISysJobService jobService;

    @Autowired
    private ISysJobLogService jobLogService;
    @Auth
    @GetMapping()
    public String jobLog(@RequestParam(value = "jobId", required = false) Long jobId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(jobId))
        {
            SysJob job = jobService.selectJobById(jobId);
            mmap.put("job", job);
        }
        return prefix + "/jobLog";
    }
    @Auth
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysJobLog jobLog)
    {
        startPage();
        List<SysJobLog> list = jobLogService.selectJobLogList(jobLog);
        return getDataTable(list);
    }

    @Auth
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysJobLog jobLog)
    {
        List<SysJobLog> list = jobLogService.selectJobLogList(jobLog);
        ExcelUtil<SysJobLog> util = new ExcelUtil<SysJobLog>(SysJobLog.class);
        return util.exportExcel(list, "调度日志");
    }

    @Auth
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jobLogService.deleteJobLogByIds(ids));
    }
    @Auth
    @GetMapping("/detail/{jobLogId}")
    public String detail(@PathVariable("jobLogId") Long jobLogId, ModelMap mmap)
    {
        mmap.put("name", "jobLog");
        mmap.put("jobLog", jobLogService.selectJobLogById(jobLogId));
        return prefix + "/detail";
    }

    @Auth
    @PostMapping("/clean")
    @ResponseBody
    public AjaxResult clean()
    {
        jobLogService.cleanJobLog();
        return success();
    }
}
