/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import mx.slp.entidad.Profesor;
import mx.slp.entidad.Unidadaprendizaje;
import mx.slp.entidad.Usuario;
import mx.slp.integracion.ServiceFacadeLocator;

/**
 *
 * @author ghots
 */
public class test {

    public static void main(String[] args) {
        System.out.println("Iniciando pruebas");
        List<Unidadaprendizaje> listUnidades = ServiceFacadeLocator.getInstanceFacadeUnidad().obtenerUnidades();
        for (Unidadaprendizaje unidad : listUnidades) {
            System.out.println("\nLista de unidades:" + unidad.getProfesorimparteunidadList().toString());
        }
        System.out.println("Finalizando pruebas");

        Usuario usuario = ServiceFacadeLocator.getInstanceFacadeUsuario().login("admin123", "admin");
        System.out.println(usuario.toString());
        if (usuario.getIdUsuario() != null) {
            System.out.println("Login exitoso con el nameUsuario: " + usuario.getNameUsuario());
        }
        
        System.out.println("PRUEBAS PROFESORRRR---------");
        List<Profesor> listaProfesores = ServiceFacadeLocator.getInstanceFacadeProfesor().obtenerProfesores();
        for(Profesor pr : listaProfesores){
            System.out.println(pr.getIdP() + "+" + pr.getIdProfesor()+ "+" + pr.getNombre() + "+");
        }
    }
}
