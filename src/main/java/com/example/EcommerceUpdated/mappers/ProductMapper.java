package com.example.EcommerceUpdated.mappers;

import com.example.EcommerceUpdated.dtos.ProductDTO;
import com.example.EcommerceUpdated.dtos.ProductWithCategoryDTO;
import com.example.EcommerceUpdated.entity.Category;
import com.example.EcommerceUpdated.entity.Product;

public class ProductMapper {

    public static Product toProductEntity(ProductDTO dto, Category category){
        return Product.builder()
                .brand(dto.getBrand())
                .model(dto.getModel())
                .image(dto.getImage())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .category(category)
                .color(dto.getColor())
                .popular(dto.isPopular())
                .discount(dto.getDiscount())
                .title(dto.getTitle())
                .build();
    }

    public static ProductDTO toProductDTO(Product product){
        return ProductDTO.builder()
                .brand(product.getBrand())
                .model(product.getModel())
                .image(product.getImage())
                .price(product.getPrice())
                .description(product.getDescription())
                .categoryId(product.getCategory().getId())
                .color(product.getColor())
                .popular(product.isPopular())
                .discount(product.getDiscount())
                .title(product.getTitle())
                .id(product.getId())
                .build();
    }

    public static ProductWithCategoryDTO toProductWithCategoryDTO(Product product){
        return ProductWithCategoryDTO.builder()
                .brand(product.getBrand())
                .model(product.getModel())
                .image(product.getImage())
                .price(product.getPrice())
                .description(product.getDescription())
                .categoryId(product.getCategory().getId())
                .color(product.getColor())
                .popular(product.isPopular())
                .discount(product.getDiscount())
                .title(product.getTitle())
                .id(product.getId())
                .category(CategoryMapper.toCategoryDTO(product.getCategory()))
                .build();
    }
}
