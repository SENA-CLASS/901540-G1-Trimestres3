/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendaenlinea.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author hernando
 */
@Entity
@Table(name = "factura")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_FACTURA")
    private Integer idFactura;
    @Basic(optional = false)
    @Column(name = "FECHA_FACTURA")
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;
    @Column(name = "FORMA_PAGO")
    private String formaPago;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "factura", fetch = FetchType.EAGER)
    private Pago pago;
    @JoinColumns({
        @JoinColumn(name = "CUENTA_TIPO_DOCUMENTO_TIPO_DOCUMENTO", referencedColumnName = "TIPO_DOCUMENTO_TIPO_DOCUMENTO"),
        @JoinColumn(name = "CUENTA_NUMERO_DOCUMENTO", referencedColumnName = "NUMERO_DOCUMENTO")})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cuenta cuenta;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "factura", fetch = FetchType.EAGER)
    private Pedido pedido;

    public Factura() {
    }

    public Factura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Factura(Integer idFactura, Date fechaFactura, String estado) {
        this.idFactura = idFactura;
        this.fechaFactura = fechaFactura;
        this.estado = estado;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tiendaenlinea.modelo.entidades.Factura[ idFactura=" + idFactura + " ]";
    }
    
}
