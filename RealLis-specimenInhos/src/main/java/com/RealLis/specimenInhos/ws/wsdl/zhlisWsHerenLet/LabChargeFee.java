
package com.RealLis.specimenInhos.ws.wsdl.zhlisWsHerenLet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡstrBarCode���Ե�ֵ��
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
     * ����strBarCode���Ե�ֵ��
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
     * ��ȡintChargeStatus���Ե�ֵ��
     * 
     */
    public int getIntChargeStatus() {
        return intChargeStatus;
    }

    /**
     * ����intChargeStatus���Ե�ֵ��
     * 
     */
    public void setIntChargeStatus(int value) {
        this.intChargeStatus = value;
    }

}
