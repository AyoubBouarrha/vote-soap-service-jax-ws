package entities;

import entities.Listeelectorale;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-26T00:41:43")
@StaticMetamodel(Citoyen.class)
public class Citoyen_ { 

    public static volatile SingularAttribute<Citoyen, String> nationalite;
    public static volatile CollectionAttribute<Citoyen, Listeelectorale> listeelectoraleCollection;
    public static volatile SingularAttribute<Citoyen, String> localite;
    public static volatile SingularAttribute<Citoyen, Integer> idcitoyen;
    public static volatile SingularAttribute<Citoyen, Integer> codepostal;
    public static volatile SingularAttribute<Citoyen, Date> datenaissance;
    public static volatile SingularAttribute<Citoyen, String> adresse;
    public static volatile SingularAttribute<Citoyen, String> nom;
    public static volatile SingularAttribute<Citoyen, String> prenom;
    public static volatile SingularAttribute<Citoyen, String> pays;

}