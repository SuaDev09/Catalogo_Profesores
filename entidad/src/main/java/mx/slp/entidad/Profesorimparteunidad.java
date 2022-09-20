/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.slp.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ghots
 */
@Entity
@Table(name = "profesorimparteunidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesorimparteunidad.findAll", query = "SELECT p FROM Profesorimparteunidad p")
    , @NamedQuery(name = "Profesorimparteunidad.findByIdProfesorImparteUnidad", query = "SELECT p FROM Profesorimparteunidad p WHERE p.idProfesorImparteUnidad = :idProfesorImparteUnidad")})
public class Profesorimparteunidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProfesorImparteUnidad")
    private Integer idProfesorImparteUnidad;
    @JoinColumn(name = "idProfesor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Profesor idProfesor;
    @JoinColumn(name = "idUnidadAprendizaje", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unidadaprendizaje idUnidadAprendizaje;

    public Profesorimparteunidad() {
    }

    public Profesorimparteunidad(Integer idProfesorImparteUnidad) {
        this.idProfesorImparteUnidad = idProfesorImparteUnidad;
    }

    public Integer getIdProfesorImparteUnidad() {
        return idProfesorImparteUnidad;
    }

    public void setIdProfesorImparteUnidad(Integer idProfesorImparteUnidad) {
        this.idProfesorImparteUnidad = idProfesorImparteUnidad;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Unidadaprendizaje getIdUnidadAprendizaje() {
        return idUnidadAprendizaje;
    }

    public void setIdUnidadAprendizaje(Unidadaprendizaje idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesorImparteUnidad != null ? idProfesorImparteUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesorimparteunidad)) {
            return false;
        }
        Profesorimparteunidad other = (Profesorimparteunidad) object;
        if ((this.idProfesorImparteUnidad == null && other.idProfesorImparteUnidad != null) || (this.idProfesorImparteUnidad != null && !this.idProfesorImparteUnidad.equals(other.idProfesorImparteUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.slp.entidad.Profesorimparteunidad[ idProfesorImparteUnidad=" + idProfesorImparteUnidad + " ]";
    }
    
}
