
package org.netbeans.xml.schema.vote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="citoyenInfo" type="{http://xml.netbeans.org/schema/vote}CitoyenInfo"/>
 *         &lt;element name="validation" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "citoyenInfo",
    "validation"
})
@XmlRootElement(name = "VoteChoixOutType")
public class VoteChoixOutType {

    @XmlElement(required = true)
    protected CitoyenInfo citoyenInfo;
    @XmlElement(required = true)
    protected String validation;

    /**
     * Gets the value of the citoyenInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CitoyenInfo }
     *     
     */
    public CitoyenInfo getCitoyenInfo() {
        return citoyenInfo;
    }

    /**
     * Sets the value of the citoyenInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CitoyenInfo }
     *     
     */
    public void setCitoyenInfo(CitoyenInfo value) {
        this.citoyenInfo = value;
    }

    /**
     * Gets the value of the validation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidation() {
        return validation;
    }

    /**
     * Sets the value of the validation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidation(String value) {
        this.validation = value;
    }

}
