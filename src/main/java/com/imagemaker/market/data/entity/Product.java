package com.imagemaker.market.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer roductId;

    @Column(name = "nombre")
    private String name;

    @Column(name = "id_categoria")
    private Integer ategoryId;

    @Column(name = "codigo_barras")
    private String barcode;

    @Column(name = "precio_venta")
    private Double salePrice;

    @Column(name = "cantidad_stock")
    private Integer stock;

    @Column(name = "estado")
    private Boolean state;

    @ManyToOne
    @JoinColumn( name = "id_categoria", insertable = false, updatable = false)
    private Category category;

    public Integer getRoductId() {
        return roductId;
    }

    public void setRoductId(Integer roductId) {
        this.roductId = roductId;
    }

    public Integer getAtegoryId() {
        return ategoryId;
    }

    public void setAtegoryId(Integer ategoryId) {
        this.ategoryId = ategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
