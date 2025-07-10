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

    public int getScore() {
        return active + friendly - health;
    }

    public double getMatchScore(int idealActive, int idealFriendly, int idealHealth) {
        double activeDiff = Math.abs(active - idealActive);
        double friendlyDiff = Math.abs(friendly - idealFriendly);
        double healthDiff = Math.abs(health - idealHealth);

        return 10 - (activeDiff + friendlyDiff + healthDiff) / 3.0;
    }
}
