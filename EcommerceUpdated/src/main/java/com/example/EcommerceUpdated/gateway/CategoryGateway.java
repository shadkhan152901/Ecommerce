package com.example.EcommerceUpdated.gateway;

import com.example.EcommerceUpdated.dtos.CategoryDTO;
import com.example.EcommerceUpdated.dtos.FakeStoreCategoryResponseDTO;
import com.example.EcommerceUpdated.gateway.api.FakeStoreCategoryGateway;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@Component
public class CategoryGateway implements ICategoryGateway{

    private final FakeStoreCategoryGateway fakeStoreCategoryGateway;

    public CategoryGateway(FakeStoreCategoryGateway fakeStoreCategoryGateway) {
        this.fakeStoreCategoryGateway = fakeStoreCategoryGateway;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<String> categories = fakeStoreCategoryGateway
                .getCategories().execute().body();
        if(categories ==  null || categories.isEmpty()){
            throw new IOException("Categories not found");
        }
        return categories.stream().map(category -> CategoryDTO.builder()
                .name(category)
                .build()).toList();
    }
}
