/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.ui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.convert.LongConverter;
import mx.slp.helper.LoginHelper;

import mx.slp.entidad.Profesor;
import mx.slp.entidad.Profesorimparteunidad;
import mx.slp.entidad.Unidadaprendizaje;
import mx.slp.helper.ProfesorHelper;
import mx.slp.helper.ProfesorImparteUnidadHelper;
import mx.slp.helper.UnidadAprendizajeHelper;
import org.primefaces.PrimeFaces;
import org.primefaces.context.PrimeFacesContext;

/**
 *
 * @author ghots
 */
@ManagedBean(name = "asignacionBeanUI")
@SessionScoped
public class ProfesorImparteUnidadBeanUI implements Serializable {

    private ProfesorImparteUnidadHelper pIUH;

    public ProfesorImparteUnidadBeanUI() {
        pIUH = new ProfesorImparteUnidadHelper();
    }

    public List<Profesorimparteunidad> obtenerAsignacionesProfesor(Profesor profesor) {
        List<Profesorimparteunidad> listaAux = new ArrayList();
        for (Profesorimparteunidad asignacion : pIUH.getAsignaciones()) {
            if (asignacion.getIdP().equals(profesor)) {
                listaAux.add(asignacion);
            }
        }
        return listaAux;
    }
}
