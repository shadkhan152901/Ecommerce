package com.example.EcommerceUpdated.dtos;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllProductsOfCategory {

    private Long id;

    private String name;

    private List<ProductDTO> product;
}
