package com.example.EcommerceUpdated.service;

import com.example.EcommerceUpdated.dtos.AllProductsOfCategory;
import com.example.EcommerceUpdated.dtos.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

    public List<CategoryDTO> getAllCategories() throws IOException;

    public CategoryDTO createCategory(CategoryDTO dto);

    public CategoryDTO findCategoryByName(String name);

    public AllProductsOfCategory getAllProductsOfCategory(Long id);
}
