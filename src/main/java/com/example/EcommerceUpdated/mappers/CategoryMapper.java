package com.example.EcommerceUpdated.mappers;

import com.example.EcommerceUpdated.dtos.AllProductsOfCategory;
import com.example.EcommerceUpdated.dtos.CategoryDTO;
import com.example.EcommerceUpdated.entity.Category;

public class CategoryMapper {

    public static CategoryDTO toCategoryDTO(Category category){
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category toCategoryEntity(CategoryDTO categoryDTO){
        return Category.builder()
                .name(categoryDTO.getName())
                .build();
    }

    public static AllProductsOfCategory toAllProductsOfCategory(Category category){
        return AllProductsOfCategory.builder()
                .id(category.getId())
                .name(category.getName())
                .product(category.getProducts().stream().map(ProductMapper::toProductDTO).toList())
                .build();

    }
}
