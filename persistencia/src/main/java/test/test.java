/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author ghots
 */
import java.util.ArrayList;
import java.util.List;
import mx.slp.DAO.UnidadAprendizajeDAO;
import mx.slp.entidad.UnidadAprendizaje;

/**
 *
 * @author ghots
 */
public class test {
    public static void main(String[] args) {
        
        List<UnidadAprendizaje> listaUnidades = new ArrayList();
        UnidadAprendizajeDAO unidadDAO = new UnidadAprendizajeDAO();
        listaUnidades = unidadDAO.findAll();
        
        for(UnidadAprendizaje uA: listaUnidades){
            System.out.println("Unidad id " + uA.getNombre());
        }
    }
}
