package mx.slp.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.slp.entidad.Profesorimparteunidad;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-19T14:30:00")
@StaticMetamodel(Profesor.class)
public class Profesor_ { 

    public static volatile SingularAttribute<Profesor, String> apellidoPaterno;
    public static volatile SingularAttribute<Profesor, Integer> idProfesor;
    public static volatile ListAttribute<Profesor, Profesorimparteunidad> profesorimparteunidadList;
    public static volatile SingularAttribute<Profesor, Integer> id;
    public static volatile SingularAttribute<Profesor, String> nombre;
    public static volatile SingularAttribute<Profesor, String> rfc;
    public static volatile SingularAttribute<Profesor, String> apellidoMaterno;

}