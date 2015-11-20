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
public class CuentaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Tipo_Documento_tipo_documento")
    private String tipoDocumentotipodocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numero_Documento")
    private String numeroDocumento;

    public CuentaPK() {
    }

    public CuentaPK(String tipoDocumentotipodocumento, String numeroDocumento) {
        this.tipoDocumentotipodocumento = tipoDocumentotipodocumento;
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumentotipodocumento() {
        return tipoDocumentotipodocumento;
    }

    public void setTipoDocumentotipodocumento(String tipoDocumentotipodocumento) {
        this.tipoDocumentotipodocumento = tipoDocumentotipodocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoDocumentotipodocumento != null ? tipoDocumentotipodocumento.hashCode() : 0);
        hash += (numeroDocumento != null ? numeroDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaPK)) {
            return false;
        }
        CuentaPK other = (CuentaPK) object;
        if ((this.tipoDocumentotipodocumento == null && other.tipoDocumentotipodocumento != null) || (this.tipoDocumentotipodocumento != null && !this.tipoDocumentotipodocumento.equals(other.tipoDocumentotipodocumento))) {
            return false;
        }
        if ((this.numeroDocumento == null && other.numeroDocumento != null) || (this.numeroDocumento != null && !this.numeroDocumento.equals(other.numeroDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.ceetregistro.model.entiies.CuentaPK[ tipoDocumentotipodocumento=" + tipoDocumentotipodocumento + ", numeroDocumento=" + numeroDocumento + " ]";
    }
    
}
