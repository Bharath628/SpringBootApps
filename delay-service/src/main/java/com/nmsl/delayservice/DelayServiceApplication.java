package com.nmsl.delayservice;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;

@RestController
@SpringBootApplication
public class DelayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DelayServiceApplication.class, args);

    }

    @GetMapping("/super")
    public User get(){
       User user = new User();
       user.setName("Bharath");
       user.setAge("98");
       user.setDepartment("Chemistry");
       user.setDate(LocalDateTime.now());
       return user;
    }

}

