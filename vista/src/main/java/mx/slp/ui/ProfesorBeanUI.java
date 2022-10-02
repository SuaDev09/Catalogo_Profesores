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
    private List<Unidadaprendizaje> seleccionarUnidades;
    private List<Unidadaprendizaje> unidades;
    private List<Profesorimparteunidad> impartidas;
    private Unidadaprendizaje uA1 = new Unidadaprendizaje(26, 11717, "Fisica Diferencial", 19, 20, 10);
    private Unidadaprendizaje uA2 = new Unidadaprendizaje(17, 321, "ads", 2, 1, 1);
    List<Unidadaprendizaje> uAS;

    public ProfesorBeanUI() {
        uAS = new ArrayList();
        profesorHelper = new ProfesorHelper();
        unidadHelper = new UnidadAprendizajeHelper();
    }

//    Metodo postconstructor
//    Todo lo que este dentro de este metodo sera 
//    lo primero que carque la pagina      
    @PostConstruct
    public void init() {
        profesor = new Profesor();
        unidades = unidadHelper.getUnidades();
    }

    public void agregar() throws IOException {
        uAS.add(uA1);
        uAS.add(uA2);
        for (Unidadaprendizaje seleccionarUnidade : seleccionarUnidades) {
            System.out.println("HOla mundo ->>>> " + seleccionarUnidade.toString() + "<<<--- " + seleccionarUnidade.toString() + " === " + seleccionarUnidade);
        }
        String mensaje = rfcValido(profesor.getRfc());
        if (!unidadHelper.getUnidades().isEmpty()) {
            if (!mensaje.equals("")) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error RFC", "El rfc " + mensaje);
                PrimeFaces.current().dialog().showMessageDynamic(message);
            } else {
                if (!seleccionarUnidades.isEmpty()) {
                    if (profesor.getIdP() == null) {
                        if (validarID(profesor.getIdProfesor()) == true) {
                            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error ID profesor", "El ID del profesor ya a sido ingresado");
                            PrimeFaces.current().dialog().showMessageDynamic(message);
                        } else {
                            profesor.setIdP(0);
                            profesorHelper.saveProfesor(profesor, seleccionarUnidades);
                            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Profesor", "El profesor a sido registrado de manera exitosa.");
                            PrimeFaces.current().dialog().showMessageDynamic(message);
                            profesor = new Profesor();
                        }

                    } else {
                        if (validarID(profesor.getIdProfesor())) {
                            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error ID profesor", "El ID del profesor ya a sido ingresado");
                            PrimeFaces.current().dialog().showMessageDynamic(message);
                        } else {
                            profesorHelper.saveProfesor(profesor, uAS);
                            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Profesor", "El profesor a sido actualizado de manera correcta.");
                            PrimeFaces.current().dialog().showMessageDynamic(message);
                            profesor = new Profesor();
                        }
                    }

                } else {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No has asignado unidades de aprendizaje al profesor.");
                    PrimeFaces.current().dialog().showMessageDynamic(message);
                }

            }
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No puedes ingresar profesores debido a que no hay unidades de aprendizaje registradas.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        }

    }

    public List<Unidadaprendizaje> regresarUnidadesSeleccionadas(String seleccionados) {
        List<Unidadaprendizaje> convertidos = new ArrayList<Unidadaprendizaje>();
        boolean bandera = false;
        if (seleccionados.contains(" ") || seleccionados.matches("[A-Z]")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error Unidades de aprendizaje", "Haz ingresado mal la informacion de las unidades");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        } else {
            String[] separados = seleccionados.split(",");
            for (String separado : separados) {
                for (Unidadaprendizaje unidad : unidades) {
                    if (unidad.getIdUnidadAprendizaje() == Integer.parseInt(separado)) {
                        System.out.println(separado);
                        convertidos.add(unidad);
                        bandera = true;
                    }
                }
                //convertidos.add(new Unidadaprendizaje(seleccionado.getIdUA(), seleccionado.getIdUnidadAprendizaje(), seleccionado.getNombre(), seleccionado.getHorasClase(), seleccionado.getHorasTaller(), seleccionado.getHorasLaboratorio()));
            }
        }
        return convertidos;
    }

    public void eliminar(Profesor pAux) {
        profesorHelper.deleteProfesor(pAux);
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

    public List<Unidadaprendizaje> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidadaprendizaje> unidades) {
        this.unidades = unidades;
    }

    public List<Unidadaprendizaje> getSeleccionarUnidades() {
        return seleccionarUnidades;
    }

    public void setSeleccionarUnidades(List<Unidadaprendizaje> seleccionarUnidades) {
        this.seleccionarUnidades = seleccionarUnidades;
    }    

    public List<Profesorimparteunidad> getImpartidas() {
        return impartidas;
    }

    public void setImpartidas(List<Profesorimparteunidad> impartidas) {
        this.impartidas = impartidas;
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

    public boolean validarPrimary(int primary) {
        boolean bandera = false;
        for (Profesor profesor : profesorHelper.getProfesores()) {
            if (profesor.getIdP() == primary) {
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
