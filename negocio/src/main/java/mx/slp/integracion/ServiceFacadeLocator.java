/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.integracion;

import mx.slp.facade.FacadeProfesor;
import mx.slp.facade.FacadeUnidadaprendizaje;

/**
 *
 * @author ghots
 */
public class ServiceFacadeLocator {
    private static FacadeProfesor facadeProfesor;
    private static FacadeUnidadaprendizaje facadeUnidad;
 
    public static FacadeProfesor getInstanceFacadeProfesor(){
        if(facadeProfesor == null) {
            facadeProfesor = new FacadeProfesor();
            return facadeProfesor;
        } else {
            return facadeProfesor;
        }
    }
    
    public static FacadeUnidadaprendizaje getInstanceFacadeUnidad(){
        if(facadeUnidad == null){
            facadeUnidad = new FacadeUnidadaprendizaje();
            return facadeUnidad;
        } else {
            return facadeUnidad;
        }
    }
}
