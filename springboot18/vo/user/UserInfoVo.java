package com.example.springboot18.vo.user;

import cn.hutool.core.bean.BeanUtil;
import com.example.springboot18.model.User;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class UserInfoVo {

    @NotNull
    @ApiModelProperty("用户名称")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("创建时间 yyyy-MM-dd HH:mm:ss")
    private String createTime;
    public User transferToModel() {
        User user = new User();
        BeanUtil.copyProperties(this, user);
        return user;
    }
}
