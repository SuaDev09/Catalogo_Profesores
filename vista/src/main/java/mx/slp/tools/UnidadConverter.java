/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.tools;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import mx.slp.entidad.Unidadaprendizaje;
import mx.slp.helper.UnidadAprendizajeHelper;

/**
 *
 * @author ghots
 */
@FacesConverter(value = "unidadConverter")
public class UnidadConverter implements Converter {

    UnidadAprendizajeHelper unidadHelper = new UnidadAprendizajeHelper();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent comp, String value) {
        Unidadaprendizaje e = unidadHelper.getUnidades().get(Integer.parseInt(value));
        return e;
    }
    
    public String getAsString(FacesContext fc, UIComponent comp, Object value) {
        return ((Unidadaprendizaje) value).getIdUA().toString();
    }
    
}
