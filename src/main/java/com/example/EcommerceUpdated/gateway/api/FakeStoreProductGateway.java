package com.example.EcommerceUpdated.gateway.api;

import com.example.EcommerceUpdated.dtos.FakeStoreProductResponseDTO;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

@Component
public interface FakeStoreProductGateway {
    @GET("products/{id}")
    Call<FakeStoreProductResponseDTO> getSingleProduct(@Path("id") Long id);

    @GET("products/category/{cat_name}")
    Call<List<FakeStoreProductResponseDTO>> getAllProductsByCategory(@Path("cat_name") String cat_name);
}
