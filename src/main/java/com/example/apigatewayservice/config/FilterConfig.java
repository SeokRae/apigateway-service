package com.example.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

//@Configuration
public class FilterConfig {

    //    @Bean
    public RouteLocator gateWayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(predicateSpec -> predicateSpec.path("/user-service/**")
                        .filters(
                                gatewayFilterSpec ->
                                        gatewayFilterSpec
                                                .addRequestHeader("user-request", "user-request")
                                                .addResponseHeader("user-response", "user-response"))
                        .uri("http://localhost:8081")
                )
                .build();
    }
}
