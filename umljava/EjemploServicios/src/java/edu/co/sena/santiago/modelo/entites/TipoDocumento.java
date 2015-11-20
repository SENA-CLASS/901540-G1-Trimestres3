/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.santiago.modelo.entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hernando
 */
@Entity
@Table(name = "tipo_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findByTipoDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "TipoDocumento.findByDescripcion", query = "SELECT t FROM TipoDocumento t WHERE t.descripcion = :descripcion")})
public class TipoDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento")
    private Collection<Cuenta> cuentaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento")
    private Collection<Proveedor> proveedorCollection;

    public TipoDocumento() {
    }

    public TipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public TipoDocumento(String tipoDocumento, String descripcion) {
        this.tipoDocumento = tipoDocumento;
        this.descripcion = descripcion;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }

    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
    }

    @XmlTransient
    public Collection<Proveedor> getProveedorCollection() {
        return proveedorCollection;
    }

    public void setProveedorCollection(Collection<Proveedor> proveedorCollection) {
        this.proveedorCollection = proveedorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoDocumento != null ? tipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.tipoDocumento == null && other.tipoDocumento != null) || (this.tipoDocumento != null && !this.tipoDocumento.equals(other.tipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.santiago.modelo.entites.TipoDocumento[ tipoDocumento=" + tipoDocumento + " ]";
    }
    
}
