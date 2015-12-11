/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejemplo.modelo.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hernando
 */
@Entity
@Table(name = "registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r"),
    @NamedQuery(name = "Registro.findByIdRegistro", query = "SELECT r FROM Registro r WHERE r.idRegistro = :idRegistro"),
    @NamedQuery(name = "Registro.findByFechaIngreso", query = "SELECT r FROM Registro r WHERE r.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Registro.findByFehcaSalida", query = "SELECT r FROM Registro r WHERE r.fehcaSalida = :fehcaSalida"),
    @NamedQuery(name = "Registro.findByCargoIngreso", query = "SELECT r FROM Registro r WHERE r.cargoIngreso = :cargoIngreso"),
    @NamedQuery(name = "Registro.findByDescripcionIngreso", query = "SELECT r FROM Registro r WHERE r.descripcionIngreso = :descripcionIngreso")})
public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRegistro")
    private Integer idRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "fehca_salida")
    @Temporal(TemporalType.DATE)
    private Date fehcaSalida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cargo_ingreso")
    private String cargoIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion_ingreso")
    private String descripcionIngreso;
    @ManyToMany(mappedBy = "registroCollection")
    private Collection<Propietario> propietarioCollection;
    @JoinColumns({
        @JoinColumn(name = "Cuenta_Tipo_Documento_tipo_documento", referencedColumnName = "Tipo_Documento_tipo_documento"),
        @JoinColumn(name = "Cuenta_numero_Documento", referencedColumnName = "numero_Documento")})
    @ManyToOne(optional = false)
    private Cuenta cuenta;

    public Registro() {
    }

    public Registro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Registro(Integer idRegistro, Date fechaIngreso, String cargoIngreso, String descripcionIngreso) {
        this.idRegistro = idRegistro;
        this.fechaIngreso = fechaIngreso;
        this.cargoIngreso = cargoIngreso;
        this.descripcionIngreso = descripcionIngreso;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFehcaSalida() {
        return fehcaSalida;
    }

    public void setFehcaSalida(Date fehcaSalida) {
        this.fehcaSalida = fehcaSalida;
    }

    public String getCargoIngreso() {
        return cargoIngreso;
    }

    public void setCargoIngreso(String cargoIngreso) {
        this.cargoIngreso = cargoIngreso;
    }

    public String getDescripcionIngreso() {
        return descripcionIngreso;
    }

    public void setDescripcionIngreso(String descripcionIngreso) {
        this.descripcionIngreso = descripcionIngreso;
    }

    @XmlTransient
    public Collection<Propietario> getPropietarioCollection() {
        return propietarioCollection;
    }

    public void setPropietarioCollection(Collection<Propietario> propietarioCollection) {
        this.propietarioCollection = propietarioCollection;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistro != null ? idRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.idRegistro == null && other.idRegistro != null) || (this.idRegistro != null && !this.idRegistro.equals(other.idRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.ejemplo.modelo.entidades.Registro[ idRegistro=" + idRegistro + " ]";
    }
    
}
