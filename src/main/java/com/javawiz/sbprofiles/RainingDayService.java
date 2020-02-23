package com.javawiz.sbprofiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("raining")
public class RainingDayService implements WeatherService {

    @Value("${app.message}")
    private String message;

    @Override
    public String forecast() {
        return message;
    }
}