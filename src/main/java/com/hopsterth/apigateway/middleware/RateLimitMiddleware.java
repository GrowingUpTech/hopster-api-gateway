package com.hopsterth.apigateway.middleware;

import java.util.concurrent.TimeUnit;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

@Component
public class RateLimitMiddleware {

    private final RateLimiter rateLimiter = RateLimiter.create(10); // Allow 10 requests per second

    public boolean allowRequest() {
        // Rate limiting logic here
        return rateLimiter.tryAcquire();
    }
}