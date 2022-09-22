/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.DAO;

import java.util.List;
import mx.slp.entidad.UnidadAprendizaje;
import mx.slp.persistencia.AbstractDAO;

/**
 *
 * @author ghots
 */
public class UnidadAprendizajeDAO extends AbstractDAO<Integer, UnidadAprendizaje>{

    @Override
    public void save(UnidadAprendizaje obj) {
        super.save(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<UnidadAprendizaje> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
}
