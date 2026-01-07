package com.example.EcommerceUpdated.gateway;

import com.example.EcommerceUpdated.dtos.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {

    public List<CategoryDTO> getAllCategories() throws IOException;
}
