package com.example.EcommerceUpdated.gateway.api;

import com.example.EcommerceUpdated.dtos.FakeStoreProductResponseDTO;
import com.example.EcommerceUpdated.dtos.ProductDTO;
import com.example.EcommerceUpdated.gateway.IProductGateway;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ProductGateway implements IProductGateway {
    private final FakeStoreProductGateway fakeStoreProductGateway;

    public ProductGateway(FakeStoreProductGateway fakeStoreProductGateway) {
        this.fakeStoreProductGateway = fakeStoreProductGateway;
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
       FakeStoreProductResponseDTO response =
               fakeStoreProductGateway.getSingleProduct(id).execute().body();
       if(response == null) {
           throw new IOException("Product with id " + id + " not found" );
       }
       return ProductDTO.builder()
               .build();
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String cat_name) throws IOException {
        List<FakeStoreProductResponseDTO> result =
                fakeStoreProductGateway
                .getAllProductsByCategory(cat_name).execute().body();
        if(result == null || result.isEmpty()){
            throw new IOException("products in this category not found");
        }

        return result.stream().map(product -> ProductDTO.builder()
                .build())
                .toList();
    }
}
