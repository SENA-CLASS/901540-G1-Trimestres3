/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejemplo.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hernando
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByCuentaTipoDocumentotipodocumento", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.cuentaTipoDocumentotipodocumento = :cuentaTipoDocumentotipodocumento"),
    @NamedQuery(name = "Usuario.findByCuentanumeroDocumento", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.cuentanumeroDocumento = :cuentanumeroDocumento"),
    @NamedQuery(name = "Usuario.findByPass", query = "SELECT u FROM Usuario u WHERE u.pass = :pass"),
    @NamedQuery(name = "Usuario.findByRol", query = "SELECT u FROM Usuario u WHERE u.rol = :rol")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioPK usuarioPK;
    @Size(max = 256)
    @Column(name = "pass")
    private String pass;
    @Size(max = 45)
    @Column(name = "rol")
    private String rol;
    @JoinColumns({
        @JoinColumn(name = "Cuenta_Tipo_Documento_tipo_documento", referencedColumnName = "Tipo_Documento_tipo_documento", insertable = false, updatable = false),
        @JoinColumn(name = "Cuenta_numero_Documento", referencedColumnName = "numero_Documento", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Cuenta cuenta;

    public Usuario() {
    }

    public Usuario(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public Usuario(String cuentaTipoDocumentotipodocumento, String cuentanumeroDocumento) {
        this.usuarioPK = new UsuarioPK(cuentaTipoDocumentotipodocumento, cuentanumeroDocumento);
    }

    public UsuarioPK getUsuarioPK() {
        return usuarioPK;
    }

    public void setUsuarioPK(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
        hash += (usuarioPK != null ? usuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioPK == null && other.usuarioPK != null) || (this.usuarioPK != null && !this.usuarioPK.equals(other.usuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.ejemplo.modelo.entidades.Usuario[ usuarioPK=" + usuarioPK + " ]";
    }
    
}
