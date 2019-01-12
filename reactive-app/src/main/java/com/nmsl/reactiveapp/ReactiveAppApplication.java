package com.nmsl.reactiveapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@SpringBootApplication
public class ReactiveAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveAppApplication.class, args);
    }

    private static final String Delay_Service_Url = "http://localhost:8080";

    private static WebClient webClient = WebClient.create(Delay_Service_Url);

    @GetMapping("/{delayMillis}")
    public Mono<String> get(@PathVariable String delayMillis){
        return webClient.get()
                .uri("/"+delayMillis)
                .retrieve()
                .bodyToMono(String.class)
                .map(s -> "Reactive: " + s);
    }

}

