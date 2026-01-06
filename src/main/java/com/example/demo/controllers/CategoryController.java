package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class CategoryController {

    @GetMapping("/categories")
    public String getCategory(){
        return "Electronics";
    }

    @GetMapping("/categories/1")
    public String getCategoryOne(){
        return "Fashion";
    }

    @PostMapping("/categories")
    public String createCategory(){
        return "new Category created";
    }

    @GetMapping("/categories/count")
    public int getCountCategory(){
        return 3;
    }
}
