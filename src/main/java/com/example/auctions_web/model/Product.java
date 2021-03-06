package com.example.auctions_web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @JsonIgnore
    private UUID id;
    @JoinColumn(nullable = false)
    private String name;
    @JoinColumn(nullable = false)
    private String description;
    @JoinColumn(nullable = false)
    private double price;
    private String cityLocation;
    private double prepaid; //pago anticipado que debe paga el customer para poder realizar el push
    @Temporal(TemporalType.TIMESTAMP)
    private Date auctionPeriod;
    @ManyToOne
    @JoinColumn(name = "category_product_fk", nullable = false)
    private ProductCategory productCategory;
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;
    @OneToMany(mappedBy = "product", targetEntity = Push.class)
    private List<Push> pushes = new ArrayList<>();
    @OneToMany(mappedBy = "product", targetEntity = ProductImages.class)
    private List<ProductImages> images = new ArrayList<>();

    public Product() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public List<ProductImages> getImages() {
        return images;
    }

    public void setImages(List<ProductImages> images) {
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
        return price;
    }

    public void setInitialPrice(double price) {
        this.price = price;
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

    public String getCityLocation() {
        return cityLocation;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", cityLocation='" + cityLocation + '\'' +
                ", prepaid=" + prepaid +
                ", auctionPeriod=" + auctionPeriod +
                ", productCategory=" + productCategory +
                ", productStatus=" + productStatus +
                ", pushes=" + pushes +
                ", images=" + images +
                '}';
    }
}
