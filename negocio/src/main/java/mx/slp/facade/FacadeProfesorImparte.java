/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.facade;

import java.util.List;
import mx.slp.delegate.DelegateProfesorImparte;
import mx.slp.entidad.Profesorimparteunidad;

/**
 *
 * @author ghots
 */
public class FacadeProfesorImparte {
    private final DelegateProfesorImparte delegateAsignacion;
    
    public FacadeProfesorImparte(){
        this.delegateAsignacion = new DelegateProfesorImparte();
    }
    
    public void guardarAsignacion(Profesorimparteunidad pIU){
        delegateAsignacion.saveAsignacion(pIU);
    }
    
    public List<Profesorimparteunidad> obtenerAsignaciones(){
        return delegateAsignacion.getAsignaciones();
    }
    
    public void eliminarAsignacion(Profesorimparteunidad pIU){
        delegateAsignacion.deleteAsignacion(pIU);
    }
    
    
}
