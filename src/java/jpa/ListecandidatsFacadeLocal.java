/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Candidat;
import entities.Election;
import entities.Listecandidats;
import java.util.List;
import javax.ejb.Local;
import org.netbeans.xml.schema.vote.CandidatInfo;

/**
 *
 * @author YB
 */
@Local
public interface ListecandidatsFacadeLocal {

    void create(Listecandidats listecandidats);

    void edit(Listecandidats listecandidats);

    void remove(Listecandidats listecandidats);

    Listecandidats find(Object id);

    List<Listecandidats> findAll();

    List<Listecandidats> findRange(int[] range);

    int count();
    
    Candidat getCandidatByNumero(int numeroCandidat, Election election);
    
    
    List<CandidatInfo> getListCandidatsByElection(Election election);
    
    
    
}
