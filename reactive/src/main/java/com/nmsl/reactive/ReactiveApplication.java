package com.nmsl.reactive;

import com.nmsl.reactive.hello.GreetingWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveApplication.class, args);

        GreetingWebClient greetingWebClient = new GreetingWebClient();
        System.out.println(greetingWebClient.getResult());

    }

}

