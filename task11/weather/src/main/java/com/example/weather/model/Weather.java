package com.example.weather.model;

import com.example.location.model.Location;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Weather {
    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private double temperature;
    @NonNull
    private double speedWind;
    @NonNull
    private double wetness;

    @OneToOne(cascade = CascadeType.ALL)
    @NonNull private Location location;

    @NonNull
    private WeatherCondition condition;


    public Weather(@NonNull double temperature, @NonNull double speedWind, @NonNull double wetness, @NonNull Location location, @NonNull WeatherCondition condition ) {
        this.temperature=temperature;
        this.speedWind=speedWind;
        this.wetness=wetness;
        this.location=location;
        this.condition=condition;
    }
}
