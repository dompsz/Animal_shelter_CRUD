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
@ActiveProfiles("default")//#TODO CHANGE TO 'test' in prod !!!!!!!!!!
public class Generator {
    @Autowired private IPetRepo petRepo;
    @Autowired private ISpeciesRepo speciesRepo;

    private List<Species> savedSpecies;
    private List<Pet> savedPets;

    private void createSpecies() {
        savedSpecies = List.of("Pies", "Lew", "Kot", "Jeż")
                .stream()
                .map(name -> {
                    Species s = new Species();
                    s.setName(name);
                    return speciesRepo.save(s);
                })
                .toList();
    }

    private record PetData(String name, String speciesName) {}

    private Species findSpeciesByName(String name) {
        return savedSpecies.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Species not found: " + name));
    }

    private void createPets() {
        savedPets = new ArrayList<>();

        List.of(
                        new PetData("Fifa", "Pies"),
                        new PetData("Pestka", "Pies"),
                        new PetData("Perro de Cargador", "Pies"),
                        new PetData("Lewica", "Lew"),
                        new PetData("Bryszard", "Kot"),
                        new PetData("Lilo", "Kot"),
                        new PetData("Grochu", "Kot"),
                        new PetData("Misiek", "Kot"),
                        new PetData("Kitosław", "Kot"),
                        new PetData("Pan Jeżyk", "Jeż")
                ).stream()
                .map(data -> {
                    Pet p = new Pet();
                    p.setName(data.name());
                    p.setActive(ThreadLocalRandom.current().nextInt(1, 11));
                    p.setFriendly(ThreadLocalRandom.current().nextInt(1, 11));
                    p.setHealth(ThreadLocalRandom.current().nextInt(1, 11));
                    p.setSpecies(findSpeciesByName(data.speciesName()));
                    return petRepo.save(p);
                })
                .forEach(savedPets::add);
    }


    public void create_records() {
        createSpecies();
        createPets();
    }

    public void deleteAll() {
        petRepo.deleteAll();
        speciesRepo.deleteAll();
    }

    @Test
    public void creationTest() {
        deleteAll();
        create_records();
        assertEquals(4, speciesRepo.count());
        assertEquals(10, petRepo.count());
    }

}

