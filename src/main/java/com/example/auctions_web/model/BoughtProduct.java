package com.example.auctions_web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class BoughtProduct {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @JsonIgnore
    private UUID id;

    @OneToOne
    @JoinColumn(name = "pushed_product_customer")
    private Push pushed_customer_product;

    public BoughtProduct() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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