package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("pistes", r -> r.path("/piste/**")
                        .uri("http://pistes:8075/"))
                .route("MicroserviceReclamation", r -> r.path("/Reclamation/**")
                        .uri("http://MicroserviceReclamation:8076/"))
                .route("courses", r -> r.path("/courses/**")
                        .uri("http://courses:8077/"))
                .route("MicroserviceSubscription", r -> r.path("/subscription/**")
                        .uri("http://MicroserviceSubscription:8082/"))
                .route(" MicroServiceteymour", r -> r.path("/Equipement/**")
                        .uri("http://MicroserviceEquipement:8074/"))
                .route("MicroserviceEnCommun", r -> r.path("/users/**", "/auth/**")
                        .uri("http://MicroserviceEnCommun:5000"))  //
                .build();


    }
}
