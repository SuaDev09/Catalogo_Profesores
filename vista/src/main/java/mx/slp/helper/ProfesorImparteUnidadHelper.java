/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.helper;

import java.io.Serializable;
import java.util.List;
import mx.slp.entidad.Profesorimparteunidad;
import mx.slp.entidad.Unidadaprendizaje;
import mx.slp.integracion.ServiceFacadeLocator;

/**
 *
 * @author ghots
 */
public class ProfesorImparteUnidadHelper implements Serializable{
    public void saveAsignacion(Profesorimparteunidad pIU){
        ServiceFacadeLocator.getInstanceFacadeAsignacion().guardarAsignacion(pIU);
    }
    
    public List<Profesorimparteunidad> getAsignaciones(){
        return ServiceFacadeLocator.getInstanceFacadeAsignacion().obtenerAsignaciones();
    }
    
    public void eliminarAsignacion(Profesorimparteunidad pIU){
        ServiceFacadeLocator.getInstanceFacadeAsignacion().eliminarAsignacion(pIU);
    }
}
