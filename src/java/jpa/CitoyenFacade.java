/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Citoyen;
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
import org.netbeans.xml.schema.vote.CitoyenInfo;
import outils.Outils;
import service.VoteService;

/**
 *
 * @author YB
 */
@Stateless
public class CitoyenFacade extends AbstractFacade<Citoyen> implements CitoyenFacadeLocal {

    @PersistenceContext(unitName = "VoteServicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitoyenFacade() {
        super(Citoyen.class);
    }

    @Override
    public CitoyenInfo getCitoyenInfo(Citoyen citoyen) {

        CitoyenInfo citoyenInfo = new CitoyenInfo();

        citoyenInfo.setNom(citoyen.getNom());
        citoyenInfo.setPrenom(citoyen.getPrenom());

        //conversion de Date à XMLGregorianCalendar
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(citoyen.getDatenaissance());
        try {
            citoyenInfo.setDateNaissance(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(VoteService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return citoyenInfo;
    }

    @Override
    public Citoyen getCitoyenByIdInscription(String idInscription) {
        if(!Outils.isNumeric(idInscription))
            return null;
        
        Query cq = em.createQuery("select le.citoyen from Listeelectorale le where le.idinscription = :idInscriptionParam");
        cq.setParameter("idInscriptionParam", Integer.valueOf(idInscription));
        
        if(cq.getResultList().isEmpty())
            return null;
        
        return (Citoyen) cq.getSingleResult();
    }

    @Override
    public Citoyen getCitoyenByName(String nomCitoyen, String prenomCitoyen) {
        Query cq = em.createQuery("select ci from Citoyen ci where ci.nom = :nomParam and ci.prenom = :prenomPram");
        cq.setParameter("nomParam", nomCitoyen);
        cq.setParameter("prenomPram", prenomCitoyen);
        
        if(cq.getResultList().isEmpty())
            return null;
        
        return (Citoyen) cq.getSingleResult();
    }

    @Override
    public boolean isDateNaissanceValide(Citoyen citoyen, XMLGregorianCalendar dateNaissance) {
         if(dateNaissance == null)
            return false;

        //Conversion XMLGregorianCalendar à Date
        Date dateP = dateNaissance.toGregorianCalendar().getTime();
        
        System.out.println(dateP.toString() + "----"+ citoyen.getDatenaissance());
        
        return  citoyen.getDatenaissance().equals(dateP);
    }
    

}
