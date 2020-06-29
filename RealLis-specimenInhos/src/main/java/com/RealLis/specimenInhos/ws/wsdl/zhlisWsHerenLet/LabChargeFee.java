
package com.RealLis.specimenInhos.ws.wsdl.zhlisWsHerenLet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="strBarCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="intChargeStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "strBarCode",
    "intChargeStatus"
})
@XmlRootElement(name = "LabChargeFee")
public class LabChargeFee {

    protected String strBarCode;
    protected int intChargeStatus;

    /**
     * 获取strBarCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrBarCode() {
        return strBarCode;
    }

    /**
     * 设置strBarCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrBarCode(String value) {
        this.strBarCode = value;
    }

    /**
     * 获取intChargeStatus属性的值。
     * 
     */
    public int getIntChargeStatus() {
        return intChargeStatus;
    }

    /**
     * 设置intChargeStatus属性的值。
     * 
     */
    public void setIntChargeStatus(int value) {
        this.intChargeStatus = value;
    }

}
