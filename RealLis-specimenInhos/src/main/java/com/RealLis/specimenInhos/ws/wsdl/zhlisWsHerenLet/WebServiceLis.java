
package com.RealLis.specimenInhos.ws.wsdl.zhlisWsHerenLet;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WebServiceLis", targetNamespace = "http://172.16.1.36", wsdlLocation = "http://172.16.17.94:20202/WebServiceLis.asmx?WSDL")
public class WebServiceLis
    extends Service
{

    private final static URL WEBSERVICELIS_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICELIS_EXCEPTION;
    private final static QName WEBSERVICELIS_QNAME = new QName("http://172.16.1.36", "WebServiceLis");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://172.16.17.94:20202/WebServiceLis.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICELIS_WSDL_LOCATION = url;
        WEBSERVICELIS_EXCEPTION = e;
    }

    public WebServiceLis() {
        super(__getWsdlLocation(), WEBSERVICELIS_QNAME);
    }

    public WebServiceLis(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICELIS_QNAME, features);
    }

    public WebServiceLis(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICELIS_QNAME);
    }

    public WebServiceLis(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICELIS_QNAME, features);
    }

    public WebServiceLis(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServiceLis(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServiceLisSoap
     */
    @WebEndpoint(name = "WebServiceLisSoap")
    public WebServiceLisSoap getWebServiceLisSoap() {
        return super.getPort(new QName("http://172.16.1.36", "WebServiceLisSoap"), WebServiceLisSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServiceLisSoap
     */
    @WebEndpoint(name = "WebServiceLisSoap")
    public WebServiceLisSoap getWebServiceLisSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://172.16.1.36", "WebServiceLisSoap"), WebServiceLisSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns WebServiceLisSoap
     */
    @WebEndpoint(name = "WebServiceLisSoap12")
    public WebServiceLisSoap getWebServiceLisSoap12() {
        return super.getPort(new QName("http://172.16.1.36", "WebServiceLisSoap12"), WebServiceLisSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServiceLisSoap
     */
    @WebEndpoint(name = "WebServiceLisSoap12")
    public WebServiceLisSoap getWebServiceLisSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://172.16.1.36", "WebServiceLisSoap12"), WebServiceLisSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns WebServiceLisHttpGet
     */
    @WebEndpoint(name = "WebServiceLisHttpGet")
    public WebServiceLisHttpGet getWebServiceLisHttpGet() {
        return super.getPort(new QName("http://172.16.1.36", "WebServiceLisHttpGet"), WebServiceLisHttpGet.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServiceLisHttpGet
     */
    @WebEndpoint(name = "WebServiceLisHttpGet")
    public WebServiceLisHttpGet getWebServiceLisHttpGet(WebServiceFeature... features) {
        return super.getPort(new QName("http://172.16.1.36", "WebServiceLisHttpGet"), WebServiceLisHttpGet.class, features);
    }

    /**
     * 
     * @return
     *     returns WebServiceLisHttpPost
     */
    @WebEndpoint(name = "WebServiceLisHttpPost")
    public WebServiceLisHttpPost getWebServiceLisHttpPost() {
        return super.getPort(new QName("http://172.16.1.36", "WebServiceLisHttpPost"), WebServiceLisHttpPost.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServiceLisHttpPost
     */
    @WebEndpoint(name = "WebServiceLisHttpPost")
    public WebServiceLisHttpPost getWebServiceLisHttpPost(WebServiceFeature... features) {
        return super.getPort(new QName("http://172.16.1.36", "WebServiceLisHttpPost"), WebServiceLisHttpPost.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICELIS_EXCEPTION!= null) {
            throw WEBSERVICELIS_EXCEPTION;
        }
        return WEBSERVICELIS_WSDL_LOCATION;
    }

}
