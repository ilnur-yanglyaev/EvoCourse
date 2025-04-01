package com.example.weather.service;

import com.example.weather.model.Weather;
import com.example.weather.repository.WeatherRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }
//    public Weather saveWeather(Weather weather) {
//        return weatherRepository.save(weather);
//    }

    @Transactional(readOnly = true)
    public Optional<Weather> getWeatherByCoordinates(double lat, double lon) {
        return Optional.ofNullable(weatherRepository.findByLocationCoordinates(lat, lon));
    }

}
