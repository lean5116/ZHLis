
package com.RealLis.specimenInhos.ws.wsdl.zhlisWsHerenLet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LabDownInfoAllResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "labDownInfoAllResult"
})
@XmlRootElement(name = "LabDownInfoAllResponse")
public class LabDownInfoAllResponse {

    @XmlElement(name = "LabDownInfoAllResult")
    protected String labDownInfoAllResult;

    /**
     * 获取labDownInfoAllResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabDownInfoAllResult() {
        return labDownInfoAllResult;
    }

    /**
     * 设置labDownInfoAllResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabDownInfoAllResult(String value) {
        this.labDownInfoAllResult = value;
    }

}
