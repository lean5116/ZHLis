package com.RealLis.specimenInhos.controller;

import com.RealLis.common.annotation.RepeatSubmit;
import com.RealLis.common.core.controller.BaseController;
import com.RealLis.common.core.domain.AjaxResult;
import com.RealLis.common.core.page.TableDataInfo;
import com.RealLis.common.core.text.Convert;
import com.RealLis.common.utils.StringUtils;
import com.RealLis.common.utils.WebServiceUtil;
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
import org.apache.poi.util.StringUtil;
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
    private LJytmxxService lJytmxxService;
    @Autowired
    private ReportPostBackService reportPostBackService;
    @Autowired
    private LisCommonWSService lisCommonWSService;
    @Autowired
    private ViLisAdviseHerenService viLisAdviseHerenService;

    @GetMapping("")
    public String specimenInhos(String appDeptCode, String userCode, String inpatient_id, String operation, String isInhos, String patientClass, Model model) {
        List<Formatter> formatters = lSampletypeService.getLSampleTypeFormatter(null);
        //返回样本类型字典用于 格式化样本类型
        model.addAttribute("SampleTypeFormatter", JSON.toJSONString(formatters));
        List<GyHyxm> gyHyxmsList = viLisBarcodeInfoService.queryHyxm();
        //返回标本类型字典用于 格式化标本类型
        model.addAttribute("BGBS", JSON.toJSONString(gyHyxmsList));
        if (inpatient_id != null && StringUtils.isEmpty(operation)) {
            model.addAttribute("inpatientId", inpatient_id);
            if (isInhos == null) {
                model.addAttribute("departmentName", "入院准备中心");
                model.addAttribute("isInhos", "-1");
                model.addAttribute("operation", "99");
                //入院准备中心写入 综合服务中心(临) -的科室代码
                model.addAttribute("preAdmission", "10108020");
            } else if ("1".equals(isInhos)) {
                model.addAttribute("departmentName", "急诊检验");
                model.addAttribute("isInhos", "-2");
                //     model.addAttribute("department", "-2");
                model.addAttribute("patientClass", patientClass);
                model.addAttribute("operation", "99");
            } else if ("4".equals(isInhos)) {
                model.addAttribute("departmentName", "个人查询");
                //     model.addAttribute("department", "-1");
                model.addAttribute("isInhos", "4");
                model.addAttribute("operation", "99");
            }
        } else if (inpatient_id != null && !StringUtils.isEmpty(operation)) {
            model.addAttribute("inpatientId", inpatient_id);
            model.addAttribute("departmentName", "手术科室");
            //model.addAttribute("department", "-3");
            model.addAttribute("isInhos", "3");
            model.addAttribute("operation", "1");
        } else {
            if (appDeptCode != null && userCode != null) {
                GyKsdm gyksdm = viLisBarcodeInfoService.getKsdmByKsdm(appDeptCode);
                model.addAttribute("department", appDeptCode);
                model.addAttribute("userCode", userCode);
                model.addAttribute("departmentName", gyksdm.getKsmc());
                model.addAttribute("userName", userCode);
                model.addAttribute("isInhos", "1");
                model.addAttribute("operation", "99");
            } else {
                return "error";
            }
        }
        return "specimenInhos/index";
    }

    @GetMapping("/createLogistics/{deptId}/{userId}")
    public String createLogistics(@PathVariable String deptId, @PathVariable String userId, String preAdmission, String departmentName,Model model) {
        model.addAttribute("department", deptId);
        model.addAttribute("userCode", userId);
        model.addAttribute("departmentName",departmentName);
        if(preAdmission!=null&&preAdmission.trim().length()>0) {
            model.addAttribute("preAdmission", preAdmission);
        }
        if ("10401000".equals(deptId)) {
            return "specimenInhos/CreateLogisticsInfected";
        }
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
        List<ViLisBarcodeInfo> viLisBarcodeInfoList;
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
            viLisBarcodeInfo.setSampleState("3,4");
        }
        if ("cancellationReturn".equals(tableId)) {
            logger.info(tableId + "，增加条码状态为作废的数据");
            viLisBarcodeInfo.setSampleState("-1,-2");
            logger.info(viLisBarcodeInfo.getBarstatus());
        }
        if ("overtimeBarcode".equals(tableId)) {
            logger.info("进入tabOvertimeBarcode，增加条码状态为0的数据");
            viLisBarcodeInfo.setSampleState("0,1");
        }
        if ("specimenLogistics".equals(tableId)) {
            LLogistics lLogistics = new LLogistics();
            lLogistics.setParams(viLisBarcodeInfo.getParams());
            //增加入院准备中心 科室代码改写
            String deptCode = "";
            try {
                deptCode = viLisBarcodeInfo.getParams().get("preAdmission").toString();
            } catch (Exception e) {
            }
            if (StringUtils.isNotNull(deptCode) && StringUtils.isNotEmpty(deptCode)) {
                lLogistics.setBqdm(deptCode);
            }
            deptCode = viLisBarcodeInfo.getDepartment();
            if (StringUtils.isNotNull(deptCode) && StringUtils.isNotEmpty(deptCode)) {
                lLogistics.setBqdm(deptCode);
            }
            List<LLogistics> logisticses = lLogisticsService.getLlogisticsList(lLogistics);
            return getDataTable(logisticses);
        } else {
            String isInhos ="1" ;
            try{
                isInhos = viLisBarcodeInfo.getParams().get("isInhos").toString();
            }catch (Exception e){
                isInhos ="1";
            }
            if("1".equals(viLisBarcodeInfo.getPreAdmission())) {
                isInhos="-1";
                viLisBarcodeInfo.getParams().put("isInhos",-1);
            }
            if("1".equals(isInhos)){
                viLisBarcodeInfoList = viLisBarcodeInfoService.getInfoList(viLisBarcodeInfo);
                for(int i =0;i<viLisBarcodeInfoList.size();i++){
                    if(!viLisBarcodeInfo.getDepartment().equals(viLisBarcodeInfoList.get(i).getDepartment())){
                        viLisBarcodeInfoList.get(i).setTrans("转");
                    }
                }
            }else {
                viLisBarcodeInfoList = viLisBarcodeInfoService.getInfoList(viLisBarcodeInfo);
            }
            if ("overtimeBarcode".equals(tableId)) {
                List<ViLisBarcodeInfo> viLisBarcodeInfoListFilter = new ArrayList<>();
                for (ViLisBarcodeInfo viLisBarcodeInfoChildren : viLisBarcodeInfoList
                ) {
                    Date DateNow = new Date();
                    Long overTime = (viLisBarcodeInfoChildren.getRequettime().getTime() - DateNow.getTime()) / (24 * 60 * 60 * 1000);
                    if (overTime < -3) {
                        viLisBarcodeInfoChildren.setOverTime(Long.toString(overTime + 3) + "天");
                        viLisBarcodeInfoListFilter.add(viLisBarcodeInfoChildren);
                    }
                }
                viLisBarcodeInfoList = new ArrayList<>(viLisBarcodeInfoListFilter);
            }
            return getDataTable(viLisBarcodeInfoList);
        }
    }

    @RepeatSubmit(timeOut = 20)
    @ApiOperation("异步生成检验条码")
    @ApiImplicitParam(name = "deptId", value = "科室id", dataType = "String")
    @PostMapping("/GenerateBarcode")
    @ResponseBody
    private void GenerateBarcode(String deptId, String isInhos, String operation, String inpatientId) {
        ViLisAdviseHeren params = new ViLisAdviseHeren();
        params.setOrderStatus("1");
        params.setSampleFlag("0");
        if (deptId.length() > 0) {
            params.setDeptcode(deptId);
        } else if ("-1".equals(isInhos)) {
            // params.setPreinhosstatus("1");
        } else if (operation.length() > 0) {
            // params.setPreinhosstatus("5");
        }
        if (inpatientId.length() > 0) {
            params.setVisitnumber(inpatientId);
        }
        List<ViLisAdviseHeren> viLisAdviseHerenList = viLisAdviseHerenService.getDistinctAdviseList(params);
        if (viLisAdviseHerenList != null) {
            for (ViLisAdviseHeren viLisAdviseHeren : viLisAdviseHerenList) {
                System.out.println(viLisAdviseHeren.getVisitnumber());
                logger.info(viLisAdviseHeren.getVisitnumber() + zhlisWsHerenLetService.LabBarMake(viLisAdviseHeren.getVisitnumber()));
            }
        }
    }

    @ApiOperation("获取单个条码信息")
    @ApiImplicitParam(name = "barcode", value = "条码号", dataType = "String", paramType = "path")
    @GetMapping("/getBarcode/{barcode}")
    @ResponseBody
    public AjaxResult getBarcode(@PathVariable String barcode) {
        ViLisBarcodeInfo response = viLisBarcodeInfoService.getInfo(barcode);
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
    public AjaxResult Packing(String barcodes, String userCode, String preAdmission,String deptCode,String departmentName) {
        if (barcodes != null && userCode != null) {
            String wsdlUrl = "http://172.16.0.100:6700/hyyy_wsbarcode/interface_hr.asmx?WSDL";
            String response = "";
            try {
                System.out.println(preAdmission);
                if (StringUtils.isNotNull(preAdmission) && StringUtils.isNotEmpty(preAdmission) &&preAdmission.length()>0 &&preAdmission.trim()!="null") {
                    response = WebServiceUtil.commonWsService(wsdlUrl, "uf_pack2", "入院准备中心", barcodes, preAdmission, "入院准备中心")[0].toString();
                } else {
                    response = WebServiceUtil.commonWsService(wsdlUrl, "uf_pack2", userCode, barcodes,deptCode,departmentName)[0].toString();
                }
            } catch (Exception e) {
                return error(e.getMessage());
            }
            String result = XmlToJson(response);
            PackingResponse packing;
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

    @PostMapping("/logistics/infected")
    @ResponseBody
    public TableDataInfo createLogisticsInfected() {
        ViLisBarcodeInfo params = new ViLisBarcodeInfo();
        params.setDepartment("10401000");
        params.setBarstatus("2");
        List<ViLisBarcodeInfo> viLisBarcodeInfoList = viLisBarcodeInfoService.getInfoInfect(params);
        return getDataTable(viLisBarcodeInfoList);
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

    @GetMapping("/getHyxm")
    @ResponseBody
    public AjaxResult getHyxm() {
        List<GyHyxm> gyHyxmsList = viLisBarcodeInfoService.queryHyxm();
        return success(JSON.toJSONString(gyHyxmsList));
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
                                zhlisWsHerenLetService.SetBarOrderStatus(barcode[i], "11");
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
                                System.out.println(zhlisWsHerenLetService.SetBarOrderStatus(barcode[i], "3"));//标本已采集
                            }
                        } else if ("confirmCancel".equals(czfs)) {
                            Map<String, Object> params = new HashMap<>();
                            params.put("confirmCancel", 0);
                            lJytmxx.setParams(params);
                            if (lJytmxxService.updateByBarcode(lJytmxx) > 0) {
                                n++;
                                result = Integer.toString(n);
                                zhlisWsHerenLetService.SetBarOrderStatus(barcode[i], "2"); //改会已打印
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
    public String audit() {
        return returnAuditService.getAudit().toString();
    }

    @PostMapping("/updateSpecimencode")
    @ResponseBody
    public AjaxResult updateSpecimencode(String barcode2, String specimencode) {
        LJytmxx lJytmxx = new LJytmxx();
        lJytmxx.setDoctadviseno(barcode2);
        lJytmxx.setSampletype(specimencode);
        return toAjax(lJytmxxService.updateByBarcode(lJytmxx));
    }
}
