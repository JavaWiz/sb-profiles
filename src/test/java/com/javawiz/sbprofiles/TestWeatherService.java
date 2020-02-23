package com.javawiz.sbprofiles;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("raining")
public class TestWeatherService {

    @Autowired
    WeatherService weatherService;

    @Test
    public void testDefaultProfile() {
        String output = weatherService.forecast();
        assertThat(output).contains("Today is raining day!");
    }
}