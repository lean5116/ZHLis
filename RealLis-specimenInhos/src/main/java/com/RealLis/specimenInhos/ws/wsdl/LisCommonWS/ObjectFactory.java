
package com.RealLis.specimenInhos.ws.wsdl.LisCommonWS;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.RealLis.specimenInhos.ws.wsdl.LisCommonWS package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.RealLis.specimenInhos.ws.wsdl.LisCommonWS
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MessageIn }
     * 
     */
    public MessageIn createMessageIn() {
        return new MessageIn();
    }

    /**
     * Create an instance of {@link MessageInResponse }
     * 
     */
    public MessageInResponse createMessageInResponse() {
        return new MessageInResponse();
    }

}
