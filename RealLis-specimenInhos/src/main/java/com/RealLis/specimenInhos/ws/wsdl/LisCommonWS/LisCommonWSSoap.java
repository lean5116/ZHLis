
package com.RealLis.specimenInhos.ws.wsdl.LisCommonWS;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "LisCommonWSSoap", targetNamespace = "http://tempuri.org")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface LisCommonWSSoap {


    /**
     * 
     * @param dataType
     * @param pInput
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "MessageIn", action = "http://tempuri.org/HEREN.SysProdu.LIS.BS.LisCommonWS.MessageIn")
    @WebResult(name = "MessageInResult", targetNamespace = "http://tempuri.org")
    @RequestWrapper(localName = "MessageIn", targetNamespace = "http://tempuri.org", className = "com.RealLis.specimenInhos.ws.wsdl.LisCommonWS.MessageIn")
    @ResponseWrapper(localName = "MessageInResponse", targetNamespace = "http://tempuri.org", className = "com.RealLis.specimenInhos.ws.wsdl.LisCommonWS.MessageInResponse")
    public String messageIn(
        @WebParam(name = "DataType", targetNamespace = "http://tempuri.org")
        String dataType,
        @WebParam(name = "pInput", targetNamespace = "http://tempuri.org")
        String pInput);

}