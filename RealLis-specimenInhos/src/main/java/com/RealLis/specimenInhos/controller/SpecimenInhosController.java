package com.RealLis.specimenInhos.controller;

import com.RealLis.common.core.controller.BaseController;
import com.RealLis.common.core.domain.AjaxResult;
import com.RealLis.common.core.page.TableDataInfo;
import com.RealLis.common.core.text.Convert;
import com.RealLis.specimenInhos.domain.*;
import com.RealLis.specimenInhos.domain.Formatter;
import com.RealLis.specimenInhos.domain.PostBack.*;
import com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.ZMIC;
import com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.germOBX;
import com.RealLis.specimenInhos.domain.PostBack.reportPostBack.OBX;
import com.RealLis.specimenInhos.domain.ReturnAudit.auditBody;
import com.RealLis.specimenInhos.service.*;
import com.RealLis.specimenInhos.ws.service.LisCommonWS.LisCommonWSService;
import com.RealLis.specimenInhos.ws.service.zhlisWsHerenLet.zhlisWsHerenLetService;
import com.RealLis.specimenInhos.ws.wsdl.herenLisBarcode.InterfaceHr;
import com.RealLis.specimenInhos.ws.wsdl.herenLisBarcode.InterfaceHrSoap;
import com.RealLis.specimenInhos.ws.wsdl.herenLisBarcode.UfPack;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.RealLis.specimenInhos.utils.XmlConvert.XmlToJson;

@Api("住院标本控制器")
@Controller
@RequestMapping("/specimenInhos")
public class SpecimenInhosController extends BaseController {

    @Autowired
    private IViLisBarcodeInfoService viLisBarcodeInfoService;
    @Autowired
    private LSampletypeService lSampletypeService;
    @Autowired
    private LLogisticsService lLogisticsService;
    @Autowired
    private zhlisWsHerenLetService zhlisWsHerenLetService;
    @Autowired
    private HisAdviceService hisAdviceService;
    @Autowired
    private LJytmxxService lJytmxxService;
    @Autowired
    private ReportPostBackService reportPostBackService;
    @Autowired
    private LisCommonWSService lisCommonWSService;
    @Autowired
    private ViLisAdviseHerenService viLisAdviseHerenService;

    @GetMapping("")
    public String specimenInhos( String appDeptCode,  String userCode, Model model) {
        model.addAttribute("department", appDeptCode);
        model.addAttribute("userCode", userCode);
        model.addAttribute("departmentName", appDeptCode);
        model.addAttribute("userName", userCode);
        List<Formatter> formatters = lSampletypeService.getLSampleTypeFormatter(null);
        model.addAttribute("SampleTypeFormatter", JSON.toJSONString(formatters));
        return "specimenInhos/index";
    }

    @GetMapping("/createLogistics/{deptId}/{userId}")
    public String createLogistics(@PathVariable String deptId, @PathVariable String userId, Model model) {
        model.addAttribute("department", deptId);
        model.addAttribute("userCode", userId);
        return "specimenInhos/CreateLogistics";
    }

    @GetMapping("/LogisticsDetail/{wlbh}/{wlzt}")
    public String LogisticDetail(@PathVariable String wlbh, @PathVariable String wlzt, Model model) {
        model.addAttribute("wlbh", wlbh);
        model.addAttribute("wlzt", wlzt);
        LLogistics lLogistics = new LLogistics();
        lLogistics.setWlbh(wlbh);
        LLogistics logisticses = lLogisticsService.getLlogistics(lLogistics);
        if (logisticses != null) {
            model.addAttribute("cjsj", logisticses.getCjsj());
            model.addAttribute("dbsj", logisticses.getDbsj());
            model.addAttribute("yssj", logisticses.getYssj());
            model.addAttribute("ddsj", logisticses.getDdsj());
        }
        return "specimenInhos/LogisticsDetail";
    }

    @GetMapping("/startShipping")
    public String Shippinng() {
        return "specimenInhos/startShipping";
    }
    /*================================================================================================================*/


