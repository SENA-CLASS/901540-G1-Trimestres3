/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ceetregistro.model.entiies;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hernando
 */
@Embeddable
public class UsuarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Cuenta_Tipo_Documento_tipo_documento")
    private String cuentaTipoDocumentotipodocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Cuenta_numero_Documento")
    private String cuentanumeroDocumento;

    public UsuarioPK() {
    }

    public UsuarioPK(String cuentaTipoDocumentotipodocumento, String cuentanumeroDocumento) {
        this.cuentaTipoDocumentotipodocumento = cuentaTipoDocumentotipodocumento;
        this.cuentanumeroDocumento = cuentanumeroDocumento;
    }

    public String getCuentaTipoDocumentotipodocumento() {
        return cuentaTipoDocumentotipodocumento;
    }

    public void setCuentaTipoDocumentotipodocumento(String cuentaTipoDocumentotipodocumento) {
        this.cuentaTipoDocumentotipodocumento = cuentaTipoDocumentotipodocumento;
    }

    public String getCuentanumeroDocumento() {
        return cuentanumeroDocumento;
    }

    public void setCuentanumeroDocumento(String cuentanumeroDocumento) {
        this.cuentanumeroDocumento = cuentanumeroDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentaTipoDocumentotipodocumento != null ? cuentaTipoDocumentotipodocumento.hashCode() : 0);
        hash += (cuentanumeroDocumento != null ? cuentanumeroDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPK)) {
            return false;
        }
        UsuarioPK other = (UsuarioPK) object;
        if ((this.cuentaTipoDocumentotipodocumento == null && other.cuentaTipoDocumentotipodocumento != null) || (this.cuentaTipoDocumentotipodocumento != null && !this.cuentaTipoDocumentotipodocumento.equals(other.cuentaTipoDocumentotipodocumento))) {
            return false;
        }
        if ((this.cuentanumeroDocumento == null && other.cuentanumeroDocumento != null) || (this.cuentanumeroDocumento != null && !this.cuentanumeroDocumento.equals(other.cuentanumeroDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.ceetregistro.model.entiies.UsuarioPK[ cuentaTipoDocumentotipodocumento=" + cuentaTipoDocumentotipodocumento + ", cuentanumeroDocumento=" + cuentanumeroDocumento + " ]";
    }
    
}
