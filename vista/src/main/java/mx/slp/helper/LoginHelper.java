/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.helper;

import java.io.Serializable;
import mx.slp.entidad.Usuario;
import mx.slp.integracion.ServiceFacadeLocator;

/**
 *
 * @author ghots
 */
public class LoginHelper implements Serializable{
    
    /**
     * Metodo para hacer login llamara a la instancia de usuarioFacade
     * @param nameUsuario
     * @param password
     * @return 
     */
    public Usuario Login(String password, String nameUsuario){
        return ServiceFacadeLocator.getInstanceFacadeUsuario().login(password, nameUsuario);
    }
    
}
