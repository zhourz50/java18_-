package com.example.springboot18.dao;

import com.example.springboot18.model.Product;
import com.example.springboot18.model.Shoppingcart;
import com.example.springboot18.view.product.ProductView;

import java.util.List;

public interface IShoppingcartDao {
    List<ProductView> selectPage(Product product);

    Long selectCount(Product product);
    public int save(Shoppingcart user);
}
