package com.example.springboot18.controller.product;

import com.example.springboot18.model.Product;
import com.example.springboot18.service.ProductService;
import com.example.springboot18.view.ResultView;
import com.example.springboot18.view.product.ProductView;
import com.example.springboot18.vo.product.ProductQueryVo;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v2/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
//    @ApiOperation("分页获取商品列表")
    public ResultView<List<ProductView>> pageList(@Valid ProductQueryVo vo) {
        Product product = vo.transferToModel();
        // 返回商品列表
        List<ProductView> productViews = productService.selectPage(product);

        // 记录总数
        Long total = productService.count(product);

        return ResultView.success(productViews, total);
    }


}
