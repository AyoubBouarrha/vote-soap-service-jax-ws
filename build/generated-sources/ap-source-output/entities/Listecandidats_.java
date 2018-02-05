package entities;

import entities.Candidat;
import entities.Election;
import entities.ListecandidatsPK;
import entities.Votes;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-26T00:41:43")
@StaticMetamodel(Listecandidats.class)
public class Listecandidats_ { 

    public static volatile CollectionAttribute<Listecandidats, Votes> votesCollection;
    public static volatile SingularAttribute<Listecandidats, Election> election;
    public static volatile SingularAttribute<Listecandidats, ListecandidatsPK> listecandidatsPK;
    public static volatile SingularAttribute<Listecandidats, Candidat> candidat;
    public static volatile SingularAttribute<Listecandidats, Integer> numerocandidat;

}