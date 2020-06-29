<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://172.16.1.36" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" targetNamespace="http://172.16.1.36" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://172.16.1.36">
      <s:element name="HelloWorld">
        <s:complexType />
      </s:element>
      <s:element name="HelloWorldResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="HelloWorldResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="zhLisHeren">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="strMessage" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="strDataType" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="zhLisHerenResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="zhLisHerenResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="LabBarMake">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="strPatientID" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="LabBarMakeResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="LabBarMakeResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="LabDownInfoAll">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="strDownOrder" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="LabDownInfoAllResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="LabDownInfoAllResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="LabDownInfoDept">
        <s:complexType />
      </s:element>
      <s:element name="LabDownInfoDeptResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="LabDownInfoDeptResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="LabDownInfoStaff">
        <s:complexType />
      </s:element>
      <s:element name="LabDownInfoStaffResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="LabDownInfoStaffResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="LabDownInfoItem">
        <s:complexType />
      </s:element>
      <s:element name="LabDownInfoItemResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="LabDownInfoItemResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="LabDownInfoFee">
        <s:complexType />
      </s:element>
      <s:element name="LabDownInfoFeeResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="LabDownInfoFeeResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SetBarOrderStatus">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="strBarCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="strOrderStatus" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SetBarOrderStatusResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SetBarOrderStatusResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="LabChargeFee">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="strBarCode" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="intChargeStatus" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="LabChargeFeeResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="LabChargeFeeResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SendRiskValue">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="strSampleNo" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SendRiskValueResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SendRiskValueResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetQueueNo">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="strPatientId" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetQueueNoResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetQueueNoResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="WebTest">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="strmess" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="WebTestResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="WebTestResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="string" nillable="true" type="s:string" />
    </s:schema>
  </wsdl:types>
  <wsdl:message name="HelloWorldSoapIn">
    <wsdl:part name="parameters" element="tns:HelloWorld" />
  </wsdl:message>
  <wsdl:message name="HelloWorldSoapOut">
    <wsdl:part name="parameters" element="tns:HelloWorldResponse" />
  </wsdl:message>
  <wsdl:message name="zhLisHerenSoapIn">
    <wsdl:part name="parameters" element="tns:zhLisHeren" />
  </wsdl:message>
  <wsdl:message name="zhLisHerenSoapOut">
    <wsdl:part name="parameters" element="tns:zhLisHerenResponse" />
  </wsdl:message>
  <wsdl:message name="LabBarMakeSoapIn">
    <wsdl:part name="parameters" element="tns:LabBarMake" />
  </wsdl:message>
  <wsdl:message name="LabBarMakeSoapOut">
    <wsdl:part name="parameters" element="tns:LabBarMakeResponse" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoAllSoapIn">
    <wsdl:part name="parameters" element="tns:LabDownInfoAll" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoAllSoapOut">
    <wsdl:part name="parameters" element="tns:LabDownInfoAllResponse" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoDeptSoapIn">
    <wsdl:part name="parameters" element="tns:LabDownInfoDept" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoDeptSoapOut">
    <wsdl:part name="parameters" element="tns:LabDownInfoDeptResponse" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoStaffSoapIn">
    <wsdl:part name="parameters" element="tns:LabDownInfoStaff" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoStaffSoapOut">
    <wsdl:part name="parameters" element="tns:LabDownInfoStaffResponse" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoItemSoapIn">
    <wsdl:part name="parameters" element="tns:LabDownInfoItem" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoItemSoapOut">
    <wsdl:part name="parameters" element="tns:LabDownInfoItemResponse" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoFeeSoapIn">
    <wsdl:part name="parameters" element="tns:LabDownInfoFee" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoFeeSoapOut">
    <wsdl:part name="parameters" element="tns:LabDownInfoFeeResponse" />
  </wsdl:message>
  <wsdl:message name="SetBarOrderStatusSoapIn">
    <wsdl:part name="parameters" element="tns:SetBarOrderStatus" />
  </wsdl:message>
  <wsdl:message name="SetBarOrderStatusSoapOut">
    <wsdl:part name="parameters" element="tns:SetBarOrderStatusResponse" />
  </wsdl:message>
  <wsdl:message name="LabChargeFeeSoapIn">
    <wsdl:part name="parameters" element="tns:LabChargeFee" />
  </wsdl:message>
  <wsdl:message name="LabChargeFeeSoapOut">
    <wsdl:part name="parameters" element="tns:LabChargeFeeResponse" />
  </wsdl:message>
  <wsdl:message name="SendRiskValueSoapIn">
    <wsdl:part name="parameters" element="tns:SendRiskValue" />
  </wsdl:message>
  <wsdl:message name="SendRiskValueSoapOut">
    <wsdl:part name="parameters" element="tns:SendRiskValueResponse" />
  </wsdl:message>
  <wsdl:message name="GetQueueNoSoapIn">
    <wsdl:part name="parameters" element="tns:GetQueueNo" />
  </wsdl:message>
  <wsdl:message name="GetQueueNoSoapOut">
    <wsdl:part name="parameters" element="tns:GetQueueNoResponse" />
  </wsdl:message>
  <wsdl:message name="WebTestSoapIn">
    <wsdl:part name="parameters" element="tns:WebTest" />
  </wsdl:message>
  <wsdl:message name="WebTestSoapOut">
    <wsdl:part name="parameters" element="tns:WebTestResponse" />
  </wsdl:message>
  <wsdl:message name="HelloWorldHttpGetIn" />
  <wsdl:message name="HelloWorldHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="zhLisHerenHttpGetIn">
    <wsdl:part name="strMessage" type="s:string" />
    <wsdl:part name="strDataType" type="s:string" />
  </wsdl:message>
  <wsdl:message name="zhLisHerenHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="LabBarMakeHttpGetIn">
    <wsdl:part name="strPatientID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="LabBarMakeHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoAllHttpGetIn">
    <wsdl:part name="strDownOrder" type="s:string" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoAllHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoDeptHttpGetIn" />
  <wsdl:message name="LabDownInfoDeptHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoStaffHttpGetIn" />
  <wsdl:message name="LabDownInfoStaffHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoItemHttpGetIn" />
  <wsdl:message name="LabDownInfoItemHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoFeeHttpGetIn" />
  <wsdl:message name="LabDownInfoFeeHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="SetBarOrderStatusHttpGetIn">
    <wsdl:part name="strBarCode" type="s:string" />
    <wsdl:part name="strOrderStatus" type="s:string" />
  </wsdl:message>
  <wsdl:message name="SetBarOrderStatusHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="LabChargeFeeHttpGetIn">
    <wsdl:part name="strBarCode" type="s:string" />
    <wsdl:part name="intChargeStatus" type="s:string" />
  </wsdl:message>
  <wsdl:message name="LabChargeFeeHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="SendRiskValueHttpGetIn">
    <wsdl:part name="strSampleNo" type="s:string" />
  </wsdl:message>
  <wsdl:message name="SendRiskValueHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetQueueNoHttpGetIn">
    <wsdl:part name="strPatientId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetQueueNoHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="WebTestHttpGetIn">
    <wsdl:part name="strmess" type="s:string" />
  </wsdl:message>
  <wsdl:message name="WebTestHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="HelloWorldHttpPostIn" />
  <wsdl:message name="HelloWorldHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="zhLisHerenHttpPostIn">
    <wsdl:part name="strMessage" type="s:string" />
    <wsdl:part name="strDataType" type="s:string" />
  </wsdl:message>
  <wsdl:message name="zhLisHerenHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="LabBarMakeHttpPostIn">
    <wsdl:part name="strPatientID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="LabBarMakeHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoAllHttpPostIn">
    <wsdl:part name="strDownOrder" type="s:string" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoAllHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoDeptHttpPostIn" />
  <wsdl:message name="LabDownInfoDeptHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoStaffHttpPostIn" />
  <wsdl:message name="LabDownInfoStaffHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoItemHttpPostIn" />
  <wsdl:message name="LabDownInfoItemHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="LabDownInfoFeeHttpPostIn" />
  <wsdl:message name="LabDownInfoFeeHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="SetBarOrderStatusHttpPostIn">
    <wsdl:part name="strBarCode" type="s:string" />
    <wsdl:part name="strOrderStatus" type="s:string" />
  </wsdl:message>
  <wsdl:message name="SetBarOrderStatusHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="LabChargeFeeHttpPostIn">
    <wsdl:part name="strBarCode" type="s:string" />
    <wsdl:part name="intChargeStatus" type="s:string" />
  </wsdl:message>
  <wsdl:message name="LabChargeFeeHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="SendRiskValueHttpPostIn">
    <wsdl:part name="strSampleNo" type="s:string" />
  </wsdl:message>
  <wsdl:message name="SendRiskValueHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetQueueNoHttpPostIn">
    <wsdl:part name="strPatientId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetQueueNoHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="WebTestHttpPostIn">
    <wsdl:part name="strmess" type="s:string" />
  </wsdl:message>
  <wsdl:message name="WebTestHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:portType name="WebServiceLisSoap">
    <wsdl:operation name="HelloWorld">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">HelloWorld可用于测试服务是否正常。</wsdl:documentation>
      <wsdl:input message="tns:HelloWorldSoapIn" />
      <wsdl:output message="tns:HelloWorldSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="zhLisHeren">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">zhLisHeren，HIS与LIS通过HL7协议进行交易的主要方法</wsdl:documentation>
      <wsdl:input message="tns:zhLisHerenSoapIn" />
      <wsdl:output message="tns:zhLisHerenSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="LabBarMake">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabBarMake，生成条形码方法，入参为病历号：[PatientID]</wsdl:documentation>
      <wsdl:input message="tns:LabBarMakeSoapIn" />
      <wsdl:output message="tns:LabBarMakeSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoAll">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabDownInfoAll，从HIS中下载信息总方法，支持的参数为：科室信息，职工信息，检验项目，收费项目。</wsdl:documentation>
      <wsdl:input message="tns:LabDownInfoAllSoapIn" />
      <wsdl:output message="tns:LabDownInfoAllSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoDept">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabDownInfoDept，从HIS中下载科室信息,无参数！</wsdl:documentation>
      <wsdl:input message="tns:LabDownInfoDeptSoapIn" />
      <wsdl:output message="tns:LabDownInfoDeptSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoStaff">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabDownInfoStaff，从HIS中下载职工信息,无参数！</wsdl:documentation>
      <wsdl:input message="tns:LabDownInfoStaffSoapIn" />
      <wsdl:output message="tns:LabDownInfoStaffSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoItem">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabDownInfoItem，从HIS中下载检验项目,无参数！</wsdl:documentation>
      <wsdl:input message="tns:LabDownInfoItemSoapIn" />
      <wsdl:output message="tns:LabDownInfoItemSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoFee">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabDownInfoFee，从HIS中下载收费项目,无参数！</wsdl:documentation>
      <wsdl:input message="tns:LabDownInfoFeeSoapIn" />
      <wsdl:output message="tns:LabDownInfoFeeSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="SetBarOrderStatus">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">SetBarOrderStatus，向平台发送条形码状态！strBarCode要求全码
         0=申请中(可退费)；1=已申请；2=条码已打印；3=标本已采集；5=标本已核收；6=已执行；P初步报告；F=确认报告，11=LIS退回标本；H=标本已送出；Y=送达</wsdl:documentation>
      <wsdl:input message="tns:SetBarOrderStatusSoapIn" />
      <wsdl:output message="tns:SetBarOrderStatusSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="LabChargeFee">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabChargeFee，向平台发送收费交易！ strBarCode要求全码， intChargeStatus：1收费，-1退费</wsdl:documentation>
      <wsdl:input message="tns:LabChargeFeeSoapIn" />
      <wsdl:output message="tns:LabChargeFeeSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="SendRiskValue">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">SendRiskValue，向平台发送收费交易！ </wsdl:documentation>
      <wsdl:input message="tns:SendRiskValueSoapIn" />
      <wsdl:output message="tns:SendRiskValueSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetQueueNo">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">GetQueueNo，取LIS排队叫号！ </wsdl:documentation>
      <wsdl:input message="tns:GetQueueNoSoapIn" />
      <wsdl:output message="tns:GetQueueNoSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="WebTest">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"> WebTest用于开发人员测试，参数传入时</wsdl:documentation>
      <wsdl:input message="tns:WebTestSoapIn" />
      <wsdl:output message="tns:WebTestSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="WebServiceLisHttpGet">
    <wsdl:operation name="HelloWorld">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">HelloWorld可用于测试服务是否正常。</wsdl:documentation>
      <wsdl:input message="tns:HelloWorldHttpGetIn" />
      <wsdl:output message="tns:HelloWorldHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="zhLisHeren">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">zhLisHeren，HIS与LIS通过HL7协议进行交易的主要方法</wsdl:documentation>
      <wsdl:input message="tns:zhLisHerenHttpGetIn" />
      <wsdl:output message="tns:zhLisHerenHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="LabBarMake">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabBarMake，生成条形码方法，入参为病历号：[PatientID]</wsdl:documentation>
      <wsdl:input message="tns:LabBarMakeHttpGetIn" />
      <wsdl:output message="tns:LabBarMakeHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoAll">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabDownInfoAll，从HIS中下载信息总方法，支持的参数为：科室信息，职工信息，检验项目，收费项目。</wsdl:documentation>
      <wsdl:input message="tns:LabDownInfoAllHttpGetIn" />
      <wsdl:output message="tns:LabDownInfoAllHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoDept">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabDownInfoDept，从HIS中下载科室信息,无参数！</wsdl:documentation>
      <wsdl:input message="tns:LabDownInfoDeptHttpGetIn" />
      <wsdl:output message="tns:LabDownInfoDeptHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoStaff">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabDownInfoStaff，从HIS中下载职工信息,无参数！</wsdl:documentation>
      <wsdl:input message="tns:LabDownInfoStaffHttpGetIn" />
      <wsdl:output message="tns:LabDownInfoStaffHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoItem">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabDownInfoItem，从HIS中下载检验项目,无参数！</wsdl:documentation>
      <wsdl:input message="tns:LabDownInfoItemHttpGetIn" />
      <wsdl:output message="tns:LabDownInfoItemHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoFee">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabDownInfoFee，从HIS中下载收费项目,无参数！</wsdl:documentation>
      <wsdl:input message="tns:LabDownInfoFeeHttpGetIn" />
      <wsdl:output message="tns:LabDownInfoFeeHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="SetBarOrderStatus">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">SetBarOrderStatus，向平台发送条形码状态！strBarCode要求全码
         0=申请中(可退费)；1=已申请；2=条码已打印；3=标本已采集；5=标本已核收；6=已执行；P初步报告；F=确认报告，11=LIS退回标本；H=标本已送出；Y=送达</wsdl:documentation>
      <wsdl:input message="tns:SetBarOrderStatusHttpGetIn" />
      <wsdl:output message="tns:SetBarOrderStatusHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="LabChargeFee">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabChargeFee，向平台发送收费交易！ strBarCode要求全码， intChargeStatus：1收费，-1退费</wsdl:documentation>
      <wsdl:input message="tns:LabChargeFeeHttpGetIn" />
      <wsdl:output message="tns:LabChargeFeeHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="SendRiskValue">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">SendRiskValue，向平台发送收费交易！ </wsdl:documentation>
      <wsdl:input message="tns:SendRiskValueHttpGetIn" />
      <wsdl:output message="tns:SendRiskValueHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetQueueNo">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">GetQueueNo，取LIS排队叫号！ </wsdl:documentation>
      <wsdl:input message="tns:GetQueueNoHttpGetIn" />
      <wsdl:output message="tns:GetQueueNoHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="WebTest">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"> WebTest用于开发人员测试，参数传入时</wsdl:documentation>
      <wsdl:input message="tns:WebTestHttpGetIn" />
      <wsdl:output message="tns:WebTestHttpGetOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="WebServiceLisHttpPost">
    <wsdl:operation name="HelloWorld">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">HelloWorld可用于测试服务是否正常。</wsdl:documentation>
      <wsdl:input message="tns:HelloWorldHttpPostIn" />
      <wsdl:output message="tns:HelloWorldHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="zhLisHeren">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">zhLisHeren，HIS与LIS通过HL7协议进行交易的主要方法</wsdl:documentation>
      <wsdl:input message="tns:zhLisHerenHttpPostIn" />
      <wsdl:output message="tns:zhLisHerenHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="LabBarMake">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabBarMake，生成条形码方法，入参为病历号：[PatientID]</wsdl:documentation>
      <wsdl:input message="tns:LabBarMakeHttpPostIn" />
      <wsdl:output message="tns:LabBarMakeHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoAll">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabDownInfoAll，从HIS中下载信息总方法，支持的参数为：科室信息，职工信息，检验项目，收费项目。</wsdl:documentation>
      <wsdl:input message="tns:LabDownInfoAllHttpPostIn" />
      <wsdl:output message="tns:LabDownInfoAllHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoDept">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabDownInfoDept，从HIS中下载科室信息,无参数！</wsdl:documentation>
      <wsdl:input message="tns:LabDownInfoDeptHttpPostIn" />
      <wsdl:output message="tns:LabDownInfoDeptHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoStaff">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabDownInfoStaff，从HIS中下载职工信息,无参数！</wsdl:documentation>
      <wsdl:input message="tns:LabDownInfoStaffHttpPostIn" />
      <wsdl:output message="tns:LabDownInfoStaffHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoItem">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabDownInfoItem，从HIS中下载检验项目,无参数！</wsdl:documentation>
      <wsdl:input message="tns:LabDownInfoItemHttpPostIn" />
      <wsdl:output message="tns:LabDownInfoItemHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoFee">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabDownInfoFee，从HIS中下载收费项目,无参数！</wsdl:documentation>
      <wsdl:input message="tns:LabDownInfoFeeHttpPostIn" />
      <wsdl:output message="tns:LabDownInfoFeeHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="SetBarOrderStatus">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">SetBarOrderStatus，向平台发送条形码状态！strBarCode要求全码
         0=申请中(可退费)；1=已申请；2=条码已打印；3=标本已采集；5=标本已核收；6=已执行；P初步报告；F=确认报告，11=LIS退回标本；H=标本已送出；Y=送达</wsdl:documentation>
      <wsdl:input message="tns:SetBarOrderStatusHttpPostIn" />
      <wsdl:output message="tns:SetBarOrderStatusHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="LabChargeFee">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">LabChargeFee，向平台发送收费交易！ strBarCode要求全码， intChargeStatus：1收费，-1退费</wsdl:documentation>
      <wsdl:input message="tns:LabChargeFeeHttpPostIn" />
      <wsdl:output message="tns:LabChargeFeeHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="SendRiskValue">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">SendRiskValue，向平台发送收费交易！ </wsdl:documentation>
      <wsdl:input message="tns:SendRiskValueHttpPostIn" />
      <wsdl:output message="tns:SendRiskValueHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetQueueNo">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">GetQueueNo，取LIS排队叫号！ </wsdl:documentation>
      <wsdl:input message="tns:GetQueueNoHttpPostIn" />
      <wsdl:output message="tns:GetQueueNoHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="WebTest">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"> WebTest用于开发人员测试，参数传入时</wsdl:documentation>
      <wsdl:input message="tns:WebTestHttpPostIn" />
      <wsdl:output message="tns:WebTestHttpPostOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="WebServiceLisSoap" type="tns:WebServiceLisSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="HelloWorld">
      <soap:operation soapAction="http://172.16.1.36/HelloWorld" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="zhLisHeren">
      <soap:operation soapAction="http://172.16.1.36/zhLisHeren" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabBarMake">
      <soap:operation soapAction="http://172.16.1.36/LabBarMake" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoAll">
      <soap:operation soapAction="http://172.16.1.36/LabDownInfoAll" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoDept">
      <soap:operation soapAction="http://172.16.1.36/LabDownInfoDept" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoStaff">
      <soap:operation soapAction="http://172.16.1.36/LabDownInfoStaff" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoItem">
      <soap:operation soapAction="http://172.16.1.36/LabDownInfoItem" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoFee">
      <soap:operation soapAction="http://172.16.1.36/LabDownInfoFee" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SetBarOrderStatus">
      <soap:operation soapAction="http://172.16.1.36/SetBarOrderStatus" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabChargeFee">
      <soap:operation soapAction="http://172.16.1.36/LabChargeFee" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SendRiskValue">
      <soap:operation soapAction="http://172.16.1.36/SendRiskValue" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetQueueNo">
      <soap:operation soapAction="http://172.16.1.36/GetQueueNo" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="WebTest">
      <soap:operation soapAction="http://172.16.1.36/WebTest" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="WebServiceLisSoap12" type="tns:WebServiceLisSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="HelloWorld">
      <soap12:operation soapAction="http://172.16.1.36/HelloWorld" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="zhLisHeren">
      <soap12:operation soapAction="http://172.16.1.36/zhLisHeren" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabBarMake">
      <soap12:operation soapAction="http://172.16.1.36/LabBarMake" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoAll">
      <soap12:operation soapAction="http://172.16.1.36/LabDownInfoAll" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoDept">
      <soap12:operation soapAction="http://172.16.1.36/LabDownInfoDept" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoStaff">
      <soap12:operation soapAction="http://172.16.1.36/LabDownInfoStaff" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoItem">
      <soap12:operation soapAction="http://172.16.1.36/LabDownInfoItem" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoFee">
      <soap12:operation soapAction="http://172.16.1.36/LabDownInfoFee" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SetBarOrderStatus">
      <soap12:operation soapAction="http://172.16.1.36/SetBarOrderStatus" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabChargeFee">
      <soap12:operation soapAction="http://172.16.1.36/LabChargeFee" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SendRiskValue">
      <soap12:operation soapAction="http://172.16.1.36/SendRiskValue" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetQueueNo">
      <soap12:operation soapAction="http://172.16.1.36/GetQueueNo" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="WebTest">
      <soap12:operation soapAction="http://172.16.1.36/WebTest" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="WebServiceLisHttpGet" type="tns:WebServiceLisHttpGet">
    <http:binding verb="GET" />
    <wsdl:operation name="HelloWorld">
      <http:operation location="/HelloWorld" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="zhLisHeren">
      <http:operation location="/zhLisHeren" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabBarMake">
      <http:operation location="/LabBarMake" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoAll">
      <http:operation location="/LabDownInfoAll" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoDept">
      <http:operation location="/LabDownInfoDept" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoStaff">
      <http:operation location="/LabDownInfoStaff" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoItem">
      <http:operation location="/LabDownInfoItem" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoFee">
      <http:operation location="/LabDownInfoFee" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SetBarOrderStatus">
      <http:operation location="/SetBarOrderStatus" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabChargeFee">
      <http:operation location="/LabChargeFee" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SendRiskValue">
      <http:operation location="/SendRiskValue" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetQueueNo">
      <http:operation location="/GetQueueNo" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="WebTest">
      <http:operation location="/WebTest" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="WebServiceLisHttpPost" type="tns:WebServiceLisHttpPost">
    <http:binding verb="POST" />
    <wsdl:operation name="HelloWorld">
      <http:operation location="/HelloWorld" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="zhLisHeren">
      <http:operation location="/zhLisHeren" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabBarMake">
      <http:operation location="/LabBarMake" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoAll">
      <http:operation location="/LabDownInfoAll" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoDept">
      <http:operation location="/LabDownInfoDept" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoStaff">
      <http:operation location="/LabDownInfoStaff" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoItem">
      <http:operation location="/LabDownInfoItem" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabDownInfoFee">
      <http:operation location="/LabDownInfoFee" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SetBarOrderStatus">
      <http:operation location="/SetBarOrderStatus" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LabChargeFee">
      <http:operation location="/LabChargeFee" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SendRiskValue">
      <http:operation location="/SendRiskValue" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetQueueNo">
      <http:operation location="/GetQueueNo" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="WebTest">
      <http:operation location="/WebTest" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="WebServiceLis">
    <wsdl:port name="WebServiceLisSoap" binding="tns:WebServiceLisSoap">
      <soap:address location="http://172.16.1.39:20202/WebServiceLis.asmx" />
    </wsdl:port>
    <wsdl:port name="WebServiceLisSoap12" binding="tns:WebServiceLisSoap12">
      <soap12:address location="http://172.16.1.39:20202/WebServiceLis.asmx" />
    </wsdl:port>
    <wsdl:port name="WebServiceLisHttpGet" binding="tns:WebServiceLisHttpGet">
      <http:address location="http://172.16.1.39:20202/WebServiceLis.asmx" />
    </wsdl:port>
    <wsdl:port name="WebServiceLisHttpPost" binding="tns:WebServiceLisHttpPost">
      <http:address location="http://172.16.1.39:20202/WebServiceLis.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>