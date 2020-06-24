package com.RealLis.specimenInhos.controller;

import com.RealLis.common.core.controller.BaseController;
import com.RealLis.common.core.domain.AjaxResult;
import com.RealLis.common.core.page.TableDataInfo;
import com.RealLis.specimenInhos.domain.*;
import com.RealLis.specimenInhos.service.IViLisBarcodeInfoService;
import com.RealLis.specimenInhos.service.LLogisticsService;
import com.RealLis.specimenInhos.service.LSampletypeService;
import com.RealLis.specimenInhos.ws.wsdl.herenLisBarcode.InterfaceHr;
import com.RealLis.specimenInhos.ws.wsdl.herenLisBarcode.InterfaceHrSoap;
import com.RealLis.specimenInhos.ws.wsdl.herenLisBarcode.UfPack;
import com.alibaba.fastjson.JSON;
import de.odysseus.staxon.json.JsonXMLConfig;
import de.odysseus.staxon.json.JsonXMLConfigBuilder;
import de.odysseus.staxon.json.JsonXMLInputFactory;
import de.odysseus.staxon.json.JsonXMLOutputFactory;
import de.odysseus.staxon.xml.util.PrettyXMLEventWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.RealLis.specimenInhos.utils.XmlConvert.XmlToJson;


@Controller
@RequestMapping("/specimenInhos")
public class SpecimenInhosController extends BaseController {

    @Autowired
    private  IViLisBarcodeInfoService viLisBarcodeInfoService;
    @Autowired
    private LSampletypeService lSampletypeService;
    @Autowired
    private LLogisticsService lLogisticsService;
    @GetMapping("/{deptId}/{userId}")
    public String specimenInhos(@PathVariable String deptId , @PathVariable String userId, Model model){
        model.addAttribute("department",deptId);
        model.addAttribute("userCode",userId);
        model.addAttribute("departmentName",deptId);
        model.addAttribute("userName",userId);
        List<Formatter> formatters = lSampletypeService.getLSampleTypeFormatter(null);
        model.addAttribute("SampleTypeFormatter", JSON.toJSONString(formatters));
        return "specimenInhos/index";
    }

    @PostMapping(value = "/list/{tableId}")
    @ResponseBody
    public TableDataInfo list(@PathVariable String tableId,ViLisBarcodeInfo viLisBarcodeInfo) throws ParseException {
        startPage();
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        List<ViLisBarcodeInfo> viLisBarcodeInfoList =new ArrayList<ViLisBarcodeInfo>();
        if(tableId.equals("collectionComplete")){
            logger.info("进入tabCollectionComplete，修改kssj与jssj为采集时间");
            viLisBarcodeInfo.setStartSamplingtime(sdf.parse(viLisBarcodeInfo.getParams().get("beginTime").toString()));
            viLisBarcodeInfo.setEndSamplingtime(sdf.parse(viLisBarcodeInfo.getParams().get("endTime").toString()));
        }else{
            viLisBarcodeInfo.setStartRequettime(sdf.parse(viLisBarcodeInfo.getParams().get("beginTime").toString()));
            viLisBarcodeInfo.setEndRequettime(sdf.parse(viLisBarcodeInfo.getParams().get("endTime").toString()));
        }
        viLisBarcodeInfo.setPatienttype("2"); //固定为住院病人
        if("collectionConfirmation".equals(tableId)){
            viLisBarcodeInfo.setSampleState("1");
        }
        if("collectionComplete".equals(tableId)){
            viLisBarcodeInfo.setSampleState("2");
        }
        if("receiveComplete".equals(tableId)){
            logger.info("进入"+tableId);
            viLisBarcodeInfo.setSampleState("3");
        }
        if("cancellationReturn".equals(tableId)){
            logger.info(tableId+"，增加条码状态为作废的数据");
            viLisBarcodeInfo.setSampleState("1,-2");
            logger.info(viLisBarcodeInfo.getBarstatus());
        }
        if("overtimeBarcode".equals(tableId)){
            logger.info("进入tabOvertimeBarcode，增加条码状态为0的数据");
            viLisBarcodeInfo.setSampleState("-1,0");

        }

        if("specimenLogistics".equals(tableId)){
            LLogistics lLogistics = new LLogistics();
            lLogistics.setParams(viLisBarcodeInfo.getParams());
            lLogistics.setBqdm(viLisBarcodeInfo.getDepartment());
            List<LLogistics> logisticses = lLogisticsService.getLlogistics(lLogistics);
            return getDataTable(logisticses);
        }else {
            viLisBarcodeInfoList = viLisBarcodeInfoService.selectBarcodeList(viLisBarcodeInfo);
            return getDataTable(viLisBarcodeInfoList);
        }
    }
    @GetMapping("/createLogistics/{deptId}/{userId}")
    public String createLogistics(@PathVariable String deptId,@PathVariable  String userId,Model model){
        model.addAttribute("department",deptId);
        model.addAttribute("userCode",userId);
        return "specimenInhos/CreateLogistics";
    }

    @GetMapping("/getBarcode/{barcode}")
    @ResponseBody
    public AjaxResult getBarcode(@PathVariable String barcode){
        ViLisBarcodeInfo viLisBarcodeInfo = new ViLisBarcodeInfo();
        viLisBarcodeInfo.setBarcode(barcode);
        ViLisBarcodeInfo response = viLisBarcodeInfoService.getInfoByBarcode(viLisBarcodeInfo);
        if(response!=null){
            return success(JSON.toJSONString(response));
        }else {
            return error("未找到条码");
        }
    }

    @PostMapping("/Packing")
    @ResponseBody
    public AjaxResult Packing( String barcodes,String userCode){
        InterfaceHr interfaceHr = new InterfaceHr();
        InterfaceHrSoap interfaceHrSoap =interfaceHr.getInterfaceHrSoap();
        UfPack ufPack = new UfPack();
        ufPack.setAsCzz(userCode);
        ufPack.setAsBarcode(barcodes);
        System.out.println(userCode);
        String response = interfaceHrSoap.ufPack(ufPack.getAsCzz(),ufPack.getAsBarcode());
        String result = XmlToJson(response);
        System.out.println(result);
        PackingResponse packing = new PackingResponse();
        packing = JSON.parseObject(result,PackingResponse.class);
        if("-1".equals(packing.getBody().getRtncode())){
            return error(result);
        }else{
            return success(result);
        }
    }
    @GetMapping("/LogisticsDetail/{wlbh}/{wlzt}")
    public String LogisticDetail(@PathVariable  String wlbh,@PathVariable String wlzt, Model model){
        model.addAttribute("wlbh",wlbh);
        model.addAttribute("wlzt",wlzt);
        LLogistics lLogistics = new LLogistics();
        lLogistics.setWlbh(wlbh);
        LLogistics logisticses = lLogisticsService.getLlogisticsByWlbh(lLogistics);
        if(logisticses!=null ){
            model.addAttribute("cjsj",logisticses.getCjsj());
            model.addAttribute("dbsj",logisticses.getDbsj());
            model.addAttribute("yssj",logisticses.getYssj());
            model.addAttribute("ddsj",logisticses.getDdsj());
        }
        return "specimenInhos/LogisticsDetail";
    }

    @PostMapping("/lLoginsticsDetail/list/{wlbh}")
    @ResponseBody
    public TableDataInfo lLogisticDetail(@PathVariable  String wlbh){
        startPage();
        List<LLogisticsDetailVO> lLogisticsDetailVO =  lLogisticsService.getLlogisticsDetail(wlbh);
        return getDataTable(lLogisticsDetailVO);
    }


}
