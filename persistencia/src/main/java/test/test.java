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
import mx.slp.DAO.ProfesorDAO;
import mx.slp.DAO.UnidadaprendizajeDAO;
import mx.slp.entidad.Profesor;
import mx.slp.entidad.Unidadaprendizaje;

/**
 *
 * @author ghots
 */
public class test {

    public static void main(String[] args) {

        List<Unidadaprendizaje> listaUnidades = new ArrayList();
        UnidadaprendizajeDAO unidadDAO = new UnidadaprendizajeDAO();
        listaUnidades = unidadDAO.findAll();

        for (Unidadaprendizaje uA : listaUnidades) {
            System.out.println("Unidad id " + uA.getNombre());
        }

        System.out.println("PRUEBAS DE PROFESORe ------------------------");
        ProfesorDAO profesor = new ProfesorDAO();
        List<Profesor> listaProfesores = profesor.findAll();
        for(Profesor pr : listaProfesores){
            System.out.println(pr.getIdP() + "+" + pr.getIdProfesor()+ "+" + pr.getNombre() + "+");
        }
    }
}
