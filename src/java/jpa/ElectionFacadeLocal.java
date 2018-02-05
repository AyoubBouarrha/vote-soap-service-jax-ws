/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Election;
import java.util.List;
import javax.ejb.Local;
import javax.xml.datatype.XMLGregorianCalendar;
import org.netbeans.xml.schema.vote.ElectionInfo;

/**
 *
 * @author YB
 */
@Local
public interface ElectionFacadeLocal {

    void create(Election election);

    void edit(Election election);

    void remove(Election election);

    Election find(Object id);

    List<Election> findAll();

    List<Election> findRange(int[] range);

    int count();
    
    ElectionInfo getElectionInfo(Election election);       
    
    Election getElectionByIntitule(String intituleElection); 
    
    Election getElectionByDateElection(XMLGregorianCalendar greDateVote);
    
}
