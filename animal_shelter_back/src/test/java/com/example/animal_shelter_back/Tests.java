package com.example.animal_shelter_back;

import com.example.animal_shelter_back.model.Pet;
import com.example.animal_shelter_back.model.Species;
import com.example.animal_shelter_back.repo.IPetRepo;
import com.example.animal_shelter_back.repo.ISpeciesRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class Tests {
    @Autowired private IPetRepo petRepo;
    @Autowired private ISpeciesRepo speciesRepo;

    @Test
    public void testSpeciesSaveAndFind() {
        petRepo.deleteAll();
        speciesRepo.deleteAll();

        Species krowa = new Species();
        krowa.setName("Krowa");
        speciesRepo.save(krowa);

        Species found = speciesRepo.findById(krowa.getId()).orElse(null);
        assertEquals("Krowa", found.getName());
    }

    @Test
    public void testPetSaveAndSpeciesRelation() {
        speciesRepo.deleteAll();
        petRepo.deleteAll();

        Species pies = new Species();
        pies.setName("Pies");
        speciesRepo.save(pies);

        Pet burek = new Pet();
        burek.setName("Burek");
        burek.setActive(5);
        burek.setFriendly(6);
        burek.setHealth(9);
        burek.setSpecies(pies);
        petRepo.save(burek);

        Pet found = petRepo.findById(burek.getId()).orElse(null);
        assertEquals("Pies", found.getSpecies().getName());
    }



}

