package entities;

import entities.Listecandidats;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-26T00:41:43")
@StaticMetamodel(Candidat.class)
public class Candidat_ { 

    public static volatile SingularAttribute<Candidat, String> affiliation;
    public static volatile SingularAttribute<Candidat, String> nom;
    public static volatile SingularAttribute<Candidat, String> prenom;
    public static volatile SingularAttribute<Candidat, Integer> idcandidat;
    public static volatile CollectionAttribute<Candidat, Listecandidats> listecandidatsCollection;

}