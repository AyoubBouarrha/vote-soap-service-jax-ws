/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Election;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.netbeans.xml.schema.vote.ElectionInfo;
import service.VoteService;

/**
 *
 * @author YB
 */
@Stateless
public class ElectionFacade extends AbstractFacade<Election> implements ElectionFacadeLocal {

    @PersistenceContext(unitName = "VoteServicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ElectionFacade() {
        super(Election.class);
    }

    @Override
    public ElectionInfo getElectionInfo(Election election) {

        ElectionInfo electionInfo = new ElectionInfo();

        electionInfo.setIntituleElection(election.getIntitule());

        //Conversion Date à XMLGregorianCalendar
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(election.getDateelection());
        try {
            electionInfo.setDateElection(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(VoteService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return electionInfo;
    }

    @Override
    public Election getElectionByIntitule(String intituleElection) {
        Query cq = em.createQuery("select e from Election e where e.intitule = :intituleElection ");

        cq.setParameter("intituleElection", intituleElection);

        if (cq.getResultList().isEmpty()) {
            return null;
        }

        Election election = (Election) cq.getSingleResult();

        return election;
    }

    @Override
    public Election getElectionByDateElection(XMLGregorianCalendar greDateVote) {
        Date dateElection = greDateVote.toGregorianCalendar().getTime();

        Query cq = em.createQuery("select e from Election e where e.dateelection = :dateElectionParam ");

        Query cq2 = em.createQuery("select le.election.dateelection from Listeelectorale le where le.idinscription = :id ");

        cq.setParameter("dateElectionParam", dateElection);

        if (cq.getResultList().isEmpty()) {
            return null;
        }

        Election election = (Election) cq.getSingleResult();

        return election;
    }
    
    
}
