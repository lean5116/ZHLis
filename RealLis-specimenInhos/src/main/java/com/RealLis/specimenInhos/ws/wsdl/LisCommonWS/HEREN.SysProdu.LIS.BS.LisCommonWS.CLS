<?xml version="1.0" encoding="UTF-8"?>
<definitions xmlns="http://schemas.xmlsoap.org/wsdl/" xmlns:SOAP-ENC="http://schemas.xmlsoap.org/soap/encoding/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:s0="http://tempuri.org" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" targetNamespace="http://tempuri.org">
    <types>
        <s:schema elementFormDefault="qualified" targetNamespace="http://tempuri.org">
            <s:element name="MessageIn">
                <s:complexType>
                    <s:sequence>
                        <s:element minOccurs="0" name="DataType" type="s:string"/>
                        <s:element minOccurs="0" name="pInput" type="s:string"/>
                    </s:sequence>
                </s:complexType>
            </s:element>
            <s:element name="MessageInResponse">
                <s:complexType>
                    <s:sequence>
                        <s:element name="MessageInResult" type="s:string"/>
                    </s:sequence>
                </s:complexType>
            </s:element>
        </s:schema>
    </types>
    <message name="MessageInSoapIn">
        <part name="parameters" element="s0:MessageIn"/>
    </message>
    <message name="MessageInSoapOut">
        <part name="parameters" element="s0:MessageInResponse"/>
    </message>
    <portType name="LisCommonWSSoap">
        <operation name="MessageIn">
            <input message="s0:MessageInSoapIn"/>
            <output message="s0:MessageInSoapOut"/>
        </operation>
    </portType>
    <binding name="LisCommonWSSoap" type="s0:LisCommonWSSoap">
        <soap:binding transport="http://schemas.xmlsoap.org/soap/http" style="document"/>
        <operation name="MessageIn">
            <soap:operation soapAction="http://tempuri.org/HEREN.SysProdu.LIS.BS.LisCommonWS.MessageIn" style="document"/>
            <input>
                <soap:body use="literal"/>
            </input>
            <output>
                <soap:body use="literal"/>
            </output>
        </operation>
    </binding>
    <service name="LisCommonWS">
        <port name="LisCommonWSSoap" binding="s0:LisCommonWSSoap">
            <soap:address location="http://172.16.17.72:57772/csp/healthshare/taiyi/services/HEREN.SysProdu.LIS.BS.LisCommonWS.cls"/>
        </port>
    </service>
</definitions>