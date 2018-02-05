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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "VOTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Votes.findAll", query = "SELECT v FROM Votes v")
    , @NamedQuery(name = "Votes.findByIdvote", query = "SELECT v FROM Votes v WHERE v.idvote = :idvote")
    , @NamedQuery(name = "Votes.findByDatevote", query = "SELECT v FROM Votes v WHERE v.datevote = :datevote")})
public class Votes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDVOTE")
    private Integer idvote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEVOTE")
    @Temporal(TemporalType.DATE)
    private Date datevote;
    @JoinColumns({
        @JoinColumn(name = "IDELECTION", referencedColumnName = "IDELECTION")
        , @JoinColumn(name = "IDCANDIDAT", referencedColumnName = "IDCANDIDAT")})
    @ManyToOne(optional = false)
    private Listecandidats listecandidats;

    public Votes() {
    }

    public Votes(Integer idvote) {
        this.idvote = idvote;
    }

    public Votes(Integer idvote, Date datevote) {
        this.idvote = idvote;
        this.datevote = datevote;
    }

    public Integer getIdvote() {
        return idvote;
    }

    public void setIdvote(Integer idvote) {
        this.idvote = idvote;
    }

    public Date getDatevote() {
        return datevote;
    }

    public void setDatevote(Date datevote) {
        this.datevote = datevote;
    }

    public Listecandidats getListecandidats() {
        return listecandidats;
    }

    public void setListecandidats(Listecandidats listecandidats) {
        this.listecandidats = listecandidats;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvote != null ? idvote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Votes)) {
            return false;
        }
        Votes other = (Votes) object;
        if ((this.idvote == null && other.idvote != null) || (this.idvote != null && !this.idvote.equals(other.idvote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Votes[ idvote=" + idvote + " ]";
    }
    
}
