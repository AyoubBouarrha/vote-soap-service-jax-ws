
package org.netbeans.xml.schema.vote;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.netbeans.xml.schema.vote package. 
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

    private final static QName _VoteVerifFaultType_QNAME = new QName("http://xml.netbeans.org/schema/vote", "VoteVerifFaultType");
    private final static QName _VoteChoixFaultType_QNAME = new QName("http://xml.netbeans.org/schema/vote", "VoteChoixFaultType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.netbeans.xml.schema.vote
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VoteChoixOutType }
     * 
     */
    public VoteChoixOutType createVoteChoixOutType() {
        return new VoteChoixOutType();
    }

    /**
     * Create an instance of {@link CitoyenInfo }
     * 
     */
    public CitoyenInfo createCitoyenInfo() {
        return new CitoyenInfo();
    }

    /**
     * Create an instance of {@link VoteVerifOutType }
     * 
     */
    public VoteVerifOutType createVoteVerifOutType() {
        return new VoteVerifOutType();
    }

    /**
     * Create an instance of {@link CandidatInfo }
     * 
     */
    public CandidatInfo createCandidatInfo() {
        return new CandidatInfo();
    }

    /**
     * Create an instance of {@link ElectionInfo }
     * 
     */
    public ElectionInfo createElectionInfo() {
        return new ElectionInfo();
    }

    /**
     * Create an instance of {@link VoteVerifInType }
     * 
     */
    public VoteVerifInType createVoteVerifInType() {
        return new VoteVerifInType();
    }

    /**
     * Create an instance of {@link VoteChoixInType }
     * 
     */
    public VoteChoixInType createVoteChoixInType() {
        return new VoteChoixInType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/vote", name = "VoteVerifFaultType")
    public JAXBElement<String> createVoteVerifFaultType(String value) {
        return new JAXBElement<String>(_VoteVerifFaultType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/vote", name = "VoteChoixFaultType")
    public JAXBElement<String> createVoteChoixFaultType(String value) {
        return new JAXBElement<String>(_VoteChoixFaultType_QNAME, String.class, null, value);
    }

}
