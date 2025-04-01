package com.example.weather.repository;

import com.example.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather,Integer> {

    @Query("SELECT w FROM Weather w WHERE w.location.latitude = :lat AND w.location.longitude = :lon")
    Weather findByLocationCoordinates(@Param("lat") double latitude, @Param("lon") double longitude);
}
