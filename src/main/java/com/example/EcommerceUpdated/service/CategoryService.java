package com.example.EcommerceUpdated.service;

import com.example.EcommerceUpdated.dtos.AllProductsOfCategory;
import com.example.EcommerceUpdated.dtos.CategoryDTO;
import com.example.EcommerceUpdated.entity.Category;
import com.example.EcommerceUpdated.exceptions.CategoryNotFoundException;
import com.example.EcommerceUpdated.gateway.ICategoryGateway;
import com.example.EcommerceUpdated.mappers.CategoryMapper;
import com.example.EcommerceUpdated.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    private final ICategoryGateway categoryGateway;

    private final CategoryRepository categoryRepository;

    public CategoryService(ICategoryGateway categoryGateway, CategoryRepository categoryRepository) {
        this.categoryGateway = categoryGateway;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return categoryGateway.getAllCategories();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO dto) {
       Category savedCategory = categoryRepository
               .save(CategoryMapper.toCategoryEntity(dto));
       return CategoryMapper.toCategoryDTO(savedCategory);
    }

    @Override
    public CategoryDTO findCategoryByName(String name) {
       Category fetchedCategory = categoryRepository.findByName(name);
       if(fetchedCategory == null){
           throw new RuntimeException("Category not found!");
       }
       return CategoryMapper.toCategoryDTO(fetchedCategory);
    }

    @Override
    public AllProductsOfCategory getAllProductsOfCategory(Long id) {
        Category fetchedCategory  = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("category with id " + id + " not found"));
        return CategoryMapper.toAllProductsOfCategory(fetchedCategory);
    }
}
