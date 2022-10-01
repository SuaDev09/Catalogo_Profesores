/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.helper;

import java.io.Serializable;
import java.util.List;
import mx.slp.entidad.Profesor;
import mx.slp.entidad.Profesorimparteunidad;
import mx.slp.entidad.Unidadaprendizaje;
import mx.slp.integracion.ServiceFacadeLocator;
import mx.slp.integracion.ServiceLocator;

/**
 *
 * @author ghots
 */
public class ProfesorHelper implements Serializable {

    public void saveProfesor(Profesor profesor, List<Unidadaprendizaje> uA) {
        ServiceFacadeLocator.getInstanceFacadeProfesor().guardarProfesor(profesor);
        for (Unidadaprendizaje unidadaprendizaje : uA) {
            ServiceLocator.getInstaceProfesorImparteDAO().save(new Profesorimparteunidad(Integer.SIZE, unidadaprendizaje, profesor));
        }
    }

    public void deleteProfesor(Profesor profesor) {
        ServiceFacadeLocator.getInstanceFacadeProfesor().borrarProfesor(profesor);
    }

    public List<Profesor> getProfesores() {
        return ServiceFacadeLocator.getInstanceFacadeProfesor().obtenerProfesores();
    }

    public void updateProfesor(Profesor profesor) {
        ServiceFacadeLocator.getInstanceFacadeProfesor().actualizarProfesor(profesor);
    }

    public void setUnidadesImpartidas(List<Profesorimparteunidad> unidades) {
    }
}
