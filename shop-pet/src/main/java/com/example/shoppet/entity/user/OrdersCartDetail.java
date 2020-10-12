package com.example.shoppet.entity.user;


import javax.persistence.*;

@Entity
//@Table(name = "OrdersCartDetail" )
public class OrdersCartDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long id_product;
    private long id_OrdersCart;
    private int quanty;
    private double total;

    public OrdersCartDetail() {
    }

    public long getId() {
        return id;
    }

    public long getId_OrdersCart() {
        return id_OrdersCart;
    }

    public void setId_OrdersCart(long id_OrdersCart) {
        this.id_OrdersCart = id_OrdersCart;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_product() {
        return id_product;
    }

    public void setId_product(long id_product) {
        this.id_product = id_product;
    }

    public int getQuanty() {
        return quanty;
    }

    public void setQuanty(int quanty) {
        this.quanty = quanty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
