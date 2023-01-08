package com.example.springboot18.controller.shoppingcart;

import com.example.springboot18.model.Product;
import com.example.springboot18.model.Shoppingcart;
import com.example.springboot18.service.ShoppingcartService;
import com.example.springboot18.util.JWTUtil;
import com.example.springboot18.view.ResultView;
import com.example.springboot18.view.product.ProductView;
import com.example.springboot18.vo.product.ProductQueryVo;
import com.example.springboot18.vo.shoppingcart.ShoppingcartAddVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v2/shoppingCart")
public class ShoppingCartController {

    @GetMapping
    public ResultView shoppinglist(@RequestHeader("Authorization") String token) {
        // 购物车表   类似用户和商品的中间表(多对多关系)
        System.out.println(token);
        try {
            String userId = JWTUtil.getClaim("userId", token);

            Shoppingcart userAdd = ShoppingcartAddVo.transfToModel();
            int num = ShoppingcartService.save(userAdd);
            //根据userId,查询这个用户相关的购物车集合
            System.out.println(userId);
        } catch (Exception e) {
            System.out.println("token校验失败");
            return ResultView.fail("登录超时，请重新登录");
        }
        return null;
    }


    @GetMapping("/product/count")
    public ResultView<List<ProductView>> pageList(@Valid ProductQueryVo vo) {
        Product product = vo.transferToModel();

        List<ProductView> productViews = ShoppingcartService.selectPage(product);

        Long total = ShoppingcartService.count(product);

        return ResultView.success(productViews, total);
    }

}
