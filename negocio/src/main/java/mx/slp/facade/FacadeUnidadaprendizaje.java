/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.facade;

import java.util.List;
import mx.slp.delegate.DelegateUnidadaprendizaje;
import mx.slp.entidad.Unidadaprendizaje;

/**
 *
 * @author ghots
 */
public class FacadeUnidadaprendizaje {
    private final DelegateUnidadaprendizaje delegateUnidad;
    
    public FacadeUnidadaprendizaje(){
        this.delegateUnidad = new DelegateUnidadaprendizaje();
    }
    
    public void guardarUnidad(Unidadaprendizaje uA){
        delegateUnidad.saveUnidad(uA);
    }
    
    public List<Unidadaprendizaje> obtenerUnidades(){
        return delegateUnidad.getUnidades();
    }
}
