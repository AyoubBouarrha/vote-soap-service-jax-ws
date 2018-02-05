/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Citoyen;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author YB
 */
@Stateless
public class Main {

    //@PersistenceContext(name = "VoteServicePU")
    //@PersistenceUnit(unitName="VoteServicePU")    
    @PersistenceContext(unitName = "VoteServicePU")
    private static EntityManager em;
    
    //static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "VoteServicePU" );

    public static void main(String[] args) {
        
        
         //EntityManager em = emfactory.createEntityManager();
         em.getTransaction( ).begin( );
        
        System.out.println(em.toString());
        
         //em = getEntityManager();
        
        Query cq = em.createQuery("Select le from Listeelectorale le where le.election.intitule = :inIntituleElection and le.citoyen.nom = :inIdCitoyen and le.citoyen.prenom = :inPrenomCitoyen");

        cq.setParameter("inIntituleElection", "el2018");
        cq.setParameter("inNomCitoyen", "BOUARRHA");
        cq.setParameter("inPrenomCitoyen", "Ayoub");
        
        System.out.println(((Citoyen)cq.getSingleResult()).toString());
    }

}
