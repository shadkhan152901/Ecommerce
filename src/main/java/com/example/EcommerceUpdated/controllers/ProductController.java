package com.example.EcommerceUpdated.controllers;

import com.example.EcommerceUpdated.dtos.ProductDTO;
import com.example.EcommerceUpdated.dtos.ProductWithCategoryDTO;
import com.example.EcommerceUpdated.exceptions.ProductNotFoundException;
import com.example.EcommerceUpdated.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController()
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) throws IOException{
            ProductDTO result = productService.getProductById(id);
            return ResponseEntity.ok(result);
    }

    @GetMapping("/category/{cat_name}")
    public List<ProductDTO> getProductsByCategory(@PathVariable String cat_name) throws IOException {
        return productService.getProductsByCategory(cat_name);
    }

        @PostMapping
        public ProductDTO createProduct(@RequestBody ProductDTO dto){
            return productService.createProduct(dto);
        }

        @GetMapping()
        public List<ProductDTO> findExpensiveProducts(@RequestParam int minPrice){
         return productService.findExpensiveProducts(minPrice);
        }

    @GetMapping("/search")
    public List<ProductDTO> fullTextSearch(@RequestParam String keyword){
        return productService.fullTextSearch(keyword);
    }

    @GetMapping("/{id}/details")
    public ProductWithCategoryDTO getProductWithCategory(@PathVariable Long id){
        return productService.getProductWithCategory(id);
    }
}

