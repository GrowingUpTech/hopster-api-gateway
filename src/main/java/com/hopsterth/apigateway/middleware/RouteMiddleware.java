package com.hopsterth.apigateway.middleware;

import org.springframework.stereotype.Component;

@Component
public class RouteMiddleware {

    public String determineRoute(String path) {
        // Routing logic here
        if (path.startsWith("/service1")) {
            return "service1";
        } else if (path.startsWith("/service2")) {
            return "service2";
        }
        return null; // Return null if no route matches
    }
}