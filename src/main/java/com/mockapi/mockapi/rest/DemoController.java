package com.mockapi.mockapi.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController("/demo")
public class DemoController
{
    private final DemoFixtureService demoFixtureService;
    @GetMapping("/demo/fixture")
    public ResponseEntity<List<DemoFixture>> getFixtureList(){
        return ResponseEntity.ok(demoFixtureService.getFixtureList());
    }
}
