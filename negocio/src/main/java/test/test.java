/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import mx.slp.entidad.Unidadaprendizaje;
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
            System.out.println("\nLista de unidades:"+unidad.getProfesorimparteunidadList().toString());
        }
        System.out.println("Finalizando pruebas");
    }
}
