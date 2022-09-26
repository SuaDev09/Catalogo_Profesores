/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.ui;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.slp.helper.LoginHelper;

import mx.slp.entidad.Profesor;
import mx.slp.entidad.Profesorimparteunidad;
import mx.slp.entidad.Unidadaprendizaje;
import mx.slp.helper.ProfesorHelper;
import mx.slp.helper.UnidadAprendizajeHelper;
import org.primefaces.PrimeFaces;
import org.primefaces.context.PrimeFacesContext;

/**
 *
 * @author ghots
 */
@ManagedBean(name = "profesorBeanUI")
@SessionScoped
public class ProfesorBeanUI implements Serializable {

    private ProfesorHelper profesorHelper;
    private UnidadAprendizajeHelper unidadHelper;
    private Profesor profesor;
    private List<Profesorimparteunidad> imparte;
        private List<Profesorimparteunidad> impartidas;

    private List<Unidadaprendizaje> unidad;

    public ProfesorBeanUI() {
        profesorHelper = new ProfesorHelper();
    }

//    Metodo postconstructor
//    Todo lo que este dentro de este metodo sera 
//    lo primero que carque la pagina      
    @PostConstruct
    public void init() {
        profesor = new Profesor();
    }

    public void agregar() throws IOException {

        String mensaje = rfcValido(profesor.getRfc());
        if (!unidadHelper.getUnidades().isEmpty()) {
            if (!mensaje.equals("")) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error RFC", "El rfc " + mensaje);
                PrimeFaces.current().dialog().showMessageDynamic(message);
            } else if (validarID(profesor.getIdProfesor()) == true) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error ID profesor", "El ID del profesor ya a sido ingresado");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            } else {
                if (!imparte.isEmpty()) {
                    profesor.setIdP(0);
                    profesorHelper.saveProfesor(profesor);
                    for (int i = 0; i < imparte.size(); i++) {
                        imparte.get(i).setIdProfesorImparteUnidad(0);
                        imparte.get(i).setIdP(profesor);
                    }
                    profesorHelper.setUnidadesImpartidas(imparte);
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Profesor", "El profesor a sido registrado de manera exitosa.");
                    PrimeFaces.current().dialog().showMessageDynamic(message);
                    profesor = new Profesor();
                } else{
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No has asignado unidades de aprendizaje al profesor.");
                    PrimeFaces.current().dialog().showMessageDynamic(message);
                }

            }
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No puedes ingresar profesores debido a que no hay unidades de aprendizaje registradas.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        }

    }

    public void eliminar() {
        profesorHelper.deleteProfesor(profesor);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Profesor", "El profesor a sido eliminado de manera exitosa.");
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public List<Profesor> obtenerProfesores() {
        return profesorHelper.getProfesores();
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public boolean validarID(int id) {
        boolean bandera = false;
        for (Profesor profesor : profesorHelper.getProfesores()) {
            if (profesor.getIdProfesor() == id) {
                bandera = true;
                break;
            }
        }

        return bandera;
    }

    public String rfcValido(String rfc) {
        boolean bandera = false;
        String mensaje = "";

        if (profesor.getRfc().length() > 13) {
            mensaje = "es mayor de 13";
            bandera = true;
        } else if (profesor.getRfc().length() < 13) {
            mensaje = "es menor que 13";
            bandera = true;
        }

        return mensaje;
    }

//    public List<Unidadaprendizaje> obtenerUnidades() {
//        return unidadHelper.getUnidades();
//    }

}
