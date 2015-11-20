/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql;

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
public class ProveedorPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "TIPO_DOCUMENTO_TIPO_DOCUMENTO")
    private String tipoDocumentoTipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NUM_DOCUMENTO")
    private String numDocumento;

    public ProveedorPK() {
    }

    public ProveedorPK(String tipoDocumentoTipoDocumento, String numDocumento) {
        this.tipoDocumentoTipoDocumento = tipoDocumentoTipoDocumento;
        this.numDocumento = numDocumento;
    }

    public String getTipoDocumentoTipoDocumento() {
        return tipoDocumentoTipoDocumento;
    }

    public void setTipoDocumentoTipoDocumento(String tipoDocumentoTipoDocumento) {
        this.tipoDocumentoTipoDocumento = tipoDocumentoTipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoDocumentoTipoDocumento != null ? tipoDocumentoTipoDocumento.hashCode() : 0);
        hash += (numDocumento != null ? numDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProveedorPK)) {
            return false;
        }
        ProveedorPK other = (ProveedorPK) object;
        if ((this.tipoDocumentoTipoDocumento == null && other.tipoDocumentoTipoDocumento != null) || (this.tipoDocumentoTipoDocumento != null && !this.tipoDocumentoTipoDocumento.equals(other.tipoDocumentoTipoDocumento))) {
            return false;
        }
        if ((this.numDocumento == null && other.numDocumento != null) || (this.numDocumento != null && !this.numDocumento.equals(other.numDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.ProveedorPK[ tipoDocumentoTipoDocumento=" + tipoDocumentoTipoDocumento + ", numDocumento=" + numDocumento + " ]";
    }
    
}
