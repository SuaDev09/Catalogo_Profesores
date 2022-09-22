package mx.slp.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.slp.entidad.Profesorimparteunidad;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-22T00:37:20")
@StaticMetamodel(UnidadAprendizaje.class)
public class UnidadAprendizaje_ { 

    public static volatile SingularAttribute<UnidadAprendizaje, Integer> idUnidadAprendizaje;
    public static volatile SingularAttribute<UnidadAprendizaje, Integer> horasLaboratorio;
    public static volatile SingularAttribute<UnidadAprendizaje, Integer> idUA;
    public static volatile SingularAttribute<UnidadAprendizaje, Integer> horasClase;
    public static volatile ListAttribute<UnidadAprendizaje, Profesorimparteunidad> profesorimparteunidadList;
    public static volatile SingularAttribute<UnidadAprendizaje, String> nombre;
    public static volatile SingularAttribute<UnidadAprendizaje, Integer> horasTaller;

}