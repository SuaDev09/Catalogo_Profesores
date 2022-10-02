/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.delegate;

import java.util.List;
import mx.slp.entidad.Profesorimparteunidad;
import mx.slp.integracion.ServiceLocator;

/**
 *
 * @author ghots
 */
public class DelegateProfesorImparte {
    public void saveAsignacion(Profesorimparteunidad pIU){
        ServiceLocator.getInstaceProfesorImparteDAO().save(pIU);
    }
    
    public List<Profesorimparteunidad> getAsignaciones(){
        return ServiceLocator.getInstaceProfesorImparteDAO().findAll();
    }
    
    public void deleteAsignacion(Profesorimparteunidad pIU){
        ServiceLocator.getInstaceProfesorImparteDAO().delete(pIU);
    }
}
