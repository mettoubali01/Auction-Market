package com.example.auctions_web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Push {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @JsonIgnore
    private UUID id;
    @ManyToOne
    @JoinColumn(nullable = false, name = "product_fk")
    private Product product;
    @ManyToOne
    @JoinColumn(nullable = false, name = "user_fk")
    private Customer customer;

    private double pushPrice;
    @Temporal(TemporalType.TIMESTAMP)
    private Date pushDate;

    public Push() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getPushPrice() {
        return pushPrice;
    }

    public void setPushPrice(double pushPrice) {
        this.pushPrice = pushPrice;
    }

    public Date getPushDate() {
        return pushDate;
    }

    public void setPushDate(Date pushDate) {
        this.pushDate = pushDate;
    }

    @Override
    public String toString() {
        return "Push{" +
                "id=" + id +
                ", product=" + product +
                ", customer=" + customer +
                ", pushPrice=" + pushPrice +
                ", pushDate=" + pushDate +
                '}';
    }
}
