package com.example.weather.controller;

import com.example.weather.model.Weather;
import com.example.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    //    GET /weather/by-coord?lat=55.7558&lon=37.6176
    @GetMapping("/coord")
    public ResponseEntity<Weather> getWeather(@RequestParam double lat, @RequestParam double lon) {
        return weatherService.getWeatherByCoordinates(lat, lon).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
