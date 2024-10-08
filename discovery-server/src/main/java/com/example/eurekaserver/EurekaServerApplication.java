package com.example.eurekaserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
    @Value("${eureka.client.serviceUrl.defaultZone}")
    private String discoveryServerUrl;
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            log.info("DISCOVERY URL: {}",discoveryServerUrl);
        };
    }
}
