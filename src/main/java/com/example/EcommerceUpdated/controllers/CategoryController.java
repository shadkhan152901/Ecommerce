package com.example.EcommerceUpdated.controllers;

import com.example.EcommerceUpdated.dtos.AllProductsOfCategory;
import com.example.EcommerceUpdated.dtos.CategoryDTO;
import com.example.EcommerceUpdated.exceptions.CategoryNotFoundException;
import com.example.EcommerceUpdated.service.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("products/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories
            (@RequestParam (required = false) String name) throws IOException {
        if(name != null &&  !name.isBlank()){
             CategoryDTO result = categoryService.findCategoryByName(name);
             return ResponseEntity.ok(result);
        }
        else {
            return ResponseEntity.ok(categoryService.getAllCategories());
        }
    }

    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO dto){
        return categoryService.createCategory(dto);
    }

    @GetMapping("/{id}/products")
    public AllProductsOfCategory getAllProductsOfCategory(@PathVariable Long id){
        return categoryService.getAllProductsOfCategory(id);
    }
}
