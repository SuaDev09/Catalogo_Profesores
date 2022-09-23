/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.facade;

import java.util.List;
import mx.slp.entidad.Usuario;
import mx.slp.integracion.ServiceLocator;

/**
 *
 * @author ghots
 */
public class FacadeUsuario {
    /**
     * Metodo para verificar si el usuario esta registrado en la bd
     * @param password 
     * @param correo
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
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveUsario(Usuario usuario){
        ServiceLocator.getInstanceUsuarioDAO().save(usuario);
    }
}
