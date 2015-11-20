/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendaenlinea.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author hernando
 */
@Entity
@Table(name = "cuenta")
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")})
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CuentaPK cuentaPK;
    @Basic(optional = false)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Column(name = "SEGUNRO_NOMBRE")
    private String segunroNombre;
    @Basic(optional = false)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta", fetch = FetchType.EAGER)
    private List<Factura> facturaList;
    @JoinColumn(name = "TIPO_DOCUMENTO_TIPO_DOCUMENTO", referencedColumnName = "TIPO_DOCUMENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoDocumento tipoDocumento;
    @JoinColumn(name = "USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cuenta", fetch = FetchType.EAGER)
    private DomicilioCuentas domicilioCuentas;

    public Cuenta() {
    }

    public Cuenta(CuentaPK cuentaPK) {
        this.cuentaPK = cuentaPK;
    }

    public Cuenta(CuentaPK cuentaPK, String primerNombre, String primerApellido) {
        this.cuentaPK = cuentaPK;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
    }

    public Cuenta(String tipoDocumentoTipoDocumento, String numeroDocumento) {
        this.cuentaPK = new CuentaPK(tipoDocumentoTipoDocumento, numeroDocumento);
    }

    public CuentaPK getCuentaPK() {
        return cuentaPK;
    }

    public void setCuentaPK(CuentaPK cuentaPK) {
        this.cuentaPK = cuentaPK;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegunroNombre() {
        return segunroNombre;
    }

    public void setSegunroNombre(String segunroNombre) {
        this.segunroNombre = segunroNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public DomicilioCuentas getDomicilioCuentas() {
        return domicilioCuentas;
    }

    public void setDomicilioCuentas(DomicilioCuentas domicilioCuentas) {
        this.domicilioCuentas = domicilioCuentas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentaPK != null ? cuentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.cuentaPK == null && other.cuentaPK != null) || (this.cuentaPK != null && !this.cuentaPK.equals(other.cuentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tiendaenlinea.modelo.entidades.Cuenta[ cuentaPK=" + cuentaPK + " ]";
    }
    
}
