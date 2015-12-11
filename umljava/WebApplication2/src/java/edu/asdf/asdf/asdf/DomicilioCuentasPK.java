/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asdf.asdf.asdf;

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
public class DomicilioCuentasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CUENTA_TIPO_DOCUMENTO_TIPO_DOCUMENTO")
    private String cuentaTipoDocumentoTipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CUENTA_NUMERO_DOCUMENTO")
    private String cuentaNumeroDocumento;

    public DomicilioCuentasPK() {
    }

    public DomicilioCuentasPK(String cuentaTipoDocumentoTipoDocumento, String cuentaNumeroDocumento) {
        this.cuentaTipoDocumentoTipoDocumento = cuentaTipoDocumentoTipoDocumento;
        this.cuentaNumeroDocumento = cuentaNumeroDocumento;
    }

    public String getCuentaTipoDocumentoTipoDocumento() {
        return cuentaTipoDocumentoTipoDocumento;
    }

    public void setCuentaTipoDocumentoTipoDocumento(String cuentaTipoDocumentoTipoDocumento) {
        this.cuentaTipoDocumentoTipoDocumento = cuentaTipoDocumentoTipoDocumento;
    }

    public String getCuentaNumeroDocumento() {
        return cuentaNumeroDocumento;
    }

    public void setCuentaNumeroDocumento(String cuentaNumeroDocumento) {
        this.cuentaNumeroDocumento = cuentaNumeroDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentaTipoDocumentoTipoDocumento != null ? cuentaTipoDocumentoTipoDocumento.hashCode() : 0);
        hash += (cuentaNumeroDocumento != null ? cuentaNumeroDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DomicilioCuentasPK)) {
            return false;
        }
        DomicilioCuentasPK other = (DomicilioCuentasPK) object;
        if ((this.cuentaTipoDocumentoTipoDocumento == null && other.cuentaTipoDocumentoTipoDocumento != null) || (this.cuentaTipoDocumentoTipoDocumento != null && !this.cuentaTipoDocumentoTipoDocumento.equals(other.cuentaTipoDocumentoTipoDocumento))) {
            return false;
        }
        if ((this.cuentaNumeroDocumento == null && other.cuentaNumeroDocumento != null) || (this.cuentaNumeroDocumento != null && !this.cuentaNumeroDocumento.equals(other.cuentaNumeroDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.asdf.asdf.asdf.DomicilioCuentasPK[ cuentaTipoDocumentoTipoDocumento=" + cuentaTipoDocumentoTipoDocumento + ", cuentaNumeroDocumento=" + cuentaNumeroDocumento + " ]";
    }
    
}
