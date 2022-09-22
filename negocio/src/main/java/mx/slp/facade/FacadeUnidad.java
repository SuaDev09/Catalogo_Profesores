/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.facade;

import mx.slp.delegate.DelegateUnidad;
import mx.slp.entidad.Unidadaprendizaje;

/**
 *
 * @author ghots
 */
public class FacadeUnidad {
    private final DelegateUnidad delegateUnidad;
    
    public FacadeUnidad(){
        this.delegateUnidad = new DelegateUnidad();
    }
    
    public void saveUnidad(Unidadaprendizaje uA){
        delegateUnidad.saveUnidadAprendizaje(uA);
    }
}
