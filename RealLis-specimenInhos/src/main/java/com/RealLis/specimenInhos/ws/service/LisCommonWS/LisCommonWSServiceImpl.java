package com.RealLis.specimenInhos.ws.service.LisCommonWS;

import com.RealLis.specimenInhos.ws.wsdl.LisCommonWS.LisCommonWS;
import com.RealLis.specimenInhos.ws.wsdl.LisCommonWS.LisCommonWSSoap;
import org.springframework.stereotype.Service;

@Service
public class LisCommonWSServiceImpl implements LisCommonWSService{
    LisCommonWS lisCommonWS= new LisCommonWS();
    LisCommonWSSoap lisCommonWSSoap = lisCommonWS.getLisCommonWSSoap();

    @Override
    public String reportPostBack(String inputString) {
        return  lisCommonWSSoap.messageIn("HL7",inputString);
    }
}
