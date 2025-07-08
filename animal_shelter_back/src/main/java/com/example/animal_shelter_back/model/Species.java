package com.example.animal_shelter_back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Species {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
