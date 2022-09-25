/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.helper;

import java.util.List;
import mx.slp.entidad.Profesor;
import mx.slp.integracion.ServiceFacadeLocator;

/**
 *
 * @author ghots
 */
public class ProfesorHelper {
    public void saveProfesor(Profesor profesor){
        ServiceFacadeLocator.getInstanceFacadeProfesor().guardarProfesor(profesor);
    }
    
    
    public void deleteProfesor(Profesor profesor){
        ServiceFacadeLocator.getInstanceFacadeProfesor().borrarProfesor(profesor);
    }
    
    public List<Profesor> getProfesores(){
        return ServiceFacadeLocator.getInstanceFacadeProfesor().obtenerProfesores();
    }
}
