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
import mx.slp.helper.ProfesorHelper;
import org.primefaces.context.PrimeFacesContext;
import org.primefaces.context.RequestContext;
/**
 *
 * @author ghots
 */
    @ManagedBean(name = "profesorBeanUI")
    @SessionScoped 
public class ProfesorBeanUI implements Serializable{
        
        
    private ProfesorHelper profesorHelper;
    private Profesor profesor;

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
    
    
    public void agregar() throws IOException{
        
        String mensaje = rfcValido(profesor.getRfc());
        
        
        //retorna un null ya que no se a puesto una uniadad de aprendizaje
        //if(profesor.getProfesorimparteunidadList().size() < 1){
            //FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error unidad de aprendizaje", "No se tiene una unidad de aprendizaje asignada");
          //  RequestContext.getCurrentInstance().showMessageInDialog(message);
            
        //}
        if (!mensaje.equals("")){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error RFC", "El rfc " + mensaje);
            RequestContext.getCurrentInstance().showMessageInDialog(message);
        } else if (validarID(profesor.getIdProfesor()) == true){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error ID profesor", "El ID del profesor ya a sido ingresado");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
        } else {
            
            profesor.setIdP(0);
            profesorHelper.saveProfesor(profesor);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Profesor", "El profesor a sido registrado de manera exitosa.");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
            profesor = new Profesor();
            
        }
        
        
    }
    
    
    public void eliminar(){
        profesorHelper.deleteProfesor(profesor);
    }

    public List<Profesor> obtenerProfesores(){
        return profesorHelper.getProfesores();
    }
    
    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    public boolean validarID(int id){
        boolean bandera = false;
        for(Profesor profesor: profesorHelper.getProfesores()){
            if(profesor.getIdProfesor() == id){
                bandera = true;
                break;
            }
        }
        
        return bandera;
    }
    
    public String rfcValido(String rfc){
        boolean bandera = false;
        String mensaje = "";
        
        if(profesor.getRfc().length() > 13){
            mensaje = "es mayor de 13";
            bandera = true;
        }else if (profesor.getRfc().length() < 13 ){
            mensaje = "es menor que 13";
            bandera = true;
        }
        
        return mensaje;
    }
    
    
        
    

    
        
        
}
