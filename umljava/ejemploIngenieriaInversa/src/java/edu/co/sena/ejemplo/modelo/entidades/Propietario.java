/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejemplo.modelo.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hernando
 */
@Entity
@Table(name = "propietario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propietario.findAll", query = "SELECT p FROM Propietario p"),
    @NamedQuery(name = "Propietario.findByEquipoSerial", query = "SELECT p FROM Propietario p WHERE p.propietarioPK.equipoSerial = :equipoSerial"),
    @NamedQuery(name = "Propietario.findByCuentaTipoDocumentotipodocumento", query = "SELECT p FROM Propietario p WHERE p.propietarioPK.cuentaTipoDocumentotipodocumento = :cuentaTipoDocumentotipodocumento"),
    @NamedQuery(name = "Propietario.findByCuentanumeroDocumento", query = "SELECT p FROM Propietario p WHERE p.propietarioPK.cuentanumeroDocumento = :cuentanumeroDocumento")})
public class Propietario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PropietarioPK propietarioPK;
    @JoinTable(name = "registro_propietario", joinColumns = {
        @JoinColumn(name = "Propietario_equipo_serial", referencedColumnName = "equipo_serial"),
        @JoinColumn(name = "Propietario_Cuenta_Tipo_Documento_tipo_documento", referencedColumnName = "Cuenta_Tipo_Documento_tipo_documento"),
        @JoinColumn(name = "Propietario_Cuenta_numero_Documento", referencedColumnName = "Cuenta_numero_Documento")}, inverseJoinColumns = {
        @JoinColumn(name = "Registro_idRegistro", referencedColumnName = "idRegistro")})
    @ManyToMany
    private Collection<Registro> registroCollection;
    @JoinColumns({
        @JoinColumn(name = "Cuenta_Tipo_Documento_tipo_documento", referencedColumnName = "Tipo_Documento_tipo_documento", insertable = false, updatable = false),
        @JoinColumn(name = "Cuenta_numero_Documento", referencedColumnName = "numero_Documento", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Cuenta cuenta;
    @JoinColumn(name = "equipo_serial", referencedColumnName = "serial", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo;

    public Propietario() {
    }

    public Propietario(PropietarioPK propietarioPK) {
        this.propietarioPK = propietarioPK;
    }

    public Propietario(String equipoSerial, String cuentaTipoDocumentotipodocumento, String cuentanumeroDocumento) {
        this.propietarioPK = new PropietarioPK(equipoSerial, cuentaTipoDocumentotipodocumento, cuentanumeroDocumento);
    }

    public PropietarioPK getPropietarioPK() {
        return propietarioPK;
    }

    public void setPropietarioPK(PropietarioPK propietarioPK) {
        this.propietarioPK = propietarioPK;
    }

    @XmlTransient
    public Collection<Registro> getRegistroCollection() {
        return registroCollection;
    }

    public void setRegistroCollection(Collection<Registro> registroCollection) {
        this.registroCollection = registroCollection;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propietarioPK != null ? propietarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propietario)) {
            return false;
        }
        Propietario other = (Propietario) object;
        if ((this.propietarioPK == null && other.propietarioPK != null) || (this.propietarioPK != null && !this.propietarioPK.equals(other.propietarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.ejemplo.modelo.entidades.Propietario[ propietarioPK=" + propietarioPK + " ]";
    }
    
}
