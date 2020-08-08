
package com.RealLis.specimenInhos.ws.wsdl.zhlisWsHerenLet;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.RealLis.specimenInhos.ws.wsdl.zhlisWsHerenLet package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _String_QNAME = new QName("http://172.16.1.36", "string");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.RealLis.specimenInhos.ws.wsdl.zhlisWsHerenLet
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LabChargeFee }
     * 
     */
    public LabChargeFee createLabChargeFee() {
        return new LabChargeFee();
    }

    /**
     * Create an instance of {@link WebTest }
     * 
     */
    public WebTest createWebTest() {
        return new WebTest();
    }

    /**
     * Create an instance of {@link LabBarMakeResponse }
     * 
     */
    public LabBarMakeResponse createLabBarMakeResponse() {
        return new LabBarMakeResponse();
    }

    /**
     * Create an instance of {@link ZhLisHerenResponse }
     * 
     */
    public ZhLisHerenResponse createZhLisHerenResponse() {
        return new ZhLisHerenResponse();
    }

    /**
     * Create an instance of {@link LabDownInfoDeptResponse }
     * 
     */
    public LabDownInfoDeptResponse createLabDownInfoDeptResponse() {
        return new LabDownInfoDeptResponse();
    }

    /**
     * Create an instance of {@link LabDownInfoDept }
     * 
     */
    public LabDownInfoDept createLabDownInfoDept() {
        return new LabDownInfoDept();
    }

    /**
     * Create an instance of {@link LabBarMake }
     * 
     */
    public LabBarMake createLabBarMake() {
        return new LabBarMake();
    }

    /**
     * Create an instance of {@link LabDownInfoStaffResponse }
     * 
     */
    public LabDownInfoStaffResponse createLabDownInfoStaffResponse() {
        return new LabDownInfoStaffResponse();
    }

    /**
     * Create an instance of {@link LabChargeFeeResponse }
     * 
     */
    public LabChargeFeeResponse createLabChargeFeeResponse() {
        return new LabChargeFeeResponse();
    }

    /**
     * Create an instance of {@link WebTestResponse }
     * 
     */
    public WebTestResponse createWebTestResponse() {
        return new WebTestResponse();
    }

    /**
     * Create an instance of {@link LabDownInfoItem }
     * 
     */
    public LabDownInfoItem createLabDownInfoItem() {
        return new LabDownInfoItem();
    }

    /**
     * Create an instance of {@link LabDownInfoFee }
     * 
     */
    public LabDownInfoFee createLabDownInfoFee() {
        return new LabDownInfoFee();
    }

    /**
     * Create an instance of {@link LabDownInfoFeeResponse }
     * 
     */
    public LabDownInfoFeeResponse createLabDownInfoFeeResponse() {
        return new LabDownInfoFeeResponse();
    }

    /**
     * Create an instance of {@link LabDownInfoAllResponse }
     * 
     */
    public LabDownInfoAllResponse createLabDownInfoAllResponse() {
        return new LabDownInfoAllResponse();
    }

    /**
     * Create an instance of {@link HelloWorldResponse }
     * 
     */
    public HelloWorldResponse createHelloWorldResponse() {
        return new HelloWorldResponse();
    }

    /**
     * Create an instance of {@link LabDownInfoStaff }
     * 
     */
    public LabDownInfoStaff createLabDownInfoStaff() {
        return new LabDownInfoStaff();
    }

    /**
     * Create an instance of {@link SendRiskValue }
     * 
     */
    public SendRiskValue createSendRiskValue() {
        return new SendRiskValue();
    }

    /**
     * Create an instance of {@link SetBarOrderStatus }
     * 
     */
    public SetBarOrderStatus createSetBarOrderStatus() {
        return new SetBarOrderStatus();
    }

    /**
     * Create an instance of {@link TransferHerenResponse }
     * 
     */
    public TransferHerenResponse createTransferHerenResponse() {
        return new TransferHerenResponse();
    }

    /**
     * Create an instance of {@link GetQueueNoResponse }
     * 
     */
    public GetQueueNoResponse createGetQueueNoResponse() {
        return new GetQueueNoResponse();
    }

    /**
     * Create an instance of {@link ZhLisHeren }
     * 
     */
    public ZhLisHeren createZhLisHeren() {
        return new ZhLisHeren();
    }

    /**
     * Create an instance of {@link SendRiskValueResponse }
     * 
     */
    public SendRiskValueResponse createSendRiskValueResponse() {
        return new SendRiskValueResponse();
    }

    /**
     * Create an instance of {@link HelloWorld }
     * 
     */
    public HelloWorld createHelloWorld() {
        return new HelloWorld();
    }

    /**
     * Create an instance of {@link SetBarOrderStatusResponse }
     * 
     */
    public SetBarOrderStatusResponse createSetBarOrderStatusResponse() {
        return new SetBarOrderStatusResponse();
    }

    /**
     * Create an instance of {@link GetQueueNo }
     * 
     */
    public GetQueueNo createGetQueueNo() {
        return new GetQueueNo();
    }

    /**
     * Create an instance of {@link LabDownInfoItemResponse }
     * 
     */
    public LabDownInfoItemResponse createLabDownInfoItemResponse() {
        return new LabDownInfoItemResponse();
    }

    /**
     * Create an instance of {@link LabDownInfoAll }
     * 
     */
    public LabDownInfoAll createLabDownInfoAll() {
        return new LabDownInfoAll();
    }

    /**
     * Create an instance of {@link TransferHeren }
     * 
     */
    public TransferHeren createTransferHeren() {
        return new TransferHeren();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://172.16.1.36", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

}
