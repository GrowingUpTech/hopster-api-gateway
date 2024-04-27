package com.hopsterth.apigateway.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceDiscoveryService {

    public String discoverService(String serviceName) {
        // Service discovery logic here
        if ("UserService".equals(serviceName)) {
            return "http://UserService.example.com";
        } 
        return null; // Return null if service not found
    }
}