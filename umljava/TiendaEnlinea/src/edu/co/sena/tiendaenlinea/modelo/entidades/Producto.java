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
import javax.persistence.Lob;
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
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private String idProducto;
    @Basic(optional = false)
    @Column(name = "NOMBRE_PRODUCTO")
    private String nombreProducto;
    @Basic(optional = false)
    @Column(name = "PRECIO_DETAl")
    private double pRECIODETAl;
    @Lob
    @Column(name = "IMAGEN")
    private byte[] imagen;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDAD")
    private Float cantidad;
    @Basic(optional = false)
    @Column(name = "ACTIVO")
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<Item> itemList;
    @JoinColumn(name = "CATALOGO_ID_CATALOGO", referencedColumnName = "ID_CATALOGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Catalogo catalogo;
    @JoinColumn(name = "CATEGORIA_ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Categoria categoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<ItemCarrito> itemCarritoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<InventarioCompras> inventarioComprasList;

    public Producto() {
    }

    public Producto(String idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(String idProducto, String nombreProducto, double pRECIODETAl, boolean activo) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.pRECIODETAl = pRECIODETAl;
        this.activo = activo;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPRECIODETAl() {
        return pRECIODETAl;
    }

    public void setPRECIODETAl(double pRECIODETAl) {
        this.pRECIODETAl = pRECIODETAl;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<ItemCarrito> getItemCarritoList() {
        return itemCarritoList;
    }

    public void setItemCarritoList(List<ItemCarrito> itemCarritoList) {
        this.itemCarritoList = itemCarritoList;
    }

    public List<InventarioCompras> getInventarioComprasList() {
        return inventarioComprasList;
    }

    public void setInventarioComprasList(List<InventarioCompras> inventarioComprasList) {
        this.inventarioComprasList = inventarioComprasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tiendaenlinea.modelo.entidades.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
