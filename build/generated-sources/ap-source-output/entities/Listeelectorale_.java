package entities;

import entities.Citoyen;
import entities.Election;
import entities.ListeelectoralePK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-26T00:41:43")
@StaticMetamodel(Listeelectorale.class)
public class Listeelectorale_ { 

    public static volatile SingularAttribute<Listeelectorale, Election> election;
    public static volatile SingularAttribute<Listeelectorale, ListeelectoralePK> listeelectoralePK;
    public static volatile SingularAttribute<Listeelectorale, Integer> avote;
    public static volatile SingularAttribute<Listeelectorale, Integer> idinscription;
    public static volatile SingularAttribute<Listeelectorale, Date> dateinscription;
    public static volatile SingularAttribute<Listeelectorale, Citoyen> citoyen;

}