    @ApiOperation("根据表id获取检验信息")
    @ApiImplicitParam(name = "tableId", value = "表Id", required = true, dataType = "String", paramType = "path")
    @PostMapping(value = "/list/{tableId}")
    @ResponseBody
    public TableDataInfo list(@PathVariable String tableId, ViLisBarcodeInfo viLisBarcodeInfo) throws ParseException {
        startPage();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<ViLisBarcodeInfo> viLisBarcodeInfoList = new ArrayList<ViLisBarcodeInfo>();
        if (tableId.equals("collectionComplete")) {
            logger.info("进入tabCollectionComplete，修改kssj与jssj为采集时间");
            viLisBarcodeInfo.setStartSamplingtime(sdf.parse(viLisBarcodeInfo.getParams().get("beginTime").toString()));
            viLisBarcodeInfo.setEndSamplingtime(sdf.parse(viLisBarcodeInfo.getParams().get("endTime").toString()));
        } else {
            viLisBarcodeInfo.setStartRequettime(sdf.parse(viLisBarcodeInfo.getParams().get("beginTime").toString()));
            viLisBarcodeInfo.setEndRequettime(sdf.parse(viLisBarcodeInfo.getParams().get("endTime").toString()));
        }
        viLisBarcodeInfo.setPatienttype("2"); //固定为住院病人
        if ("collectionConfirmation".equals(tableId)) {
            viLisBarcodeInfo.setSampleState("1");
        }
        if ("collectionComplete".equals(tableId)) {
            viLisBarcodeInfo.setSampleState("2");
        }
        if ("receiveComplete".equals(tableId)) {
            logger.info("进入" + tableId);
            viLisBarcodeInfo.setSampleState("3");
        }
        if ("cancellationReturn".equals(tableId)) {
            logger.info(tableId + "，增加条码状态为作废的数据");
            viLisBarcodeInfo.setSampleState("1,-2");
            logger.info(viLisBarcodeInfo.getBarstatus());
        }
        if ("overtimeBarcode".equals(tableId)) {
            logger.info("进入tabOvertimeBarcode，增加条码状态为0的数据");
            viLisBarcodeInfo.setSampleState("-1,0");

        }

        if ("specimenLogistics".equals(tableId)) {
            LLogistics lLogistics = new LLogistics();
            lLogistics.setParams(viLisBarcodeInfo.getParams());
            lLogistics.setBqdm(viLisBarcodeInfo.getDepartment());
            List<LLogistics> logisticses = lLogisticsService.getLlogisticsList(lLogistics);
            return getDataTable(logisticses);
        } else {
            viLisBarcodeInfoList = viLisBarcodeInfoService.getInfoList(viLisBarcodeInfo);
            return getDataTable(viLisBarcodeInfoList);
        }
    }

    @ApiOperation("异步生成检验条码")
    @ApiImplicitParam(name = "deptId", value = "科室id", dataType = "String")
    @PostMapping("/GenerateBarcode")
    @ResponseBody
    private void GenerateBarcode(String deptId) {
        ViLisAdviseHeren params = new ViLisAdviseHeren();
        params.setOrderStatus("1");
        params.setSampleFlag("0");
        params.setDeptcode(deptId);
        List<ViLisAdviseHeren> viLisAdviseHerenList = viLisAdviseHerenService.getDistinctAdviseList(params);

        if (viLisAdviseHerenList != null) {
            for (ViLisAdviseHeren viLisAdviseHeren : viLisAdviseHerenList
            ) {
                System.out.println(viLisAdviseHeren.getPatientid());
                logger.info(viLisAdviseHeren.getPatientid() + zhlisWsHerenLetService.LabBarMake(viLisAdviseHeren.getPatientid()));
            }
        }
    }

