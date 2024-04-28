package com.hopsterth.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

import com.hopsterth.apigateway.service.ServiceDiscoveryService;

@RestController
public class ApiGatewayController {

    private final ServiceDiscoveryService serviceDiscoveryService;

    public ApiGatewayController(ServiceDiscoveryService serviceDiscoveryService) {
        this.serviceDiscoveryService = serviceDiscoveryService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<String> api() {
        return ResponseEntity.ok("Hello from API Gateway!");
    }

    @GetMapping(value = "/userservice")
    public ResponseEntity<String> userServicServerResponse() {
        String serviceUrl = serviceDiscoveryService.discoverService("UserService");
        return ResponseEntity.ok("UserService URL: " + serviceUrl);
    }
}
