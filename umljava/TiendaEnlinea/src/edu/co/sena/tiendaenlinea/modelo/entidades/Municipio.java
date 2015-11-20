/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendaenlinea.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author hernando
 */
@Entity
@Table(name = "municipio")
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m")})
public class Municipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MUNICIPIO")
    private Integer idMunicipio;
    @Column(name = "NOMNBRE_MUNICIPIO")
    private String nomnbreMunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipio", fetch = FetchType.EAGER)
    private List<DomicilioProvee> domicilioProveeList;
    @JoinColumn(name = "DEPARTAMENTO_ID_DEPARTAMENTO", referencedColumnName = "ID_DEPARTAMENTO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Departamento departamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipio", fetch = FetchType.EAGER)
    private List<DomicilioCuentas> domicilioCuentasList;

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

    public List<DomicilioProvee> getDomicilioProveeList() {
        return domicilioProveeList;
    }

    public void setDomicilioProveeList(List<DomicilioProvee> domicilioProveeList) {
        this.domicilioProveeList = domicilioProveeList;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<DomicilioCuentas> getDomicilioCuentasList() {
        return domicilioCuentasList;
    }

    public void setDomicilioCuentasList(List<DomicilioCuentas> domicilioCuentasList) {
        this.domicilioCuentasList = domicilioCuentasList;
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
        return "edu.co.sena.tiendaenlinea.modelo.entidades.Municipio[ idMunicipio=" + idMunicipio + " ]";
    }
    
}
