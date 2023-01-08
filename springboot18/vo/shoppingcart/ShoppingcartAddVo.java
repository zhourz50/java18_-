package com.example.springboot18.vo.shoppingcart;

import com.example.springboot18.model.Shoppingcart;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;

public class ShoppingcartAddVo {
    @NotBlank  // 不为null并且不为空字符串
    @ApiModelProperty(value = "用户Id", required = true)
    private static String userId;

    @NotBlank  // 不为空
    @ApiModelProperty(value = "商品ID", required = true)
    private String productId;

    public static Shoppingcart transfToModel() {

        Shoppingcart user = new Shoppingcart();
        BeanUtils.copyProperties(userId, user);
        return user;
    }
}
