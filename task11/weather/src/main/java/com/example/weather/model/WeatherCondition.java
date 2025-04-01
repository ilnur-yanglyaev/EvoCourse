package com.example.weather.model;

public enum WeatherCondition {
    SUNNY("Sunny"),
    CLOUDY("Cloudy"),
    RAINY("Rainy"),
    SNOWY("Snowy"),
    THUNDERSTORM("Thunderstorm"),
    FOGGY("Foggy"),
    WINDY("Windy"),
    PARTLY_CLOUDY("Partly Cloudy");

    private final String displayName;

    WeatherCondition(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
