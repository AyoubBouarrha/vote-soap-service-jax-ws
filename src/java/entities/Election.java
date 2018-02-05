/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YB
 */
@Entity
@Table(name = "ELECTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Election.findAll", query = "SELECT e FROM Election e")
    , @NamedQuery(name = "Election.findByIdelection", query = "SELECT e FROM Election e WHERE e.idelection = :idelection")
    , @NamedQuery(name = "Election.findByIntitule", query = "SELECT e FROM Election e WHERE e.intitule = :intitule")
    , @NamedQuery(name = "Election.findByDateelection", query = "SELECT e FROM Election e WHERE e.dateelection = :dateelection")})
public class Election implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDELECTION")
    private Integer idelection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "INTITULE")
    private String intitule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEELECTION")
    @Temporal(TemporalType.DATE)
    private Date dateelection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "election")
    private Collection<Listecandidats> listecandidatsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "election")
    private Collection<Listeelectorale> listeelectoraleCollection;

    public Election() {
    }

    public Election(Integer idelection) {
        this.idelection = idelection;
    }

    public Election(Integer idelection, String intitule, Date dateelection) {
        this.idelection = idelection;
        this.intitule = intitule;
        this.dateelection = dateelection;
    }

    public Integer getIdelection() {
        return idelection;
    }

    public void setIdelection(Integer idelection) {
        this.idelection = idelection;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Date getDateelection() {
        return dateelection;
    }

    public void setDateelection(Date dateelection) {
        this.dateelection = dateelection;
    }

    @XmlTransient
    public Collection<Listecandidats> getListecandidatsCollection() {
        return listecandidatsCollection;
    }

    public void setListecandidatsCollection(Collection<Listecandidats> listecandidatsCollection) {
        this.listecandidatsCollection = listecandidatsCollection;
    }

    @XmlTransient
    public Collection<Listeelectorale> getListeelectoraleCollection() {
        return listeelectoraleCollection;
    }

    public void setListeelectoraleCollection(Collection<Listeelectorale> listeelectoraleCollection) {
        this.listeelectoraleCollection = listeelectoraleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idelection != null ? idelection.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Election)) {
            return false;
        }
        Election other = (Election) object;
        if ((this.idelection == null && other.idelection != null) || (this.idelection != null && !this.idelection.equals(other.idelection))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Election[ idelection=" + idelection + " ]";
    }
    
}
