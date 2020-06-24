<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://tempurl.org" xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" targetNamespace="http://tempurl.org" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://tempurl.org">
      <s:element name="uf_about">
        <s:complexType />
      </s:element>
      <s:element name="uf_aboutResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="uf_aboutResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="uf_pack">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="as_czz" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="as_barcode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="uf_packResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="uf_packResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="uf_trans">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="as_czz" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="as_wlbh" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="uf_transResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="uf_transResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="uf_josn">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="as_josn" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="uf_josnResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="uf_josnResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="uf_aboutSoapIn">
    <wsdl:part name="parameters" element="tns:uf_about" />
  </wsdl:message>
  <wsdl:message name="uf_aboutSoapOut">
    <wsdl:part name="parameters" element="tns:uf_aboutResponse" />
  </wsdl:message>
  <wsdl:message name="uf_packSoapIn">
    <wsdl:part name="parameters" element="tns:uf_pack" />
  </wsdl:message>
  <wsdl:message name="uf_packSoapOut">
    <wsdl:part name="parameters" element="tns:uf_packResponse" />
  </wsdl:message>
  <wsdl:message name="uf_transSoapIn">
    <wsdl:part name="parameters" element="tns:uf_trans" />
  </wsdl:message>
  <wsdl:message name="uf_transSoapOut">
    <wsdl:part name="parameters" element="tns:uf_transResponse" />
  </wsdl:message>
  <wsdl:message name="uf_josnSoapIn">
    <wsdl:part name="parameters" element="tns:uf_josn" />
  </wsdl:message>
  <wsdl:message name="uf_josnSoapOut">
    <wsdl:part name="parameters" element="tns:uf_josnResponse" />
  </wsdl:message>
  <wsdl:portType name="interface_hrSoap">
    <wsdl:operation name="uf_about">
      <wsdl:input message="tns:uf_aboutSoapIn" />
      <wsdl:output message="tns:uf_aboutSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="uf_pack">
      <wsdl:input message="tns:uf_packSoapIn" />
      <wsdl:output message="tns:uf_packSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="uf_trans">
      <wsdl:input message="tns:uf_transSoapIn" />
      <wsdl:output message="tns:uf_transSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="uf_josn">
      <wsdl:input message="tns:uf_josnSoapIn" />
      <wsdl:output message="tns:uf_josnSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="interface_hrSoap" type="tns:interface_hrSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="uf_about">
      <soap:operation soapAction="http://tempurl.org/uf_about" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="uf_pack">
      <soap:operation soapAction="http://tempurl.org/uf_pack" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="uf_trans">
      <soap:operation soapAction="http://tempurl.org/uf_trans" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="uf_josn">
      <soap:operation soapAction="http://tempurl.org/uf_josn" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="interface_hrSoap12" type="tns:interface_hrSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="uf_about">
      <soap12:operation soapAction="http://tempurl.org/uf_about" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="uf_pack">
      <soap12:operation soapAction="http://tempurl.org/uf_pack" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="uf_trans">
      <soap12:operation soapAction="http://tempurl.org/uf_trans" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="uf_josn">
      <soap12:operation soapAction="http://tempurl.org/uf_josn" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="interface_hr">
    <wsdl:port name="interface_hrSoap" binding="tns:interface_hrSoap">
      <soap:address location="http://172.16.0.100:6700/hyyy_wsbarcode/interface_hr.asmx" />
    </wsdl:port>
    <wsdl:port name="interface_hrSoap12" binding="tns:interface_hrSoap12">
      <soap12:address location="http://172.16.0.100:6700/hyyy_wsbarcode/interface_hr.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>