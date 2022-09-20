/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.integracion;

import mx.slp.DAO.*;

/**
 *
 * @author ghots
 */

public class ServiceLocator {
    private static ProfesorDAO profesorDAO;
    private static UnidadAprendizajeDAO unidadAprendizajeDAO;
    
    public static ProfesorDAO getInstacenProfesorDAO(){
        if(profesorDAO == null){
            profesorDAO = new ProfesorDAO();
            return profesorDAO;
        } else{
            return profesorDAO;
        }
    }
    
    public static UnidadAprendizajeDAO getInstacenUnidadAprendizajeDAO(){
        if(unidadAprendizajeDAO == null){
            unidadAprendizajeDAO = new UnidadAprendizajeDAO();
            return unidadAprendizajeDAO;
        } else{
            return unidadAprendizajeDAO;
        }
    }
}
