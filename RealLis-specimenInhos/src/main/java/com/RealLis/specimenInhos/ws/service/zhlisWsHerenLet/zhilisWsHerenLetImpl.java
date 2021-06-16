package com.RealLis.specimenInhos.ws.service.zhlisWsHerenLet;

import com.RealLis.common.utils.WebServiceUtil;
import com.RealLis.specimenInhos.ws.service.LisCommonWS.LisCommonWSServiceImpl;
import com.RealLis.specimenInhos.ws.wsdl.zhlisWsHerenLet.WebServiceLis;
import com.RealLis.specimenInhos.ws.wsdl.zhlisWsHerenLet.WebServiceLisSoap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class zhilisWsHerenLetImpl  implements zhlisWsHerenLetService {
    WebServiceLis webServiceLis = new WebServiceLis();
    WebServiceLisSoap  webServiceLisSoap = webServiceLis.getWebServiceLisSoap();
    private static final Logger logger = LoggerFactory.getLogger(zhilisWsHerenLetImpl.class);
    private final String WSDL_URL = "http://172.16.17.94:20202/WebServiceLis.asmx?WSDL";
    @Override
    public String LabBarMake(String patientId) {
        String resp = "";
        try {
            Object[] result = WebServiceUtil.commonWsService(WSDL_URL, "LabBarMake",patientId);
            resp =result[0].toString();
        }catch (Exception e){
            logger.error("error: {}", e.getMessage(), e);
            logger.error("接口调调用错误");
        }
        return  resp;
    }
    //向平台发送条形码状态，strBarCode要求条码全码 0=申请中(可退费)；1=已申请；2=条码已打印；3=标本已采集；5=标本已核收；
    // 6=已执行（上机）；D= 取消中；P初步报告；F=确认报告，11=LIS退回标本；H=标本已送出；Y=送达
    @Override
    public String SetBarOrderStatus(String strBarcode, String strOrderStatus) {
        String resp = "";
        try {
            Object[] result = WebServiceUtil.commonWsService(WSDL_URL, "SetBarOrderStatus",strBarcode,strOrderStatus);
            resp =result[0].toString();
        }catch (Exception e){
            logger.error("error: {}", e.getMessage(), e);
            logger.error("接口调调用错误");
        }
        return  resp;
    }
}
