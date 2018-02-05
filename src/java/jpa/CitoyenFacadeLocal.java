/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Citoyen;
import java.util.List;
import javax.ejb.Local;
import javax.xml.datatype.XMLGregorianCalendar;
import org.netbeans.xml.schema.vote.CitoyenInfo;

/**
 *
 * @author YB
 */
@Local
public interface CitoyenFacadeLocal {

    void create(Citoyen citoyen);

    void edit(Citoyen citoyen);

    void remove(Citoyen citoyen);

    Citoyen find(Object id);

    List<Citoyen> findAll();

    List<Citoyen> findRange(int[] range);

    int count();
    
    CitoyenInfo getCitoyenInfo(Citoyen citoyen);
    
    Citoyen getCitoyenByIdInscription(String idInscription);  
    
    Citoyen getCitoyenByName(String nomCitoyen, String prenoCitoyen);  
    
    boolean isDateNaissanceValide(Citoyen citoyen, XMLGregorianCalendar dateNaissance);
    
}
