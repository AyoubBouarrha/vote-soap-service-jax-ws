/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;


import entities.Candidat;
import entities.Election;
import entities.Listecandidats;
import entities.Votes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author YB
 */
@Stateless
public class VotesFacade extends AbstractFacade<Votes> implements VotesFacadeLocal {

    @PersistenceContext(unitName = "VoteServicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VotesFacade() {
        super(Votes.class);
    }

    @Override
    public boolean effectuerVote(Election election, Candidat candidat) {
        Votes vote = new Votes();
        vote.setDatevote(election.getDateelection());
        vote.setListecandidats(new Listecandidats(election.getIdelection(), candidat.getIdcandidat()));

        try {
            em.persist(vote);
            return true;
        } catch (Exception e) {
            return false;
        }

    }



}
