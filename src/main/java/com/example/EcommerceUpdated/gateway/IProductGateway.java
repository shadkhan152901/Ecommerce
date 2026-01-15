package com.example.EcommerceUpdated.gateway;

import com.example.EcommerceUpdated.dtos.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {
    public ProductDTO getProductById(Long id) throws IOException;
    public List<ProductDTO> getProductsByCategory(String cat_name) throws IOException;
}
