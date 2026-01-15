package com.example.EcommerceUpdated.configuration;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

@Component
public class APIConfig {
    private final String storeBaseURL;

    public APIConfig(){
        Dotenv dotenv = Dotenv.load();
        this.storeBaseURL=dotenv.get("FAKE_STORE_API_URL");
    }

    public String getStoreBaseURL(){
        return storeBaseURL;
    }
}
