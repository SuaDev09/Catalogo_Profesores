/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.helper;

import java.io.Serializable;
import java.util.List;
import mx.slp.entidad.Unidadaprendizaje;
import mx.slp.entidad.Usuario;
import mx.slp.integracion.ServiceFacadeLocator;

/**
 *
 * @author ghots
 */
public class UnidadAprendizajeHelper implements Serializable{
    
    
    public void saveUnidad(Unidadaprendizaje uA){
        ServiceFacadeLocator.getInstanceFacadeUnidad().guardarUnidad(uA);
    }
    
    public List<Unidadaprendizaje> getUnidades(){
        return ServiceFacadeLocator.getInstanceFacadeUnidad().obtenerUnidades();
    }
}
