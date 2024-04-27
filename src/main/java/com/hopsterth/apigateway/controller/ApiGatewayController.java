package com.hopsterth.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.hopsterth.apigateway.service.ServiceDiscoveryService;

@RestController
public class ApiGatewayController {

    private final ServiceDiscoveryService serviceDiscoveryService;

    @Autowired
    public ApiGatewayController(ServiceDiscoveryService serviceDiscoveryService) {
        this.serviceDiscoveryService = serviceDiscoveryService;
    }

    @GetMapping("/")
    public ServerResponse api(ServerRequest request) {
        return ServerResponse.ok()
            .contentType(MediaType.TEXT_PLAIN)
            .body("Hello from API Gateway!");
    }

    @GetMapping("/user")
    public ServerResponse userServicServerResponse(ServerRequest request) {
        String serviceUrl = serviceDiscoveryService.discoverService("UserService");
        return ServerResponse.ok()
            .contentType(MediaType.TEXT_PLAIN)
            .body("UserService 1 URL: " + serviceUrl);
    }
}
