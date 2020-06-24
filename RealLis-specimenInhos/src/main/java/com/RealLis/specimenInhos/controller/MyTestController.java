package com.RealLis.specimenInhos.controller;

import com.RealLis.common.core.controller.BaseController;
import com.RealLis.common.core.page.TableDataInfo;
import com.RealLis.specimenInhos.domain.SysConfig;
import com.RealLis.specimenInhos.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/system/config")
public class MyTestController extends BaseController {
    private String prefix = "system/config";

    @Autowired
    private ISysConfigService configService;

    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        SysConfig sysConfig = new SysConfig();
        List<SysConfig> list = configService.selectConfigList(sysConfig);
        return getDataTable(list);
    }
}
