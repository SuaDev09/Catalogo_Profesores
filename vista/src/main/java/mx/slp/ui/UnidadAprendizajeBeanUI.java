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
import mx.slp.entidad.Profesorimparteunidad;
import mx.slp.helper.LoginHelper;

import mx.slp.entidad.Unidadaprendizaje;
import mx.slp.helper.UnidadAprendizajeHelper;
import org.primefaces.PrimeFaces;
import org.primefaces.context.PrimeFacesContext;

/**
 *
 * @author ghots
 */
@ManagedBean(name = "unidadAprendizajeBeanUI")
@SessionScoped
public class UnidadAprendizajeBeanUI implements Serializable {

    private UnidadAprendizajeHelper unidadHelper;
    private Unidadaprendizaje uA;

    public UnidadAprendizajeBeanUI() {
        unidadHelper = new UnidadAprendizajeHelper();
    }

//    Metodo postconstructor
//    Todo lo que este dentro de este metodo sera 
//    lo primero que carque la pagina      
    @PostConstruct
    public void init() {
        uA = new Unidadaprendizaje();
    }

    public void agregar() throws IOException {
        String sonHorasValidas = sonHorasValidas(uA.getHorasClase(), uA.getHorasTaller(), uA.getHorasLaboratorio());
        if (esIdValido(uA.getIdUnidadAprendizaje())) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "ID error", "Este ID de la unidad de aprendizaje ya se encuentra utilizado.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        } else if (!sonHorasValidas.equals("")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, sonHorasValidas, "Favor de comprobar que las horas sean validas.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        } else {
            uA.setIdUA(0);
            unidadHelper.saveUnidad(uA);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Unidad de Aprendizaje", "La unidad de aprendizaje se ha guardado de manera correcta.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            uA = new Unidadaprendizaje();
            //FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/UnidadesAprendizaje/UnidadesAprendizaje.xhtml");
        }
    }

    //Retornar lista de todas las profesorimparteunidad
    
    public List<Unidadaprendizaje> obtenerUnidades() {
        return unidadHelper.getUnidades();
    }

//    getters y setters
    public Unidadaprendizaje getUnidadAprendizaje() {
        return uA;
    }

    public void setUnidadAprendizaje(Unidadaprendizaje uA) {
        this.uA = uA;
    }

//  Metodos para el buen funcionamiento del bean
    private boolean esIdValido(int id) {
        boolean bandera = false;
        for (Unidadaprendizaje unidad : unidadHelper.getUnidades()) {
            if (unidad.getIdUnidadAprendizaje() == id) {
                bandera = true;
                break;
            }
        }
        return bandera;
    }

    private String sonHorasValidas(int clase, int taller, int laboratorio) {
        String horasError = "";
        if (clase <= 1 || clase >= 6) {
            horasError = "Horas clase";
        } else if (taller <= 0 || taller >= 4) {
            horasError = "Horas taller";
        } else if (laboratorio <= 0 || laboratorio >= 4) {
            horasError = "Horas clase";
        }
        return horasError;
    }

}
