/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.facade;

import java.util.List;
import mx.slp.entidad.Usuario;
import mx.slp.integracion.ServiceLocator;
import mx.slp.delegate.DelegateUsuario;

/**
 *
 * @author ghots
 */
public class FacadeUsuario {
    private final DelegateUsuario delegateUsuario;
    
    public FacadeUsuario() {
        this.delegateUsuario = new DelegateUsuario();
    }
    
    /**
     * Metodo para verificar si el usuario esta registrado en la bd
     * @param password 
     * @param nameUsuario
     * @return Regresa usuario si el correo y contraseñ son correctos
     */
    public Usuario login(String password, String nameUsuario){
        return delegateUsuario.login(password, nameUsuario);
    }
}
