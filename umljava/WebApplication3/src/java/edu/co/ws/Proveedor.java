/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.ws;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hernando
 */
@Entity
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByTipoDocumentoTipoDocumento", query = "SELECT p FROM Proveedor p WHERE p.proveedorPK.tipoDocumentoTipoDocumento = :tipoDocumentoTipoDocumento"),
    @NamedQuery(name = "Proveedor.findByNumDocumento", query = "SELECT p FROM Proveedor p WHERE p.proveedorPK.numDocumento = :numDocumento"),
    @NamedQuery(name = "Proveedor.findByNombreProveedor", query = "SELECT p FROM Proveedor p WHERE p.nombreProveedor = :nombreProveedor"),
    @NamedQuery(name = "Proveedor.findByCorreo", query = "SELECT p FROM Proveedor p WHERE p.correo = :correo")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProveedorPK proveedorPK;
    @Size(max = 80)
    @Column(name = "NOMBRE_PROVEEDOR")
    private String nombreProveedor;
    @Size(max = 45)
    @Column(name = "CORREO")
    private String correo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "proveedor")
    private DomicilioProvee domicilioProvee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
    private Collection<InventarioCompras> inventarioComprasCollection;
    @JoinColumn(name = "TIPO_DOCUMENTO_TIPO_DOCUMENTO", referencedColumnName = "TIPO_DOCUMENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumento;

    public Proveedor() {
    }

    public Proveedor(ProveedorPK proveedorPK) {
        this.proveedorPK = proveedorPK;
    }

    public Proveedor(String tipoDocumentoTipoDocumento, String numDocumento) {
        this.proveedorPK = new ProveedorPK(tipoDocumentoTipoDocumento, numDocumento);
    }

    public ProveedorPK getProveedorPK() {
        return proveedorPK;
    }

    public void setProveedorPK(ProveedorPK proveedorPK) {
        this.proveedorPK = proveedorPK;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public DomicilioProvee getDomicilioProvee() {
        return domicilioProvee;
    }

    public void setDomicilioProvee(DomicilioProvee domicilioProvee) {
        this.domicilioProvee = domicilioProvee;
    }

    @XmlTransient
    public Collection<InventarioCompras> getInventarioComprasCollection() {
        return inventarioComprasCollection;
    }

    public void setInventarioComprasCollection(Collection<InventarioCompras> inventarioComprasCollection) {
        this.inventarioComprasCollection = inventarioComprasCollection;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proveedorPK != null ? proveedorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.proveedorPK == null && other.proveedorPK != null) || (this.proveedorPK != null && !this.proveedorPK.equals(other.proveedorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.ws.Proveedor[ proveedorPK=" + proveedorPK + " ]";
    }
    
}
