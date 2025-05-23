package com.spring.prod;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/forecast")
    public String getWeatherForecast(
            @RequestParam(defaultValue = "47.6062") double latitude,
            @RequestParam(defaultValue = "-122.3321") double longitude) {
        return weatherService.getWeatherForecastByLocation(latitude, longitude);
    }

    @GetMapping("/alerts")
    public String getWeatherAlerts(@RequestParam(defaultValue = "NY") String state) {
        return weatherService.getAlerts(state);
    }
}