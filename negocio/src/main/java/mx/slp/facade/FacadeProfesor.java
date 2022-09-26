/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.facade;

import java.util.List;
import mx.slp.delegate.DelegateProfesor;
import mx.slp.entidad.Profesor;
import mx.slp.entidad.Profesorimparteunidad;

/**
 *
 * @author ghots
 */
public class FacadeProfesor {
    private final DelegateProfesor delegateProfesor;
    
    public FacadeProfesor(){
        this.delegateProfesor = new DelegateProfesor();
    }
    
    public void guardarProfesor(Profesor profesor){
        delegateProfesor.saveProfesor(profesor);
    }
    
    public void actualizarProfesor(Profesor profesor){
        delegateProfesor.updateProfesor(profesor);
    }
    
    public void borrarProfesor(Profesor profesor){
        delegateProfesor.deleteProfesor(profesor);
    }
    
    public List<Profesor> obtenerProfesores(){
        return delegateProfesor.getProfesores();
    }
    
    public void guardarUnidades(List<Profesorimparteunidad> unidades){
        delegateProfesor.saveUnidades(unidades);
    }
}
