package com.example.springboot18.model;

import lombok.Data;

@Data
public class Orders {
    private Integer OrderId;

    private String OrderNum;

    private String OrderTime;

    private Integer productId;

    private String productName;

    private String productPicture;

    private Double productSellingPrice;


}
