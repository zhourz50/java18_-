package com.example.springboot18.controller.user;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.example.springboot18.model.User;
import com.example.springboot18.service.UserService;
import com.example.springboot18.util.JWTUtil;
import com.example.springboot18.view.ResultView;
import com.example.springboot18.vo.user.UserAddVo;
import com.example.springboot18.vo.user.UserInfoVo;
import com.example.springboot18.vo.user.UserLoginVo;
//import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// 数据校验、拼接等等
@RestController
@RequestMapping("/v2/ms/user")
//@Api(tags = "用户模块")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResultView register(@Valid @RequestBody UserAddVo addVo) {

        // 判断用户名是否已经存在
        List<User> userList = userService.selectByCondition(addVo.transfToModel());
        if (userList.size() > 0) {
//            ResultView view = new ResultView();
//            view.setCode(50020);
//            view.setMsg("用户名密码已存在");
            return ResultView.fail(50020);
        }
        User userAdd = addVo.transfToModel();
        userAdd.setCreateTime(DateUtil.now());
        int num = userService.save(userAdd);

        return ResultView.success(num);
    }

    @PostMapping("/login")
    public ResultView<String> login(@Valid @RequestBody UserLoginVo loginVo) {

        List<User> userList = userService.selectByCondition(loginVo.transfToModel());

        if (CollectionUtil.isEmpty(userList)) {
            return ResultView.fail(500, "用户名/密码错误");
        }

        User user = userList.get(0);
        String token = JWTUtil.getToken(user.getUserId());

        return ResultView.success(token);

    }

    @GetMapping("/info")
    public ResultView<List<UserInfoVo>> info(@Valid UserInfoVo vo){
        User user = vo.transferToModel();
        return ResultView.success(user);
    }
}

