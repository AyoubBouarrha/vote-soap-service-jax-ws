
package org.netbeans.xml.schema.vote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ElectionInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ElectionInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="intituleElection" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateElection" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="nombreInscrits" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElectionInfo", propOrder = {
    "intituleElection",
    "dateElection",
    "nombreInscrits"
})
public class ElectionInfo {

    @XmlElement(required = true)
    protected String intituleElection;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateElection;
    protected Integer nombreInscrits;

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
     * Gets the value of the dateElection property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateElection() {
        return dateElection;
    }

    /**
     * Sets the value of the dateElection property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateElection(XMLGregorianCalendar value) {
        this.dateElection = value;
    }

    /**
     * Gets the value of the nombreInscrits property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNombreInscrits() {
        return nombreInscrits;
    }

    /**
     * Sets the value of the nombreInscrits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNombreInscrits(Integer value) {
        this.nombreInscrits = value;
    }

}
