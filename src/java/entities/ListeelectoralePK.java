/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author YB
 */
@Embeddable
public class ListeelectoralePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDELECTION")
    private int idelection;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCITOYEN")
    private int idcitoyen;

    public ListeelectoralePK() {
    }

    public ListeelectoralePK(int idelection, int idcitoyen) {
        this.idelection = idelection;
        this.idcitoyen = idcitoyen;
    }

    public int getIdelection() {
        return idelection;
    }

    public void setIdelection(int idelection) {
        this.idelection = idelection;
    }

    public int getIdcitoyen() {
        return idcitoyen;
    }

    public void setIdcitoyen(int idcitoyen) {
        this.idcitoyen = idcitoyen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idelection;
        hash += (int) idcitoyen;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListeelectoralePK)) {
            return false;
        }
        ListeelectoralePK other = (ListeelectoralePK) object;
        if (this.idelection != other.idelection) {
            return false;
        }
        if (this.idcitoyen != other.idcitoyen) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ListeelectoralePK[ idelection=" + idelection + ", idcitoyen=" + idcitoyen + " ]";
    }
    
}
