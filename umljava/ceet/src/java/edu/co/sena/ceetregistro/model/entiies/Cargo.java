/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ceetregistro.model.entiies;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hernando
 */
@Entity
@Table(name = "cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByIdCargo", query = "SELECT c FROM Cargo c WHERE c.idCargo = :idCargo"),
    @NamedQuery(name = "Cargo.findByDescripcionCargo", query = "SELECT c FROM Cargo c WHERE c.descripcionCargo = :descripcionCargo")})
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "idCargo")
    private String idCargo;
    @Size(max = 45)
    @Column(name = "descripcion_Cargo")
    private String descripcionCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargoidCargo")
    private Collection<Cuenta> cuentaCollection;

    public Cargo() {
    }

    public Cargo(String idCargo) {
        this.idCargo = idCargo;
    }

    public String getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(String idCargo) {
        this.idCargo = idCargo;
    }

    public String getDescripcionCargo() {
        return descripcionCargo;
    }

    public void setDescripcionCargo(String descripcionCargo) {
        this.descripcionCargo = descripcionCargo;
    }

    @XmlTransient
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }

    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargo != null ? idCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  idCargo;
    }
    
}
