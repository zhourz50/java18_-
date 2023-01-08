package com.example.springboot18.dao;

import com.example.springboot18.model.Category;
import com.example.springboot18.view.category.CategoryView;

import java.util.List;

public interface ICategoryDao {

    List<Category> queryList();

    List<CategoryView> queryViewList();
}
