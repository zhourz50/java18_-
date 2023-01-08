package com.example.springboot18.service;

import com.example.springboot18.dao.IShoppingcartDao;
import com.example.springboot18.model.Product;
import com.example.springboot18.model.Shoppingcart;
import com.example.springboot18.view.product.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ShoppingcartService {
    @Autowired
    private static IShoppingcartDao shoppingcartDao;

    @Transactional
    public static int save(Shoppingcart user) {
        return shoppingcartDao.save(user);
    }
    public static List<ProductView> selectPage(Product product) {
        List<ProductView> productViews = shoppingcartDao.selectPage(product);
        return productViews;
    }

    public static Long count(Product product) {
        return shoppingcartDao.selectCount(product);
    }
}
