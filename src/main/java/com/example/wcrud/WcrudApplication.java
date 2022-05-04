package com.example.wcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class WcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(WcrudApplication.class, args);
    }

}
