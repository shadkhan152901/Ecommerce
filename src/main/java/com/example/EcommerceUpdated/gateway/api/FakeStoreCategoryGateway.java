package com.example.EcommerceUpdated.gateway.api;

import com.example.EcommerceUpdated.dtos.FakeStoreCategoryResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface FakeStoreCategoryGateway {
    @GET("/products/categories")
    Call<List<String>> getCategories();
}
