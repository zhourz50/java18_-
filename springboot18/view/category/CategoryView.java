package com.example.springboot18.view.category;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CategoryView {

    @ApiModelProperty("分类id")
    private Integer categoryId;

    @ApiModelProperty("分类名称")
    private String categoryName;
}
