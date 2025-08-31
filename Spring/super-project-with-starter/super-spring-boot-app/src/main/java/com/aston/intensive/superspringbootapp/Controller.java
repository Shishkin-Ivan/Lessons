package com.aston.intensive.superspringbootapp;

import com.aston.intensive.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class Controller {

    private final WeatherService weatherService;

    public Controller(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String weather() {
        return weatherService.getTemperature();
    }
}
