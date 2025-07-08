package com.example.animal_shelter_back.model;

import com.example.animal_shelter_back.model.Species;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Pet {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Species species;

    private int active;

    private int friendly;

    private int health;
}
