package entities;

import entities.Listecandidats;
import entities.Listeelectorale;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-26T00:41:43")
@StaticMetamodel(Election.class)
public class Election_ { 

    public static volatile SingularAttribute<Election, Integer> idelection;
    public static volatile CollectionAttribute<Election, Listeelectorale> listeelectoraleCollection;
    public static volatile SingularAttribute<Election, Date> dateelection;
    public static volatile SingularAttribute<Election, String> intitule;
    public static volatile CollectionAttribute<Election, Listecandidats> listecandidatsCollection;

}