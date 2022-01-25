package com.mockapi.mockapi.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoIntegrationController
{

    private final DemoIntegrationService service;

    public DemoIntegrationController(
        final DemoIntegrationService service)
    {
        this.service = service;
    }

    @GetMapping(AppConstants.INTEGRATION_URL)
    public ResponseEntity callDemoAPI()
    {
        return ResponseEntity.ok(service.callDemoApi());
    }
}
