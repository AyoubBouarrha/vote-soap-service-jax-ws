/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YB
 */
@Entity
@Table(name = "LISTEELECTORALE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listeelectorale.findAll", query = "SELECT l FROM Listeelectorale l")
    , @NamedQuery(name = "Listeelectorale.findByIdelection", query = "SELECT l FROM Listeelectorale l WHERE l.listeelectoralePK.idelection = :idelection")
    , @NamedQuery(name = "Listeelectorale.findByIdcitoyen", query = "SELECT l FROM Listeelectorale l WHERE l.listeelectoralePK.idcitoyen = :idcitoyen")
    , @NamedQuery(name = "Listeelectorale.findByIdinscription", query = "SELECT l FROM Listeelectorale l WHERE l.idinscription = :idinscription")
    , @NamedQuery(name = "Listeelectorale.findByDateinscription", query = "SELECT l FROM Listeelectorale l WHERE l.dateinscription = :dateinscription")
    , @NamedQuery(name = "Listeelectorale.findByAvote", query = "SELECT l FROM Listeelectorale l WHERE l.avote = :avote")})
public class Listeelectorale implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ListeelectoralePK listeelectoralePK;
    @Basic(optional = false)
    @Column(name = "IDINSCRIPTION")
    private int idinscription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEINSCRIPTION")
    @Temporal(TemporalType.DATE)
    private Date dateinscription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AVOTE")
    private int avote;
    @JoinColumn(name = "IDCITOYEN", referencedColumnName = "IDCITOYEN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Citoyen citoyen;
    @JoinColumn(name = "IDELECTION", referencedColumnName = "IDELECTION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Election election;

    public Listeelectorale() {
    }

    public Listeelectorale(ListeelectoralePK listeelectoralePK) {
        this.listeelectoralePK = listeelectoralePK;
    }

    public Listeelectorale(ListeelectoralePK listeelectoralePK, int idinscription, Date dateinscription, int avote) {
        this.listeelectoralePK = listeelectoralePK;
        this.idinscription = idinscription;
        this.dateinscription = dateinscription;
        this.avote = avote;
    }

    public Listeelectorale(int idelection, int idcitoyen) {
        this.listeelectoralePK = new ListeelectoralePK(idelection, idcitoyen);
    }

    public ListeelectoralePK getListeelectoralePK() {
        return listeelectoralePK;
    }

    public void setListeelectoralePK(ListeelectoralePK listeelectoralePK) {
        this.listeelectoralePK = listeelectoralePK;
    }

    public int getIdinscription() {
        return idinscription;
    }

    public void setIdinscription(int idinscription) {
        this.idinscription = idinscription;
    }

    public Date getDateinscription() {
        return dateinscription;
    }

    public void setDateinscription(Date dateinscription) {
        this.dateinscription = dateinscription;
    }

    public int getAvote() {
        return avote;
    }

    public void setAvote(int avote) {
        this.avote = avote;
    }

    public Citoyen getCitoyen() {
        return citoyen;
    }

    public void setCitoyen(Citoyen citoyen) {
        this.citoyen = citoyen;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listeelectoralePK != null ? listeelectoralePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listeelectorale)) {
            return false;
        }
        Listeelectorale other = (Listeelectorale) object;
        if ((this.listeelectoralePK == null && other.listeelectoralePK != null) || (this.listeelectoralePK != null && !this.listeelectoralePK.equals(other.listeelectoralePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Listeelectorale[ listeelectoralePK=" + listeelectoralePK + " ]";
    }
    
}
