/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.integracion;

import mx.slp.DAO.ProfesorDAO;
import mx.slp.DAO.ProfesorimparteunidadDAO;
import mx.slp.DAO.UnidadaprendizajeDAO;
import mx.slp.DAO.UsuarioDAO;

/**
 *
 * @author ghots
 */

public class ServiceLocator {
    private static ProfesorDAO profesorDAO;
    private static UnidadaprendizajeDAO unidadAprendizajeDAO;
    private static ProfesorimparteunidadDAO profesorImparteDAO;
    private static UsuarioDAO usuarioDAO;
    
    public static ProfesorDAO getInstaceProfesorDAO(){
        if(profesorDAO == null){
            profesorDAO = new ProfesorDAO();
            return profesorDAO;
        } else{
            return profesorDAO;
        }
    }
    
    public static UnidadaprendizajeDAO getInstaceUnidadaprendizajeDAO(){
        if(unidadAprendizajeDAO == null){
            unidadAprendizajeDAO = new UnidadaprendizajeDAO();
            return unidadAprendizajeDAO;
        } else{
            return unidadAprendizajeDAO;
        }
    }
    
    public static ProfesorimparteunidadDAO getInstaceProfesorImparteDAO(){
        if(profesorImparteDAO == null){
            profesorImparteDAO = new ProfesorimparteunidadDAO();
            return profesorImparteDAO;
        } else{
            return profesorImparteDAO;
        }
    }
    
    public static UsuarioDAO getInstanceUsuarioDAO(){
        if(usuarioDAO == null){
            usuarioDAO = new UsuarioDAO();
            return usuarioDAO;
        } else{
            return usuarioDAO;
        }
    }
}
