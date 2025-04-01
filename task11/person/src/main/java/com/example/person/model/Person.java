package com.example.person.model;

import com.example.location.model.Location;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue
    private int id;

    @NonNull private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    @NonNull private Location location;

    public Person(@NonNull String name, @NonNull Location location) {
        this.name = name;
        this.location = location;
    }


    public int getId() {
        return id;
    }
}