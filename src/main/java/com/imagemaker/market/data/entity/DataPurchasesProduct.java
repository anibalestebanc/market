package com.imagemaker.market.data.entity;


import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
public class DataPurchasesProduct {

    @EmbeddedId
    private PurchaseProductPK id;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "total")
    private Double total;

    @Column(name = "estado")
    private Boolean state;

    @ManyToOne
    @MapsId("purchaseId")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private DataPurchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private DataProduct product;

    public DataPurchase getPurchase() {
        return purchase;
    }

    public void setPurchase(DataPurchase purchase) {
        this.purchase = purchase;
    }

    public PurchaseProductPK getId() {
        return id;
    }

    public void setId(PurchaseProductPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
