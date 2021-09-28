package com.RealLis.specimenInhos.ws.service.LisCommonWS;

import com.RealLis.common.utils.DateUtils;
import com.RealLis.common.utils.WebServiceUtil;
import com.RealLis.specimenInhos.ws.wsdl.LisCommonWS.LisCommonWS;
import com.RealLis.specimenInhos.ws.wsdl.LisCommonWS.LisCommonWSSoap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LisCommonWSServiceImpl implements LisCommonWSService{
    private static final Logger logger = LoggerFactory.getLogger(LisCommonWSServiceImpl.class);
    private final String WSDL_URL = "http://172.16.18.50:57772/csp/healthshare/taiyi/services/HEREN.SysProdu.LIS.BS.LisCommonWS.CLS?WSDL=1";
    LisCommonWS lisCommonWS= new LisCommonWS();
    LisCommonWSSoap lisCommonWSSoap = lisCommonWS.getLisCommonWSSoap();
    @Override
    public String reportPostBack(String inputString) {
        String resp = "";
        Date startDate = new Date();
        try {
            resp=  lisCommonWSSoap.messageIn("HL7",inputString);
        }catch (Exception e){
            logger.error("error: {}", e.getMessage(), e);
            logger.error("接口调调用错误");
        }
        Date endDate = new Date();
        logger.info(inputString+"--||返回内容:"+resp+"--||调用结束，接口消耗时间:"+
//                ((endDate.getTime()-startDate.getTime())/(60 * 1000)) / 60+"秒"
                DateUtils.getDatePoor(endDate,startDate)
        );
        return  resp;
    }

    @Override
    public String returnAudit(String inputString) {
        String resp = "";
        Date startDate = new Date();
        try {
            resp=  lisCommonWSSoap.messageIn("HL7",inputString);
        }catch (Exception e){
            logger.error("error: {}", e.getMessage(), e);
            logger.error("接口调调用错误");
        }
        Date endDate = new Date();
        logger.info(inputString+"--||返回内容:"+resp+"--||调用结束，接口消耗时间:"+((endDate.getTime()-startDate.getTime())/(60 * 1000)) % 60+"秒");
        return  resp;
    }
}
