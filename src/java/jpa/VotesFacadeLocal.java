/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Candidat;
import entities.Election;
import entities.Votes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author YB
 */
@Local
public interface VotesFacadeLocal {

    void create(Votes votes);

    void edit(Votes votes);

    void remove(Votes votes);

    Votes find(Object id);

    List<Votes> findAll();

    List<Votes> findRange(int[] range);

    int count();
    
    boolean effectuerVote(Election election, Candidat candidat );
    
}
