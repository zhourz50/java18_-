package com.example.springboot18.view.orders;

import lombok.Data;

@Data
public class OrdersView {
    private Integer OrderId;

    private String OrderNum;

    private String OrderTime;

    private Integer productId;

    private String productName;

    private String productPicture;

    private Double productPrice;

    private Double productSellingPrice;

    private String productTitle;

}
