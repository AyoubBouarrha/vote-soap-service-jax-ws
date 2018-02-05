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
public class ListecandidatsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDELECTION")
    private int idelection;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCANDIDAT")
    private int idcandidat;

    public ListecandidatsPK() {
    }

    public ListecandidatsPK(int idelection, int idcandidat) {
        this.idelection = idelection;
        this.idcandidat = idcandidat;
    }

    public int getIdelection() {
        return idelection;
    }

    public void setIdelection(int idelection) {
        this.idelection = idelection;
    }

    public int getIdcandidat() {
        return idcandidat;
    }

    public void setIdcandidat(int idcandidat) {
        this.idcandidat = idcandidat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idelection;
        hash += (int) idcandidat;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListecandidatsPK)) {
            return false;
        }
        ListecandidatsPK other = (ListecandidatsPK) object;
        if (this.idelection != other.idelection) {
            return false;
        }
        if (this.idcandidat != other.idcandidat) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ListecandidatsPK[ idelection=" + idelection + ", idcandidat=" + idcandidat + " ]";
    }
    
}
