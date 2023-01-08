package com.example.springboot18.model;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

//@ApiModel("用户实体类")
@Data
@ToString
public class User {

//    @ApiModelProperty(value = "用户id")
    private Integer userId;

//    @ApiModelProperty("用户名称")
    private String username;

//    @ApiModelProperty("密码")
    private String password;

//    @ApiModelProperty("创建时间 yyyy-MM-dd HH:mm:ss")
    private String createTime;


}

