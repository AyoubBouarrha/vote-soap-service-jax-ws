package entities;

import entities.Listecandidats;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-26T00:41:43")
@StaticMetamodel(Votes.class)
public class Votes_ { 

    public static volatile SingularAttribute<Votes, Integer> idvote;
    public static volatile SingularAttribute<Votes, Date> datevote;
    public static volatile SingularAttribute<Votes, Listecandidats> listecandidats;

}