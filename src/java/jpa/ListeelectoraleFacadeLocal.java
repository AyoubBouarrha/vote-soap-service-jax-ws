/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Citoyen;
import entities.Election;
import entities.Listeelectorale;
import java.util.List;
import javax.ejb.Local;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author YB
 */
@Local
public interface ListeelectoraleFacadeLocal {

    void create(Listeelectorale listeelectorale);

    void edit(Listeelectorale listeelectorale);

    void remove(Listeelectorale listeelectorale);

    Listeelectorale find(Object id);

    List<Listeelectorale> findAll();

    List<Listeelectorale> findRange(int[] range);

    int count();     
    
    boolean isRegisteredByCitoyenName(String nom, String prenom, Election election);
    
    boolean isRegisteredByIdInscription(String idInscription , Election election);
    
    boolean isDateInscriptionValide(XMLGregorianCalendar dateInscription, Citoyen citoyen , Election election);
    
    int getTotalRegistred (Election election);
    
    void validerVote (Election election, Citoyen citoyen);  
    
}
