package com.example.weather.model;

//import com.example.location.model.Location;

import lombok.*;

@AllArgsConstructor
@Data
public class Weather{
    private int id;
    private String main;
    private String description;
    private String icon;
}