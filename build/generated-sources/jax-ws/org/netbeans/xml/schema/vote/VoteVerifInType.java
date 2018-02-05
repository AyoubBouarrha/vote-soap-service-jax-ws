
package org.netbeans.xml.schema.vote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="intituleElection" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="citoyenInfo" type="{http://xml.netbeans.org/schema/vote}CitoyenInfo"/>
 *         &lt;element name="idInscription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
    "intituleElection",
    "citoyenInfo",
    "idInscription",
    "date"
})
@XmlRootElement(name = "VoteVerifInType")
public class VoteVerifInType {

    @XmlElement(required = true)
    protected String intituleElection;
    @XmlElement(required = true)
    protected CitoyenInfo citoyenInfo;
    @XmlElement(required = true)
    protected String idInscription;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;

    /**
     * Gets the value of the intituleElection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntituleElection() {
        return intituleElection;
    }

    /**
     * Sets the value of the intituleElection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntituleElection(String value) {
        this.intituleElection = value;
    }

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
     * Gets the value of the idInscription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdInscription() {
        return idInscription;
    }

    /**
     * Sets the value of the idInscription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdInscription(String value) {
        this.idInscription = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

}
