/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.santiago.modelo.entites;

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
    @Size(min = 1, max = 40)
    @Column(name = "TIPO_DOCUMENTO_TIPO_DOCUMENTO")
    private String tipoDocumentoTipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;

    public CuentaPK() {
    }

    public CuentaPK(String tipoDocumentoTipoDocumento, String numeroDocumento) {
        this.tipoDocumentoTipoDocumento = tipoDocumentoTipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumentoTipoDocumento() {
        return tipoDocumentoTipoDocumento;
    }

    public void setTipoDocumentoTipoDocumento(String tipoDocumentoTipoDocumento) {
        this.tipoDocumentoTipoDocumento = tipoDocumentoTipoDocumento;
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
        hash += (tipoDocumentoTipoDocumento != null ? tipoDocumentoTipoDocumento.hashCode() : 0);
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
        if ((this.tipoDocumentoTipoDocumento == null && other.tipoDocumentoTipoDocumento != null) || (this.tipoDocumentoTipoDocumento != null && !this.tipoDocumentoTipoDocumento.equals(other.tipoDocumentoTipoDocumento))) {
            return false;
        }
        if ((this.numeroDocumento == null && other.numeroDocumento != null) || (this.numeroDocumento != null && !this.numeroDocumento.equals(other.numeroDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.santiago.modelo.entites.CuentaPK[ tipoDocumentoTipoDocumento=" + tipoDocumentoTipoDocumento + ", numeroDocumento=" + numeroDocumento + " ]";
    }
    
}
