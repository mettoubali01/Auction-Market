package com.example.auctions_web.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.util.Date;

public class ProductUploadDto {

    @NotEmpty(message = "The Title field should not be empty")
    @Size(min = 3, message = "The Title must be a minimum of 3 characters")
    @Size(max = 100, message = "The Title must be a maximum of 100 characters")
    private String title;

    @Future(message = "The Pushes Until field should be a future valid date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pushesUntil;

    @Min(value = 1, message = "The Price field has to be more than 1 ")
//    @NotEmpty(message = "The Price field should not be empty ")
    private int price;

    @Min(value = 1, message = "The PrePaid field has to be more than 1 ")
//    @NotEmpty(message = "The PrePaid field should not be empty ")
    private int prePaid;

    @NotEmpty(message = "The Description field should not be empty")
    @Size(min = 3, message = "The Description must be a minimum of 3 characters")
    @Size(max = 1000, message = "The Description must be a maximum of 1000 characters")
    private String description;

    @NotNull(message = "You should select an image for your product")
    private MultipartFile image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPushesUntil() {
        return pushesUntil;
    }

    public void setPushesUntil(Date pushesUntil) {
        this.pushesUntil = pushesUntil;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrePaid() {
        return prePaid;
    }

    public void setPrePaid(int prePaid) {
        this.prePaid = prePaid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
