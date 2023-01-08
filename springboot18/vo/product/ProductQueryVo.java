package com.example.springboot18.vo.product;

import cn.hutool.core.bean.BeanUtil;
import com.example.springboot18.model.Product;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProductQueryVo {

    @NotNull
//    @ApiModelProperty(value = "第几页", required = true)
    private Integer pageNum;

    @NotNull
//    @ApiModelProperty(value = "一页多少条", required = true)
    private Integer pageSize;

    private Integer categoryId;

    private Integer productId;

    private String productName;

    public Product transferToModel() {
        Product product = new Product();
        BeanUtil.copyProperties(this, product);
        return product;
    }
}
