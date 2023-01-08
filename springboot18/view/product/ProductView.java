package com.example.springboot18.view.product;

import lombok.Data;

@Data
public class ProductView {

    private Integer productId;

    private Integer categoryId;

    private String categoryName;

    private String productIntro;

    private String productName;

    private String productPicture;

    private Double productPrice;

    private Double productSellingPrice;

    private String productTitle;

}
