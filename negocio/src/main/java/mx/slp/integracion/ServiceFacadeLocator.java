
package mx.slp.integracion;

import mx.slp.facade.FacadeProfesor;
import mx.slp.facade.FacadeUnidad;

/**
 *
 * @author ghots
 */
public class ServiceFacadeLocator {
    
    private static FacadeProfesor facadeProfesor;
    private static FacadeUnidad facadeUnidad;
    
    public static FacadeProfesor getInstanceFacadeProfesor() {
        if (facadeProfesor == null) {
            facadeProfesor = new FacadeProfesor();
            return facadeProfesor;
        } else {
            return facadeProfesor;
        }
    }
    
    public static FacadeUnidad getInstanceFacadeUnidad() {
        if (facadeUnidad == null) {
            facadeUnidad = new FacadeUnidad();
            return facadeUnidad;
        } else {
            return facadeUnidad;
        }
    }
    
}
