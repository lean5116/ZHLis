package com.RealLis.quartz.task;

import com.RealLis.common.core.text.Convert;
import com.RealLis.common.utils.DateUtils;
import com.RealLis.common.utils.StringUtils;
import com.RealLis.specimenInhos.domain.PostBack.*;
import com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.ZMIC;
import com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.germOBX;
import com.RealLis.specimenInhos.domain.PostBack.reportPostBack.OBX;
import com.RealLis.specimenInhos.domain.ReturnAudit.auditHead;
import com.RealLis.specimenInhos.domain.ReturnAudit.auditRes;
import com.RealLis.specimenInhos.service.ReportPostBackService;
import com.RealLis.specimenInhos.service.ReturnAuditService;
import com.RealLis.specimenInhos.ws.service.LisCommonWS.LisCommonWSService;
import com.RealLis.specimenInhos.ws.service.zhlisWsHerenLet.zhlisWsHerenLetService;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component("ReportPostBackTask")
public class ReportPostBackTask {
    @Autowired
    private zhlisWsHerenLetService zhlisWsHerenLetService;
    @Autowired
    private ReportPostBackService reportPostBackService;
    @Autowired
    private LisCommonWSService lisCommonWSService;
    @Autowired
    private ReturnAuditService returnAuditService;

    public  void test(){
        System.out.println("test");
    }
    private static final Logger log = LoggerFactory.getLogger(ReportPostBackTask.class);

    public void reportPostBack(){
        List<PostList> postList = reportPostBackService.getPostList();
        if(postList!=null){
            if(postList.size()>0){
                for (PostList post:postList
                     ) {
                    if("CK01".equals(post.getEventName())){
                        CK01PostBack(post);
                    }else if("CK99".equals(post.getEventName())){
                        Ck99PostBack(post);
                    }
                }
            }
        }
    }
    public void CK01PostBack(PostList post){
        String result ="";
        if(reportPostBackService.updateTransfer(post.getJlxh())>0) {
            if (post.getMicType() == 0) {
                result = ReportPostBack(post.getEventData());
            } else if (post.getMicType() == 1) {
                result = germReportPostBack(post.getEventData());
            }
            if (result.contains("MSA|AA")) {
                reportPostBackService.deletePostList(post.getJlxh());
            }else {
                CK01PostBack(post);
            }
        }
    }

    public void Ck99PostBack(PostList post){
        if(reportPostBackService.updateTransfer(post.getJlxh())>0) {
            auditHead auditHead = new auditHead("LAB203",
                    DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", new Date()),
                    UUID.randomUUID().toString(),
                    "01",
                    "",
                    "HIS",
                    "xBzrURjFUl4Q1E9nTaCu5C==");
            post.setOrderId(post.getOrderId().replaceAll(",", "\",\""));
            String inputString = '{' + auditHead.toString() + "," + returnAuditToString(post) + '}';
            String result = lisCommonWSService.returnAudit(inputString);
            auditRes auditRes = JSON.parseObject(result, auditRes.class);
            if ("AA".equals(auditRes.getHead().getTradeStatus())) {
                reportPostBackService.deletePostList(post.getJlxh());
            }else{
                Ck99PostBack(post);
            }
        }
    }
    public static String returnAuditToString(PostList postList){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "\"Body\":{" +
                "\"patientID\":\"" + postList.getPatientId() + '\"' +
                ", \"visitNo\":\"" + postList.getVisitNo() + '\"' +
                ", \"orderId\":[\"" + postList.getOrderId() + "\"]" +
                ", \"reportId\":\"" + postList.getReportId() + '\"' +
                ", \"operDocId\":\"" + postList.getOperdocId() + '\"' +
                ", \"operDocName\":\"" + postList.getOperdocName() + '\"' +
                ", \"operTime\":\"" + formatter.format(postList.getOperTime()) + '\"' +
                '}';
    }
    public String germReportPostBack(String sampleno){
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
        }else{
            return "MSA|AA";
        }
        PV1 pv1 = reportPostBackService.getPV1bySampleno(sampleno);
        if (pv1 != null) {
            pv1.setPV1_1("1");
            result += pv1.toString();
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
        List<germOBX> obxList = reportPostBackService.getGermOBXBySampleno(sampleno);
        if (obxList != null) {
            if (obxList.size() > 0) {
                for (int i = 0; i < obxList.size(); i++) {
                    obxList.get(i).setOBX1(obxList.get(i).getOBX3().getOBX3_1());
                    result += obxList.get(i).toString().replace("\n"," ")+"\n";
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
        log.info(result);
        return lisCommonWSService.reportPostBack(result);
    }
    public String ReportPostBack(String sampleno){

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
            return "MSA|AA";
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
                log.info(Convert.toStr(obxList.size()));
                for (int i = 0; i < obxList.size(); i++) {
                    obxList.get(i).setOBX1(Convert.toStr(i + 1));
                    result += obxList.get(i).toString().replace("\n"," ")+"\n";

                }
            }
        } else {
            result += new OBX().toString();
        }
        log.info(result);
        return lisCommonWSService.reportPostBack(result);
    }


}
