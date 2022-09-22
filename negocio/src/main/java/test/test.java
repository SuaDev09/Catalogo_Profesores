/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import mx.slp.integracion.ServiceFacadeLocator;
import mx.slp.entidad.Unidadaprendizaje;

/**
 *
 * @author ghots
 */
public class test {
    public static void main(String[] args) {
        Unidadaprendizaje uA = new Unidadaprendizaje(0, 20, "Matematica", 10, 2, 3);
        
        ServiceFacadeLocator.getInstanceFacadeUnidad().saveUnidad(uA);
        
        if(uA.getIdUA() != null){
            System.out.println("Si");
        } else{
            System.out.println("No");
        }
    }
}
