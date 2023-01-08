package com.example.springboot18.service;

import com.example.springboot18.dao.IProductDao;
import com.example.springboot18.model.Product;
import com.example.springboot18.view.product.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private IProductDao productDao;

    public List<ProductView> selectPage(Product product) {
        List<ProductView> productViews = productDao.selectPage(product);
        return productViews;
    }

    public Long count(Product product) {
        return productDao.selectCount(product);
    }
}
