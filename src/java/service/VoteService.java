/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Candidat;
import entities.Citoyen;
import entities.Election;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import jpa.CitoyenFacadeLocal;
import jpa.ElectionFacadeLocal;
import jpa.ListecandidatsFacadeLocal;
import jpa.ListeelectoraleFacadeLocal;
import jpa.VotesFacadeLocal;
import org.netbeans.j2ee.wsdl.voteservice.wsdl.voteservice.EffectuerVoteFault;
import org.netbeans.j2ee.wsdl.voteservice.wsdl.voteservice.VerifierInscriptionFault;
import org.netbeans.xml.schema.vote.CitoyenInfo;
import org.netbeans.xml.schema.vote.ElectionInfo;
import org.netbeans.xml.schema.vote.VoteChoixInType;
import org.netbeans.xml.schema.vote.VoteChoixOutType;
import org.netbeans.xml.schema.vote.VoteVerifInType;
import org.netbeans.xml.schema.vote.VoteVerifOutType;

/**
 *
 * @author YB
 */
@WebService(serviceName = "VoteService", portName = "VoteServicePort", endpointInterface = "org.netbeans.j2ee.wsdl.voteservice.wsdl.voteservice.VoteServicePortType", targetNamespace = "http://j2ee.netbeans.org/wsdl/VoteService/wsdl/VoteService", wsdlLocation = "META-INF/wsdl/VoteService/VoteService.wsdl")
@Stateless
public class VoteService {

    @Inject
    ListeelectoraleFacadeLocal listeelectoraleFacadeLocal;

    @Inject
    CitoyenFacadeLocal citoyenFacadeLocal;

    @Inject
    ElectionFacadeLocal electionFacadeLocal;

    @Inject
    ListecandidatsFacadeLocal listecandidatsFacadeLocal;

    @Inject
    VotesFacadeLocal votesFacadeLocal;

    public VoteVerifOutType verifierInscription(VoteVerifInType voteVerifIn) throws VerifierInscriptionFault {

        VoteVerifOutType voteVerifOutType = new VoteVerifOutType();

        //Recuperation de l'election par l'intitule
        Election election = electionFacadeLocal.getElectionByIntitule(voteVerifIn.getIntituleElection());

        if (election == null) {
            voteVerifOutType.setRefus("Erreur VerificationVote - Election non Valide");
            return voteVerifOutType;
        }

        //Recuperation du citoyen par son nom et prenom
        Citoyen citoyenByName = citoyenFacadeLocal.getCitoyenByName(voteVerifIn.getCitoyenInfo().getNom(), voteVerifIn.getCitoyenInfo().getPrenom());

        if (citoyenByName == null) {
            voteVerifOutType.setRefus("Erreur VerificationVote - Citoyen ayant le nom:" + voteVerifIn.getCitoyenInfo().getNom() + " et le prenom:" + voteVerifIn.getCitoyenInfo().getPrenom() + " n'existe pas");
            return voteVerifOutType;
        }

        //Test de validite de la date de naissance du citoyen
        boolean dateNaissanceValdie = citoyenFacadeLocal.isDateNaissanceValide(citoyenByName, voteVerifIn.getCitoyenInfo().getDateNaissance());

        if (!dateNaissanceValdie) {
            voteVerifOutType.setRefus("Erreur VerificationVote - Date de naissance incorrect");
            return voteVerifOutType;
        }

        //Test d'inscription du citoyen
        boolean estInscritParNomCityon = listeelectoraleFacadeLocal.isRegisteredByCitoyenName(voteVerifIn.getCitoyenInfo().getNom(), voteVerifIn.getCitoyenInfo().getPrenom(), election);

        if (!estInscritParNomCityon) {
            voteVerifOutType.setRefus("Erreur VerificationVote - Citoyen non inscrit");
            return voteVerifOutType;
        }

        Citoyen citoyenById = citoyenFacadeLocal.getCitoyenByIdInscription(voteVerifIn.getIdInscription());

        //Test de correspondance entre id inscription et le citoyen
        if (citoyenById == null || !citoyenById.equals(citoyenByName)) {
            voteVerifOutType.setRefus("Erreur VerificationVote - Id Inscription ne correspond pas au citoyen " + voteVerifIn.getCitoyenInfo().getNom() + " " + voteVerifIn.getCitoyenInfo().getPrenom());
            return voteVerifOutType;
        }

        //Test de validite de la date d'inscription
        boolean dateInscriptionValide = listeelectoraleFacadeLocal.isDateInscriptionValide(voteVerifIn.getDate(), citoyenById, election);

        if (!dateInscriptionValide) {
            voteVerifOutType.setRefus("Erreur VerificationVote - Date inscription invalide");
            return voteVerifOutType;
        }

        voteVerifOutType.setCitoyenInfo(voteVerifIn.getCitoyenInfo());

        //Recuperation de ElectionInfo
        ElectionInfo electionInfo = electionFacadeLocal.getElectionInfo(election);

        //Recuperation de nombre des inscrits
        electionInfo.setNombreInscrits(listeelectoraleFacadeLocal.getTotalRegistred(election));

        //Recuperation de la liste des candidats
        voteVerifOutType.setCandidatInfo(listecandidatsFacadeLocal.getListCandidatsByElection(election));

        voteVerifOutType.setElectionInfo(electionInfo);

        return voteVerifOutType;

    }

