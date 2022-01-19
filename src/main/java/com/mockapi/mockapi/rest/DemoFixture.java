package com.mockapi.mockapi.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DemoFixture
{
    private Long homeTeamId;
    private Long awayTeamId;
    private String start;
    private long fixtureId;
}
