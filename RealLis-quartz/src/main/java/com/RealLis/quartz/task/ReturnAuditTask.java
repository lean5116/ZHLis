package com.RealLis.quartz.task;

import com.RealLis.common.utils.DateUtils;
import com.RealLis.specimenInhos.domain.ReturnAudit.auditBody;
import com.RealLis.specimenInhos.domain.ReturnAudit.auditHead;
import com.RealLis.specimenInhos.domain.ReturnAudit.auditRes;
import com.RealLis.specimenInhos.service.ReturnAuditService;
import com.RealLis.specimenInhos.ws.service.LisCommonWS.LisCommonWSService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component("ReturnAuditTask")
public class ReturnAuditTask {
    @Autowired
    private LisCommonWSService lisCommonWSService;
    @Autowired
    private ReturnAuditService returnAuditService;

    private static final Logger log = LoggerFactory.getLogger(ReturnAuditTask.class);

    public void returnAudit(){
        List<auditBody> auditList = returnAuditService.getAudit();
        if(auditList!=null){
            if(auditList.size()>0){
                for (auditBody audit:auditList
                     ) {
                    auditHead  auditHead = new auditHead("LAB203",
                            DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss",new Date()),
                                    UUID.randomUUID().toString(),
                                    "01",
                                    "",
                                    "HIS",
                                    "xBzrURjFUl4Q1E9nTaCu5C==");
                    audit.setOrderId(audit.getOrderId().replaceAll(",","\",\""));
                    String inputString = '{'+auditHead.toString()+","+audit.toString()+'}';
                    String result = lisCommonWSService.returnAudit(inputString);
                    log.info(inputString);
                    log.info(result);
                    auditRes auditRes = JSON.parseObject(result,auditRes.class);
                    if("AA".equals(auditRes.getHead().getTradeStatus())){
                        int delFlag= returnAuditService.deleteByJlxh(audit.getJlxh());
                        log.info(" 报告号"+audit.getReportId() +" 删除标志:"+ Integer.toString(delFlag));
                    }
                }
            }
        }
    }
}
