package com.nmsl.blockingapps;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class BlockingAppsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlockingAppsApplication.class, args);
    }

    private static final String DELAY_SERVICE_URL = "http://localhost:8080";

    private final RestTemplate client;

    public BlockingAppsApplication(RestTemplateBuilder builder){
        client = builder.rootUri(DELAY_SERVICE_URL).build();
    }

    @GetMapping("/hello")
    public JsonNode get(){
        JsonNode result = client.getForObject("/super",JsonNode.class);
        String cacheResult = result.toString();
        System.out.println(cacheResult);
        return result;
    }
}

