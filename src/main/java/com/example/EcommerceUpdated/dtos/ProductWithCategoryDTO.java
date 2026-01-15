package com.example.EcommerceUpdated.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductWithCategoryDTO {

    private String image;
    private String color;
    private Integer price;
    private String description;
    private Integer discount;
    private Long id;
    private String model;
    private String title;
    private String brand;
    private Long categoryId;
    private boolean popular;

    private CategoryDTO category;
}
