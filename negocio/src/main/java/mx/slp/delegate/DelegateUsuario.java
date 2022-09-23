/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.delegate;

import java.util.List;
import mx.slp.entidad.Usuario;
import mx.slp.integracion.ServiceLocator;

/**
 *
 * @author ghots
 */
public class DelegateUsuario {
    /**
     * Metodo para verificar si el usuario esta registrado en la bd
     * @param password 
     * @param nameUsuario
     * @return un tipo usuario si no encuntra el usuario sera null
     */
    public Usuario login(String password, String nameUsuario){
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = ServiceLocator.getInstanceUsuarioDAO().findAll();
        
        for(Usuario us:usuarios){
            if(us.getPassword().equalsIgnoreCase(password) && us.getNameUsuario().equalsIgnoreCase(nameUsuario)){
                usuario = us;
            }
        }
        return usuario;
    }
}
