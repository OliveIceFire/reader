package com.example.reader.controller;

import com.example.reader.entity.Category;
import com.example.reader.service.CategoryService;
import com.example.reader.utils.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Resource
    CategoryService categoryService;

    @GetMapping("/list")
    public ResponseUtils list() {
        ResponseUtils responseUtils;
        try {
            List<Category> categories = categoryService.selectAll();
            responseUtils = new ResponseUtils().put("list", categories);
        } catch (Exception e) {
            e.printStackTrace();
            responseUtils = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return responseUtils;
    }
}
