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
public class PropietarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "equipo_serial")
    private String equipoSerial;
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

    public PropietarioPK() {
    }

    public PropietarioPK(String equipoSerial, String cuentaTipoDocumentotipodocumento, String cuentanumeroDocumento) {
        this.equipoSerial = equipoSerial;
        this.cuentaTipoDocumentotipodocumento = cuentaTipoDocumentotipodocumento;
        this.cuentanumeroDocumento = cuentanumeroDocumento;
    }

    public String getEquipoSerial() {
        return equipoSerial;
    }

    public void setEquipoSerial(String equipoSerial) {
        this.equipoSerial = equipoSerial;
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
        hash += (equipoSerial != null ? equipoSerial.hashCode() : 0);
        hash += (cuentaTipoDocumentotipodocumento != null ? cuentaTipoDocumentotipodocumento.hashCode() : 0);
        hash += (cuentanumeroDocumento != null ? cuentanumeroDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PropietarioPK)) {
            return false;
        }
        PropietarioPK other = (PropietarioPK) object;
        if ((this.equipoSerial == null && other.equipoSerial != null) || (this.equipoSerial != null && !this.equipoSerial.equals(other.equipoSerial))) {
            return false;
        }
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
        return "edu.co.sena.ceetregistro.model.entiies.PropietarioPK[ equipoSerial=" + equipoSerial + ", cuentaTipoDocumentotipodocumento=" + cuentaTipoDocumentotipodocumento + ", cuentanumeroDocumento=" + cuentanumeroDocumento + " ]";
    }
    
}
