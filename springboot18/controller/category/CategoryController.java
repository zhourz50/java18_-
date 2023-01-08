package com.example.springboot18.controller.category;

import com.example.springboot18.model.Category;
import com.example.springboot18.service.CategoryService;
import com.example.springboot18.view.ResultView;
import com.example.springboot18.view.category.CategoryView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v2/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResultView<CategoryView> selectListCategory() {
        List<Category> list = categoryService.querylist();

        List<CategoryView> viewList = list.stream().map(s -> {
            CategoryView view = new CategoryView();
            BeanUtils.copyProperties(s, view);
            return view;
        }).collect(Collectors.toList());

        ResultView resultView = new ResultView();
        resultView.setData(viewList);

        return resultView;

    }

}
