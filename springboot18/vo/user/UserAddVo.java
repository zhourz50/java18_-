package com.example.springboot18.vo.user;

import com.example.springboot18.model.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.*;

@Data
public class UserAddVo {

    @NotBlank  // 不为null并且不为空字符串
    @ApiModelProperty(value = "用户姓名", required = true)
    private String username;

    @NotBlank  // 不为空
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    public User transfToModel() {

        User user = new User();
        BeanUtils.copyProperties(this, user);
        return user;
    }


}
