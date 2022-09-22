/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.delegate;

import java.util.List;
import mx.slp.entidad.Unidadaprendizaje;
import mx.slp.integracion.ServiceLocator;

/**
 *
 * @author ghots
 */
public class DelegateUnidadaprendizaje {
    public void saveUnidad(Unidadaprendizaje uA){
        ServiceLocator.getInstaceUnidadaprendizajeDAO().save(uA);
    }
    
    public List<Unidadaprendizaje> getUnidades(){
        return ServiceLocator.getInstaceUnidadaprendizajeDAO().findAll();
    }
}
