/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.delegate;

import java.util.List;
import mx.slp.integracion.ServiceLocator;
import mx.slp.entidad.Profesor;
/**
 *
 * @author ghots
 */
public class DelegateProfesor {

    public void saveProfesor(Profesor profesor){
        ServiceLocator.getInstacenProfesorDAO().save(profesor);
    }
    
    public void editProfesor(Profesor profesor){
        ServiceLocator.getInstacenProfesorDAO().update(profesor);
    }
    
    public void deleteProfesor(int id){
        ServiceLocator.getInstacenProfesorDAO().delete(id);
    }
    
    public List<Profesor> getProfesores(){
        return ServiceLocator.getInstacenProfesorDAO().findAll();
    } 
    
}
