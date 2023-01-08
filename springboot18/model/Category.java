package com.example.springboot18.model;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Category {

//    @ApiModelProperty("主键")
    private Integer categoryId;

    private String categoryName;

    private String createTime;
}
