package com.mockapi.mockapi.rest;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DemoFixtureService
{
    public List<DemoFixture> getFixtureList()
    {
        return Arrays.asList(
            new DemoFixture[]{
                new DemoFixture(1L, 2L, "12:00 12-02-2022", 1001L),
                new DemoFixture(879L, 21L, "12:00 199-02-2022", 3021L),
                new DemoFixture(44L, 22L, "12:00 15-02-2022", 7777L),
                new DemoFixture(21L, 90L, "12:00 13-02-2022", 2351L)
            });
    }
}
