/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Citoyen;
import entities.Election;
import entities.Listeelectorale;
import entities.ListeelectoralePK;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.datatype.XMLGregorianCalendar;
import outils.Outils;

/**
 *
 * @author YB
 */
@Stateless
public class ListeelectoraleFacade extends AbstractFacade<Listeelectorale> implements ListeelectoraleFacadeLocal {

    @PersistenceContext(unitName = "VoteServicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ListeelectoraleFacade() {
        super(Listeelectorale.class);
    }

    @Override
    public boolean isRegisteredByCitoyenName(String nom, String prenom, Election election) {

        if (nom == null || prenom == null) {
            return false;
        }

        Query cq = em.createQuery("select le from Listeelectorale le where le.citoyen.nom = :nomParam and le.citoyen.prenom = :prenomPram and le.election.intitule =:intituleParam");

        cq.setParameter("nomParam", nom);
        cq.setParameter("prenomPram", prenom);
        cq.setParameter("intituleParam", election.getIntitule());

        // retourne true si le citoyen est inscrit sinon retourne false
        return (!cq.getResultList().isEmpty());
    }

    @Override
    public boolean isRegisteredByIdInscription(String idInscription, Election election) {

        if (!Outils.isNumeric(idInscription)) {
            return false;
        }

        Query cq = em.createQuery("select le from Listeelectorale le where le.idinscription = :idInscriptionParam and le.election.intitule = :intituleParam");

        cq.setParameter("idInscriptionParam", Integer.valueOf(idInscription));
        cq.setParameter("intituleParam", election.getIntitule());

        // retourne true si le citoyen est enregistrer sinon retourne false
        return (!cq.getResultList().isEmpty());
    }

    @Override
    public int getTotalRegistred(Election election) {

        Query cq = em.createQuery("select count(le) from Listeelectorale le where le.election.intitule=:intituleParam");
        cq.setParameter("intituleParam", election.getIntitule());
        long nbrInscrits = (long) cq.getSingleResult();
        
        return (int) nbrInscrits;
    }

    @Override
    public void validerVote(Election election, Citoyen citoyen) {
        Listeelectorale listeelectorale = this.find(new ListeelectoralePK(election.getIdelection(), citoyen.getIdcitoyen()));
        listeelectorale.setAvote(1);
        this.edit(listeelectorale);
    }

    @Override
    public boolean isDateInscriptionValide(XMLGregorianCalendar dateInscription, Citoyen citoyen, Election election) {
        
        if(dateInscription == null)
            return false;

        //Conversion XMLGregorianCalendar à Date
        Date dateP = dateInscription.toGregorianCalendar().getTime();

        Query cq = em.createQuery("select le from Listeelectorale le where le.citoyen.idcitoyen = :idCitoyenParam and le.election.idelection = :idElectionParam and le.dateinscription = :dateP");

        cq.setParameter("idCitoyenParam", citoyen.getIdcitoyen());
        cq.setParameter("idElectionParam", election.getIdelection());
        cq.setParameter("dateP", dateP);

        // retourne true si la date d'inscription est valide sinon retourne false
        return (!cq.getResultList().isEmpty());

    }

}
