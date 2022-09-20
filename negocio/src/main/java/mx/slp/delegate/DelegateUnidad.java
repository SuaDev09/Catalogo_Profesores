/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.delegate;

import java.util.List;
import mx.slp.entidad.UnidadAprendizaje;
import mx.slp.integracion.ServiceLocator;

/**
 *
 * @author ghots
 */
public class DelegateUnidad {
    
    public void saveUnidadAprendizaje(UnidadAprendizaje uA){
        ServiceLocator.getInstacenUnidadAprendizajeDAO().save(uA);
    }

    public List<UnidadAprendizaje> getUnidades(){
        return ServiceLocator.getInstacenUnidadAprendizajeDAO().findAll();
    } 
    
}
