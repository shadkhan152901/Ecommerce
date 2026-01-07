package com.example.EcommerceUpdated.configuration;

import com.example.EcommerceUpdated.gateway.api.FakeStoreCategoryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Bean
    public Retrofit retrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    @Bean
    public FakeStoreCategoryGateway fakeStoreCategoryGateway(Retrofit retrofit){
      return retrofit.create(FakeStoreCategoryGateway.class);
    }

}
