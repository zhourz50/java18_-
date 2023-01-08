package com.example.springboot18.vo.orders;

import cn.hutool.core.bean.BeanUtil;
import com.example.springboot18.model.Orders;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class OrdersQueryVo {
    @NotNull
    @ApiModelProperty(value = "订单id", required = true)
    private Integer OrderId;

    private String OrderNum;

    private String OrderTime;

    private Integer productId;

    private String productName;

    private Double productPrice;

    public Orders transferToModel() {
        Orders orders = new Orders();
        BeanUtil.copyProperties(this, orders);
        return orders;
    }
}
