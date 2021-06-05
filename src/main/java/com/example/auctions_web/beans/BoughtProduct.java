package com.example.auctions_web.beans;

import javax.persistence.*;

@Entity
public class BoughtProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "pushed_product_customer")
    private Push pushed_customer_product;

    public BoughtProduct() {
    }

    public Push getPushed_customer_product() {
        return pushed_customer_product;
    }

    public void setPushed_customer_product(Push pushed_customer_product) {
        this.pushed_customer_product = pushed_customer_product;
    }

    @Override
    public String toString() {
        return "BoughtProduct{" +
                "pushed_customer_product=" + pushed_customer_product +
                '}';
    }
}