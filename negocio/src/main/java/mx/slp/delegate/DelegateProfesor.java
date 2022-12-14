/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.delegate;

import java.util.List;
import mx.slp.entidad.Profesor;
import mx.slp.entidad.Profesorimparteunidad;
import mx.slp.integracion.ServiceLocator;

/**
 *
 * @author ghots
 */
public class DelegateProfesor {

    public void saveProfesor(Profesor profesor) {
        ServiceLocator.getInstaceProfesorDAO().save(profesor);
    }

    public void updateProfesor(Profesor profesor){
        ServiceLocator.getInstaceProfesorDAO().update(profesor);
    }
    
    public void deleteProfesor(Profesor profesor) {
        ServiceLocator.getInstaceProfesorDAO().delete(profesor);
    }

    public List<Profesor> getProfesores() {
        return ServiceLocator.getInstaceProfesorDAO().findAll();
    }

    public void saveUnidades(List<Profesorimparteunidad> unidades) {
        for (Profesorimparteunidad unidad : unidades) {
            ServiceLocator.getInstaceProfesorImparteDAO().save(unidad);
        }
    }
}
