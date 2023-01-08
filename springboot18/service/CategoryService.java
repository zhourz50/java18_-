package com.example.springboot18.service;

import com.example.springboot18.dao.ICategoryDao;
import com.example.springboot18.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    public List<Category> querylist() {

      List<Category> categoryList =  categoryDao.queryList();
        return new ArrayList<>(categoryList);
    }
}
