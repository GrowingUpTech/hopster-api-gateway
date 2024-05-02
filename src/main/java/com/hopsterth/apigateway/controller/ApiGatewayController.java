package com.hopsterth.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

import com.hopsterth.apigateway.service.ServiceDiscoveryService;
import com.hopsterth.apigateway.middleware.RouteMiddleware;

@RestController
public class ApiGatewayController {

    private final ServiceDiscoveryService serviceDiscoveryService;
    private final RouteMiddleware routeMiddleware;

    @Autowired
    public ApiGatewayController(ServiceDiscoveryService serviceDiscoveryService, RouteMiddleware routeMiddleware) {
        this.serviceDiscoveryService = serviceDiscoveryService;
        this.routeMiddleware = routeMiddleware;
    }

    @GetMapping(value = "/")
    public ResponseEntity<String> api() {
        return ResponseEntity.ok("Hello from API Gateway!");
    }

    @GetMapping("/**")
    public ServerResponse userServicServerResponse(ServerRequest request) {
        String path = request.path();
        String service = routeMiddleware.determineRoute(path);
        if (service != null) {
            String serviceUrl = serviceDiscoveryService.discoverService(service);
            return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(service + " URL: " + serviceUrl);
        } else {
            return ServerResponse.notFound().build();
        }
    }
}

