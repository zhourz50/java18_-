package com.example.springboot18.dao;

import com.example.springboot18.model.Product;
import com.example.springboot18.view.product.ProductView;

import java.util.List;

// 提供sql语句
public interface IProductDao {

    List<ProductView> selectPage(Product product);

    Long selectCount(Product product);


}
