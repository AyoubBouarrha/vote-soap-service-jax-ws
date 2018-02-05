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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YB
 */
@Entity
@Table(name = "CANDIDAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidat.findAll", query = "SELECT c FROM Candidat c")
    , @NamedQuery(name = "Candidat.findByIdcandidat", query = "SELECT c FROM Candidat c WHERE c.idcandidat = :idcandidat")
    , @NamedQuery(name = "Candidat.findByNom", query = "SELECT c FROM Candidat c WHERE c.nom = :nom")
    , @NamedQuery(name = "Candidat.findByPrenom", query = "SELECT c FROM Candidat c WHERE c.prenom = :prenom")
    , @NamedQuery(name = "Candidat.findByAffiliation", query = "SELECT c FROM Candidat c WHERE c.affiliation = :affiliation")})
public class Candidat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCANDIDAT")
    private Integer idcandidat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PRENOM")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "AFFILIATION")
    private String affiliation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidat")
    private Collection<Listecandidats> listecandidatsCollection;

    public Candidat() {
    }

    public Candidat(Integer idcandidat) {
        this.idcandidat = idcandidat;
    }

    public Candidat(Integer idcandidat, String nom, String prenom, String affiliation) {
        this.idcandidat = idcandidat;
        this.nom = nom;
        this.prenom = prenom;
        this.affiliation = affiliation;
    }

    public Integer getIdcandidat() {
        return idcandidat;
    }

    public void setIdcandidat(Integer idcandidat) {
        this.idcandidat = idcandidat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    @XmlTransient
    public Collection<Listecandidats> getListecandidatsCollection() {
        return listecandidatsCollection;
    }

    public void setListecandidatsCollection(Collection<Listecandidats> listecandidatsCollection) {
        this.listecandidatsCollection = listecandidatsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcandidat != null ? idcandidat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidat)) {
            return false;
        }
        Candidat other = (Candidat) object;
        if ((this.idcandidat == null && other.idcandidat != null) || (this.idcandidat != null && !this.idcandidat.equals(other.idcandidat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Candidat[ idcandidat=" + idcandidat + " ]";
    }
    
}
