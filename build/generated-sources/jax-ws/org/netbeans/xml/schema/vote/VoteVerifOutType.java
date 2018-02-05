
package org.netbeans.xml.schema.vote;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;choice>
 *           &lt;element name="refus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;sequence>
 *             &lt;element name="candidatInfo" type="{http://xml.netbeans.org/schema/vote}CandidatInfo" maxOccurs="unbounded"/>
 *             &lt;element name="electionInfo" type="{http://xml.netbeans.org/schema/vote}ElectionInfo"/>
 *           &lt;/sequence>
 *         &lt;/choice>
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
    "refus",
    "candidatInfo",
    "electionInfo"
})
@XmlRootElement(name = "VoteVerifOutType")
public class VoteVerifOutType {

    @XmlElement(required = true)
    protected CitoyenInfo citoyenInfo;
    protected String refus;
    protected List<CandidatInfo> candidatInfo;
    protected ElectionInfo electionInfo;

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
     * Gets the value of the refus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefus() {
        return refus;
    }

    /**
     * Sets the value of the refus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefus(String value) {
        this.refus = value;
    }
    

    public void setCandidatInfo(List<CandidatInfo> candidatInfo) {
        this.candidatInfo = candidatInfo;
    }
    
    
    

    /**
     * Gets the value of the candidatInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the candidatInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCandidatInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CandidatInfo }
     * 
     * 
     */
    public List<CandidatInfo> getCandidatInfo() {
        if (candidatInfo == null) {
            candidatInfo = new ArrayList<CandidatInfo>();
        }
        return this.candidatInfo;
    }

    /**
     * Gets the value of the electionInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ElectionInfo }
     *     
     */
    public ElectionInfo getElectionInfo() {
        return electionInfo;
    }

    /**
     * Sets the value of the electionInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElectionInfo }
     *     
     */
    public void setElectionInfo(ElectionInfo value) {
        this.electionInfo = value;
    }

}
