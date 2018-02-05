/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Candidat;
import entities.Election;
import entities.Listecandidats;
import entities.ListecandidatsPK;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.netbeans.xml.schema.vote.CandidatInfo;

/**
 *
 * @author YB
 */
@Stateless
public class ListecandidatsFacade extends AbstractFacade<Listecandidats> implements ListecandidatsFacadeLocal {

    @PersistenceContext(unitName = "VoteServicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ListecandidatsFacade() {
        super(Listecandidats.class);
    }

    @Override
    public Candidat getCandidatByNumero(int numeroCandidat, Election election) {
        if (election == null) {
            return null;
        }

        Query cq = em.createQuery("select lc.candidat from Listecandidats lc where lc.numerocandidat = :numeroCandidatParam and lc.election.idelection = :idElectionParam");

        cq.setParameter("numeroCandidatParam", numeroCandidat);
        cq.setParameter("idElectionParam", election.getIdelection());

        if (cq.getResultList().isEmpty()) {
            return null;
        }

        return (Candidat) cq.getSingleResult();
    }

    @Override
    public List<CandidatInfo> getListCandidatsByElection(Election election) {
        if (election == null) {
            return null;
        }

        Query cq = em.createQuery("select lc.candidat from Listecandidats lc where lc.election.idelection = :idElectionParam");

        cq.setParameter("idElectionParam", election.getIdelection());

        List<CandidatInfo> listCandidatInfo = new ArrayList<>();

        for (Candidat candidat : (List<Candidat>) cq.getResultList()) {
            CandidatInfo candidatInfo = new CandidatInfo();
            candidatInfo.setNom(candidat.getNom());
            candidatInfo.setPrenom(candidat.getPrenom());
            candidatInfo.setNumeroCandidat(((Listecandidats)this.find(new ListecandidatsPK(election.getIdelection(), candidat.getIdcandidat()))).getNumerocandidat());
            candidatInfo.setAffiliation(candidat.getAffiliation());

            listCandidatInfo.add(candidatInfo);
        }

        return listCandidatInfo;
    }

}