    @ApiOperation("获取单个条码信息")
    @ApiImplicitParam(name = "barcode", value = "条码号", dataType = "String", paramType = "path")
    @GetMapping("/getBarcode/{barcode}")
    @ResponseBody
    public AjaxResult getBarcode(@PathVariable String barcode) {
        ViLisBarcodeInfo params = new ViLisBarcodeInfo();
        params.setBarcode(barcode);
        ViLisBarcodeInfo response = viLisBarcodeInfoService.getInfo(params);
        if (response != null) {
            return success(JSON.toJSONString(response));
        } else {
            return error("未找到条码");
        }
    }

    @ApiOperation("标本打包")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "barcode", value = "条码号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "userCode", value = "用户id", required = true, dataType = "String")
    })
    @PostMapping("/Packing")
    @ResponseBody
    public AjaxResult Packing(String barcodes, String userCode) {
        if (barcodes != null && userCode != null) {
            InterfaceHr interfaceHr = new InterfaceHr();
            InterfaceHrSoap interfaceHrSoap = interfaceHr.getInterfaceHrSoap();
            UfPack ufPack = new UfPack();
            ufPack.setAsCzz(userCode);
            ufPack.setAsBarcode(barcodes);
            String response = interfaceHrSoap.ufPack(ufPack.getAsCzz(), ufPack.getAsBarcode());
            String result = XmlToJson(response);
            PackingResponse packing = new PackingResponse();
            packing = JSON.parseObject(result, PackingResponse.class);
            if ("-1".equals(packing.getBody().getRtncode())) {
                return error(result);
            } else {
                return success(result);
            }
        } else {
            return error("条码号与打包人不能为空");
        }
    }

    @ApiOperation("获取物流明细信息")
    @ApiImplicitParam(name = "wlbh", value = "物流编号", dataType = "String", paramType = "path")
    @PostMapping("/lLoginsticsDetail/list/{wlbh}")
    @ResponseBody
    public TableDataInfo lLogisticDetail(@PathVariable String wlbh) {
        startPage();
        List<LLogisticsDetailVO> lLogisticsDetailVO = lLogisticsService.getLlogisticsDetailByWlbh(wlbh);
        return getDataTable(lLogisticsDetailVO);
    }

    @ApiOperation("获取物流信息根据物流条码号")
    @ApiImplicitParam(name = "barcode", value = "物流条码号", dataType = "String", paramType = "path")
    @PutMapping("/startShipping/{barcode}")
    @ResponseBody
    public AjaxResult startShipping(@PathVariable String barcode) {
        LLogistics lLogistics = new LLogistics();
        lLogistics.setWlbh(barcode);
        LLogistics logisticses = lLogisticsService.getLlogistics(lLogistics);
        if (logisticses != null) {
            return success(JSON.toJSONString(logisticses));
        } else {
            return error("未找到相关物流信息");
        }
    }

    @ApiOperation("修改物流状态")
    @ApiImplicitParam(name = "lLogistics", value = "物流实体类", dataType = "LLogistics")
    @PostMapping("/startShipping")
    @ResponseBody
    public AjaxResult updateLogistics(LLogistics lLogistics) {
        int i = lLogisticsService.updateLogistics(lLogistics);
        if (i > 0) {
            return success();
        } else {
            return error();
        }
    }

    @ApiOperation("条码状态修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "barcodes", value = "选中条码号", dataType = "String"),
            @ApiImplicitParam(name = "czz", value = "操作员", dataType = "String"),
            @ApiImplicitParam(name = "czfs", value = "操作方式", dataType = "String")
    })

    @PostMapping("/changeBarcodeStatus")
    @ResponseBody
    public AjaxResult changeBarcodeStatus(String barcodes, String czz, String czfs) {
        LJytmxx lJytmxx = new LJytmxx();
        String[] barcode = barcodes.split("\\|");
        String result = "";
        int n = 0;
        if (barcode != null) {
            if (barcode.length > 0) {
                for (int i = 0; i < barcode.length; i++) {
                    if (barcode[i].length() > 0) {
                        lJytmxx.setDoctadviseno(barcode[i]);
                        if ("barcodePrint".equals(czfs)) {
                            lJytmxx.setBarstatus("1");
                            lJytmxx.setPrinter(czz);
                            lJytmxx.setDysj(new Date());
                            Map<String, Object> params = new HashMap<>();
                            params.put("barcodePrint", 0);
                            lJytmxx.setParams(params);
                            if (lJytmxxService.updateByBarcode(lJytmxx) > 0) {
                                result += barcode[i] + "|";
                                zhlisWsHerenLetService.SetBarOrderStatus(barcode[i], "2");//条码已打印
                            }

                        } else if ("barcodeCancel".equals(czfs)) {

                            lJytmxx.setBarstatus("-2");
                            lJytmxx.setCanceler(czz);
                            lJytmxx.setCanceltime(new Date());
                            Map<String, Object> params = new HashMap<>();
                            params.put("barcodeCancel", 0);
                            lJytmxx.setParams(params);
                            if (lJytmxxService.updateByBarcode(lJytmxx) > 0) {
                                n++;
                                result = Integer.toString(n);
                                zhlisWsHerenLetService.SetBarOrderStatus(barcode[i], "-2");
                            }
                        } else if ("collectionConfirm".equals(czfs)) {
                            lJytmxx.setExecutor(czz);
                            lJytmxx.setBarstatus("2");
                            lJytmxx.setExecutetime(new Date());
                            Map<String, Object> params = new HashMap<>();
                            params.put("collectionConfirm", 0);
                            lJytmxx.setParams(params);
                            if (lJytmxxService.updateByBarcode(lJytmxx) > 0) {
                                n++;
                                result = Integer.toString(n);
                                zhlisWsHerenLetService.SetBarOrderStatus(barcode[i], "3"); //标本已采集
                            }
                        } else if ("confirmCancel".equals(czfs)) {
                            Map<String, Object> params = new HashMap<>();
                            params.put("confirmCancel", 0);
                            lJytmxx.setParams(params);
                            if (lJytmxxService.updateByBarcode(lJytmxx) > 0) {
                                n++;
                                result = Integer.toString(n);
                                zhlisWsHerenLetService.SetBarOrderStatus(barcode[i], "11"); //lis退回标本
                            }
                        }
                    }
                }
            }
        }
        return success(result);
    }

    @ApiOperation("Lis报告回传接口")
    @ApiImplicitParam(name = "sampleno", value = "检验条码号", dataType = "String", paramType = "path")
    @GetMapping("/ReportPostBack/{sampleno}")
    @ResponseBody
    public String getReportPostBack(@PathVariable String sampleno) {
        String result = "";
        MSH msh = new MSH();
        //region MSH初始化
        msh.setMSH1("|");
        msh.setMSH2("^~\\&");
        msh.setMSH3("LIS");
        msh.setMSH4("");//发送院区
        msh.setMSH5("HIS");
        msh.setMSH6("");//接收院区
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        msh.setMSH7(formatter.format(new Date()) + "+0800");
        msh.setMSH9("OUL^R21");
        msh.setMSH10(UUID.randomUUID().toString());
        msh.setMSH11("P");
        msh.setMSH12("2.4");
        msh.setMSH15("NE");
        msh.setMSH16("AL");
        msh.setMSH18("utf-8");
        //endregion
        result += msh.toString();
        PID pid = reportPostBackService.getPIDbySampleno(sampleno);
        if (pid != null) {
            pid.setPID1("1");
            result += pid.toString();
        } else {
            result += new PID().toString();
        }
        PV1 pv1 = reportPostBackService.getPV1bySampleno(sampleno);
        if (pv1 != null) {
            pv1.setPV1_1("1");

            result += pv1.toString();
        } else {
            result += new PV1().toString();
        }
        ORC orc = reportPostBackService.getORCbySampleno(sampleno);
        if (orc != null) {
            result += orc.toString();
        } else {
            result += new ORC().toString();
        }
        List<OBR> obrList = reportPostBackService.getOBRbySampleno(sampleno);
        if (obrList != null) {
            if (obrList.size() > 0) {
                for (int i = 0; i < obrList.size(); i++) {
                    result += obrList.get(i).toString();
                }
            }
        } else {
            result += new OBR().toString();
        }
        List<OBX> obxList = reportPostBackService.getOBXbySampleno(sampleno);
        if (obxList != null) {
            if (obxList.size() > 0) {
                for (int i = 0; i < obxList.size(); i++) {
                    obxList.get(i).setOBX1(Convert.toStr(i + 1));
                    result += obxList.get(i).toString();
                }
            }
        } else {
            result += new OBX().toString();
        }
        System.out.println(result);
        return lisCommonWSService.reportPostBack(result);
    }

    @ApiOperation("细菌报告回传接口")
    @ApiImplicitParam(name = "barcode", value = "检验条码号", dataType = "String", paramType = "path")
    @GetMapping("/germReportPostBack/{sampleno}")
    @ResponseBody
    public String germgetReportPostBack(@PathVariable String sampleno) {
        String result = "";
        MSH msh = new MSH();
        //region MSH初始化
        msh.setMSH1("|");
        msh.setMSH2("^~\\&");
        msh.setMSH3("LIS");
        msh.setMSH4("");//发送院区
        msh.setMSH5("HIS");
        msh.setMSH6("");//接收院区
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        msh.setMSH7(formatter.format(new Date()) + "+0800");
        msh.setMSH9("OUL^R21");
        msh.setMSH10(UUID.randomUUID().toString());
        msh.setMSH11("P");
        msh.setMSH12("2.4");
        msh.setMSH15("NE");
        msh.setMSH16("AL");
        msh.setMSH18("utf-8");
        //endregion
        result += msh.toString();
        PID pid = reportPostBackService.getPIDbySampleno(sampleno);
        if (pid != null) {
            pid.setPID1("1");
            //pid.setPID2("10000250");
            //pid.setPID3("10000250");
            result += pid.toString();
        }
        PV1 pv1 = reportPostBackService.getPV1bySampleno(sampleno);
        if (pv1 != null) {
            pv1.setPV1_1("1");
           // pv1.setPV1_19("20200701000003");
            result += pv1.toString();
        }
        ORC orc = reportPostBackService.getORCbySampleno(sampleno);
        if (orc != null) {
           // orc.getORC4().setORC4_1("2020070100000206");
            result += orc.toString();
        } else {
            result += new ORC().toString();
        }
        List<OBR> obrList = reportPostBackService.getOBRbySampleno(sampleno);
        if (obrList != null) {
            if (obrList.size() > 0) {
                for (int i = 0; i < obrList.size(); i++) {

                    result += obrList.get(i).toString();
                }
            }
        } else {
            result += new OBR().toString();
        }
        List<germOBX> obxList = reportPostBackService.getGermOBXBySampleno(sampleno);
        if (obxList != null) {
            if (obxList.size() > 0) {
                for (int i = 0; i < obxList.size(); i++) {
                    obxList.get(i).setOBX1(obxList.get(i).getOBX3().getOBX3_1());
                    result += obxList.get(i).toString();
                }
            }
        } else {
            result += new OBX().toString();
        }

        List<ZMIC> zmicList = reportPostBackService.getGermZMICBySampleno(sampleno);
        if (zmicList != null) {
            if (zmicList.size() > 0) {
                for (int i = 0; i < zmicList.size(); i++) {
                    result += zmicList.get(i).toString();
                }
            }
        } else {
            result += new ZMIC().toString();
        }
        System.out.println(result);
        return lisCommonWSService.reportPostBack(result);
    }

    @Autowired
    private ReturnAuditService returnAuditService;
    @GetMapping("/audit")
    @ResponseBody
    public String audit(){
        return    returnAuditService.getAudit().toString();
    }
}
