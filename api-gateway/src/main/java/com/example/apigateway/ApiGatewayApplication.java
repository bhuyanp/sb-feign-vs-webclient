package com.example.apigateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }



    @Value("${eureka.client.serviceUrl.defaultZone}")
    private String discoveryServerUrl;
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("DISCOVERY URL: "+discoveryServerUrl);
        };
    }
}
