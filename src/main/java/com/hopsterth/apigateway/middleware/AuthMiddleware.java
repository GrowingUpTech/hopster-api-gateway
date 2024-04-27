package com.hopsterth.apigateway.middleware;

import org.springframework.stereotype.Component;

@Component
public class AuthMiddleware {

    public boolean authenticateRequest(String authToken) {
        // Authentication logic here
        return true; // Return true if authentication succeeds, false otherwise
    }
}
