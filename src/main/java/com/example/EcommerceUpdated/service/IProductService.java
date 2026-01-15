package com.example.EcommerceUpdated.service;

import com.example.EcommerceUpdated.dtos.ProductDTO;
import com.example.EcommerceUpdated.dtos.ProductWithCategoryDTO;

import java.io.IOException;
import java.util.List;

public interface IProductService {

    public ProductDTO getProductById(Long id) throws IOException;

    public List<ProductDTO> getProductsByCategory(String cat_name) throws IOException;

    public ProductDTO createProduct(ProductDTO dto);

    public List<ProductDTO> findExpensiveProducts(int minPrice);

    public List<ProductDTO> fullTextSearch(String keyword);

    public ProductWithCategoryDTO getProductWithCategory(Long id);
}
