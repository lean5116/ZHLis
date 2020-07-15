package com.RealLis.specimenInhos.ws.service.zhlisWsHerenLet;

import com.RealLis.specimenInhos.ws.wsdl.zhlisWsHerenLet.WebServiceLis;
import com.RealLis.specimenInhos.ws.wsdl.zhlisWsHerenLet.WebServiceLisSoap;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class zhilisWsHerenLetImpl  implements zhlisWsHerenLetService {
    WebServiceLis webServiceLis = new WebServiceLis();
    WebServiceLisSoap  webServiceLisSoap = webServiceLis.getWebServiceLisSoap();
    @Override
    public String LabBarMake(String patientId) {
        String response = webServiceLisSoap.labBarMake(patientId);
        return response;
    }

    @Override
    public String SetBarOrderStatus(String strBarcode, String strOrderStatus) {
        String response = webServiceLisSoap.setBarOrderStatus(strBarcode,strOrderStatus);
        System.out.println(response);
        return response;
    }
}
