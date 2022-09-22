/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.delegate;

import mx.slp.entidad.Profesor;
import mx.slp.integracion.ServiceLocator;

/**
 *
 * @author ghots
 */
public class DelegateProfesor {
    public void saveProfesor(Profesor profesor){
        ServiceLocator.getInstaceProfesorDAO().save(profesor);
    }
}
