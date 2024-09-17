package com.example.loadtester;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newHttpClient;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@Slf4j
public class LoadTesterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadTesterApplication.class, args);
    }

    private final int numberOfCalls = 1000;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            try {
                StopWatch sw = new StopWatch();
                var i = 0;


                sw.start("FeignClient");
                i = 0;
                while (i < numberOfCalls) {
                    fetchProducts("FeignClient",8000);
                    i++;
                }
                sw.stop();


                sw.start("WebClient");
                i = 0;
                while (i < numberOfCalls) {
                    fetchProducts("WebClient",9000);
                    i++;
                }
                sw.stop();


                log.info(sw.prettyPrint());
            } catch (Exception e){
                log.error("Error starting up the application.",e);
            }
        };
    }


    public void fetchProducts(String clientType, int port) throws InterruptedException, URISyntaxException, IOException {
        long start = System.currentTimeMillis();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:"+port+"/"))
                .GET()
                .build();
        HttpResponse<String> response = newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        log.info("{}({}) : {}",clientType,System.currentTimeMillis()-start, response.body());
    }

}
