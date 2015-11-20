/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.prueba1.modelo.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hernando
 */
@Entity
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByNumeroCta", query = "SELECT c FROM Cuenta c WHERE c.numeroCta = :numeroCta"),
    @NamedQuery(name = "Cuenta.findByTitular", query = "SELECT c FROM Cuenta c WHERE c.titular = :titular"),
    @NamedQuery(name = "Cuenta.findBySaldo", query = "SELECT c FROM Cuenta c WHERE c.saldo = :saldo"),
    @NamedQuery(name = "Cuenta.findByFechaApertura", query = "SELECT c FROM Cuenta c WHERE c.fechaApertura = :fechaApertura"),
    @NamedQuery(name = "Cuenta.findByEstado", query = "SELECT c FROM Cuenta c WHERE c.estado = :estado")})
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numero_cta")
    private String numeroCta;
    @Size(max = 100)
    @Column(name = "titular")
    private String titular;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private Double saldo;
    @Size(max = 45)
    @Column(name = "fecha_apertura")
    private String fechaApertura;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;

    public Cuenta() {
    }

    public Cuenta(String numeroCta) {
        this.numeroCta = numeroCta;
    }

    public String getNumeroCta() {
        return numeroCta;
    }

    public void setNumeroCta(String numeroCta) {
        this.numeroCta = numeroCta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroCta != null ? numeroCta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.numeroCta == null && other.numeroCta != null) || (this.numeroCta != null && !this.numeroCta.equals(other.numeroCta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.prueba1.modelo.pojos.Cuenta[ numeroCta=" + numeroCta + " ]";
    }
    
}
