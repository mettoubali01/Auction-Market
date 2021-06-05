package com.example.auctions_web.beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double initialPrice;
    private double prepaid; //pago anticipado que debe paga el customer para poder realizar el push
    private Byte[] images;
    private Date auctionPeriod;
    @ManyToOne
    @JoinColumn(name = "category_product_fk", nullable = false)
    private ProductCategory productCategory;
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;
    @OneToMany(mappedBy = "product", targetEntity = Push.class)
    private List<Push> pushes = new ArrayList<>();

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte[] getImages() {
        return images;
    }

    public void setImages(Byte[] images) {
        this.images = images;
    }

    public Date getAuctionPeriod() {
        return auctionPeriod;
    }

    public void setAuctionPeriod(Date auctionPeriod) {
        this.auctionPeriod = auctionPeriod;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public double getPrepaid() {
        return prepaid;
    }

    public void setPrepaid(double prepaid) {
        this.prepaid = prepaid;
    }

    public List<Push> getPushes() {
        return pushes;
    }

    public void setPushes(List<Push> pushes) {
        this.pushes = pushes;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", initialPrice=" + initialPrice +
                ", prepaid=" + prepaid +
                ", images=" + Arrays.toString(images) +
                ", auctionPeriod=" + auctionPeriod +
                ", productCategory=" + productCategory +
                ", productStatus=" + productStatus +
                '}';
    }
}