package com.RealLis.specimenInhos.ws.service.LisCommonWS;

import com.RealLis.common.utils.WebServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LisCommonWSServiceImpl implements LisCommonWSService{
    private static final Logger logger = LoggerFactory.getLogger(LisCommonWSServiceImpl.class);
    private final String WSDL_URL = "http://172.16.18.50:57772/csp/healthshare/taiyi/services/HEREN.SysProdu.LIS.BS.LisCommonWS.CLS?WSDL=1";

    @Override
    public String reportPostBack(String inputString) {
        String resp = "";
        try {
            Object[] result = WebServiceUtil.commonWsService(WSDL_URL, "MessageIn","HL7" ,inputString);
            resp =result[0].toString();
        }catch (Exception e){
            logger.error("error: {}", e.getMessage(), e);
            logger.error("接口调调用错误");
        }
        return  resp;
    }

    @Override
    public String returnAudit(String inputString) {
        String resp = "";
        try {
            Object[] result = WebServiceUtil.commonWsService(WSDL_URL, "MessageIn", "JSON",inputString);
            resp =result[0].toString();
        }catch (Exception e){
            logger.error("error: {}", e.getMessage(), e);
            logger.error("接口调用错误");
        }
        return  resp;
    }
}
