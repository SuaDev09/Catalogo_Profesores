package mx.slp.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.slp.entidad.Profesorimparteunidad;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-25T23:29:24")
@StaticMetamodel(Unidadaprendizaje.class)
public class Unidadaprendizaje_ { 

    public static volatile SingularAttribute<Unidadaprendizaje, Integer> idUnidadAprendizaje;
    public static volatile SingularAttribute<Unidadaprendizaje, Integer> horasLaboratorio;
    public static volatile SingularAttribute<Unidadaprendizaje, Integer> idUA;
    public static volatile SingularAttribute<Unidadaprendizaje, Integer> horasClase;
    public static volatile ListAttribute<Unidadaprendizaje, Profesorimparteunidad> profesorimparteunidadList;
    public static volatile SingularAttribute<Unidadaprendizaje, String> nombre;
    public static volatile SingularAttribute<Unidadaprendizaje, Integer> horasTaller;

}