package com.example.erekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ErekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErekaServerApplication.class, args);
    }

}
