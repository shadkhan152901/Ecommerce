package com.example.EcommerceUpdated.service;

import com.example.EcommerceUpdated.dtos.ProductDTO;
import com.example.EcommerceUpdated.dtos.ProductWithCategoryDTO;
import com.example.EcommerceUpdated.entity.Category;
import com.example.EcommerceUpdated.entity.Product;
import com.example.EcommerceUpdated.exceptions.ProductNotFoundException;
import com.example.EcommerceUpdated.gateway.IProductGateway;
import com.example.EcommerceUpdated.mappers.ProductMapper;
import com.example.EcommerceUpdated.repository.CategoryRepository;
import com.example.EcommerceUpdated.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService implements IProductService{
    private final IProductGateway productGateway;

    private final ProductRepository repo;

    private final CategoryRepository categoryRepository;

    public ProductService(IProductGateway productGateway, ProductRepository repo, CategoryRepository categoryRepository) {
        this.productGateway = productGateway;
        this.repo = repo;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
       Product product = repo.findById(id).orElseThrow(
               () -> new ProductNotFoundException("product with id " + id + " not found")
       );
       return ProductMapper.toProductDTO(product);
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String cat_name) throws IOException {
        return productGateway.getProductsByCategory(cat_name);
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) {
        Category fetchedCategory = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category with" +
                        " id "+ dto.getCategoryId() + " not found"));
         Product savedProduct = repo
                 .save(ProductMapper.toProductEntity(dto,fetchedCategory));
         return ProductMapper.toProductDTO(savedProduct);
    }

    @Override
    public List<ProductDTO> findExpensiveProducts(int minPrice) {
        List<Product> products= repo.findExpensiveProducts(minPrice);
        return products.stream().map(ProductMapper::toProductDTO).toList();
    }

    @Override
    public List<ProductDTO> fullTextSearch(String keyword) {
        List<Product> products= repo.findTextSearch(keyword);
        return products.stream().map(ProductMapper::toProductDTO).toList();
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) {
        Product fetchedProduct = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found"));
        return ProductMapper.toProductWithCategoryDTO(fetchedProduct);
    }
}
