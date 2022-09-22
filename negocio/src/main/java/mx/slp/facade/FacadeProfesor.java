/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.facade;

import mx.slp.delegate.DelegateProfesor;
import mx.slp.entidad.Profesor;

/**
 *
 * @author ghots
 */
public class FacadeProfesor {
    public final DelegateProfesor delegateProfesor;
    
    public FacadeProfesor(){
        this.delegateProfesor = new DelegateProfesor();
    }
    
    public void guardarProfesor(Profesor profesor){
        delegateProfesor.saveProfesor(profesor);
    }
}
