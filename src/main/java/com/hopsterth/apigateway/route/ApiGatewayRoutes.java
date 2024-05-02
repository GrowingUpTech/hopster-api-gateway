package com.hopsterth.apigateway.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;

import com.hopsterth.apigateway.controller.ApiGatewayController;
import com.hopsterth.apigateway.middleware.RouteMiddleware;


@Configuration
public class ApiGatewayRoutes {

    private final ApiGatewayController apiGatewayController;

    public ApiGatewayRoutes(ApiGatewayController apiGatewayController) {
        this.apiGatewayController = apiGatewayController;
    }

    @Bean
    public RouterFunction<?> routerFunction(ApiGatewayController apiGatewayController) {
        return RouterFunctions.route()
                .GET("/", apiGatewayController::api)
                .GET("/**", apiGatewayController::userServicServerResponse)
                .filter((request, next) -> {
                    // Add your filter logic here
                    return next.handle(request);
                })
                .build();
    }
    
}