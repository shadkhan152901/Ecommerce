package com.example.EcommerceUpdated.service;

import com.example.EcommerceUpdated.dtos.CategoryDTO;
import com.example.EcommerceUpdated.gateway.ICategoryGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    private final ICategoryGateway categoryGateway;

    public CategoryService(ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return categoryGateway.getAllCategories();
    }
}
