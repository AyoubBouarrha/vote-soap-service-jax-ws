/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YB
 */
@Entity
@Table(name = "LISTECANDIDATS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listecandidats.findAll", query = "SELECT l FROM Listecandidats l")
    , @NamedQuery(name = "Listecandidats.findByIdelection", query = "SELECT l FROM Listecandidats l WHERE l.listecandidatsPK.idelection = :idelection")
    , @NamedQuery(name = "Listecandidats.findByIdcandidat", query = "SELECT l FROM Listecandidats l WHERE l.listecandidatsPK.idcandidat = :idcandidat")
    , @NamedQuery(name = "Listecandidats.findByNumerocandidat", query = "SELECT l FROM Listecandidats l WHERE l.numerocandidat = :numerocandidat")})
public class Listecandidats implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ListecandidatsPK listecandidatsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMEROCANDIDAT")
    private int numerocandidat;
    @JoinColumn(name = "IDCANDIDAT", referencedColumnName = "IDCANDIDAT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Candidat candidat;
    @JoinColumn(name = "IDELECTION", referencedColumnName = "IDELECTION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Election election;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listecandidats")
    private Collection<Votes> votesCollection;

    public Listecandidats() {
    }

    public Listecandidats(ListecandidatsPK listecandidatsPK) {
        this.listecandidatsPK = listecandidatsPK;
    }

    public Listecandidats(ListecandidatsPK listecandidatsPK, int numerocandidat) {
        this.listecandidatsPK = listecandidatsPK;
        this.numerocandidat = numerocandidat;
    }

    public Listecandidats(int idelection, int idcandidat) {
        this.listecandidatsPK = new ListecandidatsPK(idelection, idcandidat);
    }

    public ListecandidatsPK getListecandidatsPK() {
        return listecandidatsPK;
    }

    public void setListecandidatsPK(ListecandidatsPK listecandidatsPK) {
        this.listecandidatsPK = listecandidatsPK;
    }

    public int getNumerocandidat() {
        return numerocandidat;
    }

    public void setNumerocandidat(int numerocandidat) {
        this.numerocandidat = numerocandidat;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    @XmlTransient
    public Collection<Votes> getVotesCollection() {
        return votesCollection;
    }

    public void setVotesCollection(Collection<Votes> votesCollection) {
        this.votesCollection = votesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listecandidatsPK != null ? listecandidatsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listecandidats)) {
            return false;
        }
        Listecandidats other = (Listecandidats) object;
        if ((this.listecandidatsPK == null && other.listecandidatsPK != null) || (this.listecandidatsPK != null && !this.listecandidatsPK.equals(other.listecandidatsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Listecandidats[ listecandidatsPK=" + listecandidatsPK + " ]";
    }
    
}
