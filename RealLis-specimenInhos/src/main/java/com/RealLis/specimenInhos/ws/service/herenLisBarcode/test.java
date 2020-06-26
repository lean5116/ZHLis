package com.RealLis.specimenInhos.ws.service.herenLisBarcode;

import com.RealLis.specimenInhos.ws.wsdl.herenLisBarcode.InterfaceHr;
import com.RealLis.specimenInhos.ws.wsdl.herenLisBarcode.InterfaceHrSoap;
import com.RealLis.specimenInhos.ws.wsdl.herenLisBarcode.UfPack;

public class test {
    public static void main(String[] args) {
        InterfaceHr interfaceHr = new InterfaceHr();
        InterfaceHrSoap interfaceHrSoap =interfaceHr.getInterfaceHrSoap();
        UfPack ufPack = new UfPack();
        ufPack.setAsCzz("6645");
        ufPack.setAsBarcode("0062562121");
        String response = interfaceHrSoap.ufPack(ufPack.getAsCzz(),ufPack.getAsBarcode());
        System.out.println(response);
    }
}
