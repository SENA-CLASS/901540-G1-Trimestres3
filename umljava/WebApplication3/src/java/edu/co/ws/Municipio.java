/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.ws;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByIdMunicipio", query = "SELECT m FROM Municipio m WHERE m.idMunicipio = :idMunicipio"),
    @NamedQuery(name = "Municipio.findByNomnbreMunicipio", query = "SELECT m FROM Municipio m WHERE m.nomnbreMunicipio = :nomnbreMunicipio")})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MUNICIPIO")
    private Integer idMunicipio;
    @Size(max = 45)
    @Column(name = "NOMNBRE_MUNICIPIO")
    private String nomnbreMunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipioIdMunicipio")
    private Collection<DomicilioProvee> domicilioProveeCollection;
    @JoinColumn(name = "DEPARTAMENTO_ID_DEPARTAMENTO", referencedColumnName = "ID_DEPARTAMENTO")
    @ManyToOne(optional = false)
    private Departamento departamentoIdDepartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipioIdMunicipio")
    private Collection<DomicilioCuentas> domicilioCuentasCollection;

    public Municipio() {
    }

    public Municipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNomnbreMunicipio() {
        return nomnbreMunicipio;
    }

    public void setNomnbreMunicipio(String nomnbreMunicipio) {
        this.nomnbreMunicipio = nomnbreMunicipio;
    }

    @XmlTransient
    public Collection<DomicilioProvee> getDomicilioProveeCollection() {
        return domicilioProveeCollection;
    }

    public void setDomicilioProveeCollection(Collection<DomicilioProvee> domicilioProveeCollection) {
        this.domicilioProveeCollection = domicilioProveeCollection;
    }

    public Departamento getDepartamentoIdDepartamento() {
        return departamentoIdDepartamento;
    }

    public void setDepartamentoIdDepartamento(Departamento departamentoIdDepartamento) {
        this.departamentoIdDepartamento = departamentoIdDepartamento;
    }

    @XmlTransient
    public Collection<DomicilioCuentas> getDomicilioCuentasCollection() {
        return domicilioCuentasCollection;
    }

    public void setDomicilioCuentasCollection(Collection<DomicilioCuentas> domicilioCuentasCollection) {
        this.domicilioCuentasCollection = domicilioCuentasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipio != null ? idMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.idMunicipio == null && other.idMunicipio != null) || (this.idMunicipio != null && !this.idMunicipio.equals(other.idMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.ws.Municipio[ idMunicipio=" + idMunicipio + " ]";
    }
    
}
