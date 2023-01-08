package com.example.springboot18.model;

import lombok.Data;

@Data
public class Shoppingcart {
    private Integer userId;

    private Integer categoryId;

    private Integer productId;

    private String productIntro;

    private String productName;

    private String productPicture;

    private Double productPrice;

    private Double productSellingPrice;

    private String productTitle;

    private Integer hot;
}