    public VoteChoixOutType effectuerVote(VoteChoixInType voteChoixIn) throws EffectuerVoteFault {

        VoteChoixOutType voteChoixOutType = new VoteChoixOutType();

        //Recuperation Election
        Election election = electionFacadeLocal.getElectionByDateElection(voteChoixIn.getDate());

        if (election == null) {
            voteChoixOutType.setValidation("Erreur EffectuerVote - Date de vote invalide");
            return voteChoixOutType;
        }

        //Recuperation Candidat Par numCandidat + contrôle de présence du candidat dans l'éléction courante
        Candidat candidat = listecandidatsFacadeLocal.getCandidatByNumero(voteChoixIn.getNumeroCandidat(), election);

        if (candidat == null) {
            voteChoixOutType.setValidation("Erreur EffectuerVote - NumeroCandidat non valide");
            return voteChoixOutType;
        }

        //Recuperation Citoyen
        Citoyen citoyenByName = citoyenFacadeLocal.getCitoyenByName(voteChoixIn.getCitoyenInfo().getNom(), voteChoixIn.getCitoyenInfo().getPrenom());

        if (citoyenByName == null) {
            voteChoixOutType.setValidation("Erreur EffectuerVote - Citoyen ayant le nom:" + voteChoixIn.getCitoyenInfo().getNom() + " et le prenom:" + voteChoixIn.getCitoyenInfo().getPrenom() + " n'existe pas");
            return voteChoixOutType;
        }

        //Test de validite de la date de naissance du citoyen
        boolean dateNaissanceValdie = citoyenFacadeLocal.isDateNaissanceValide(citoyenByName, voteChoixIn.getCitoyenInfo().getDateNaissance());

        if (!dateNaissanceValdie) {
            voteChoixOutType.setValidation("Erreur EffectuerVote - Date de naissance incorrect");
            return voteChoixOutType;
        }

        //Test d'inscription du citoyen
        boolean estInscritParNomCityon = listeelectoraleFacadeLocal.isRegisteredByCitoyenName(voteChoixIn.getCitoyenInfo().getNom(), voteChoixIn.getCitoyenInfo().getPrenom(), election);

        if (!estInscritParNomCityon) {
            voteChoixOutType.setValidation("Erreur EffectuerVote - Citoyen non inscrit");
            return voteChoixOutType;
        }

        Citoyen citoyenById = citoyenFacadeLocal.getCitoyenByIdInscription(voteChoixIn.getIdInscription());

        //Test de correspondance entre id inscription et le citoyen
        if (citoyenById == null || !citoyenById.equals(citoyenByName)) {
            voteChoixOutType.setValidation("Erreur EffectuerVote - Id Inscription ne correspond pas au citoyen " + voteChoixIn.getCitoyenInfo().getNom() + " " + voteChoixIn.getCitoyenInfo().getPrenom());
            return voteChoixOutType;
        }

        //Effectuer le vote
        boolean effectuee = votesFacadeLocal.effectuerVote(election, candidat);

        // cas catch
        if (!effectuee) {
            throw new EffectuerVoteFault("Erreur EffectuerVote - Vote non effectuer", "Vote non effectuer");
        }

        if (effectuee) {

            //Valider Vote (aVote=1)
            listeelectoraleFacadeLocal.validerVote(election, citoyenByName);

            //Recuperation CitoyenInfo
            CitoyenInfo citoyenInfo = citoyenFacadeLocal.getCitoyenInfo(citoyenByName);
            voteChoixOutType.setCitoyenInfo(citoyenInfo);
            voteChoixOutType.setValidation("Vote bien effectuée");
        }

        return voteChoixOutType;
    }

}
