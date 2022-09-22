/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.DAO;

import java.util.List;
import mx.slp.entidad.Unidadaprendizaje;
import mx.slp.persistencia.AbstractDAO;

/**
 *
 * @author ghots
 */
public class UnidadaprendizajeDAO extends AbstractDAO<Integer, Unidadaprendizaje>{

    @Override
    public void save(Unidadaprendizaje obj) {
        super.save(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
}

