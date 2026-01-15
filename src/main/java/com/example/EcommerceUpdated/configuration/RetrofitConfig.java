package com.example.EcommerceUpdated.configuration;

import com.example.EcommerceUpdated.gateway.api.FakeStoreCategoryGateway;
import com.example.EcommerceUpdated.gateway.api.FakeStoreProductGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    private final APIConfig apiConfig;

    public RetrofitConfig(APIConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    @Bean
    public Retrofit retrofit(){
        return new Retrofit.Builder()
                .baseUrl(apiConfig.getStoreBaseURL() + "/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    @Bean
    public FakeStoreCategoryGateway fakeStoreCategoryGateway(Retrofit retrofit){
      return retrofit.create(FakeStoreCategoryGateway.class);
    }
    @Bean
    public FakeStoreProductGateway fakeStoreProductGateway(Retrofit retrofit){
        return retrofit.create(FakeStoreProductGateway.class);
    }

}
