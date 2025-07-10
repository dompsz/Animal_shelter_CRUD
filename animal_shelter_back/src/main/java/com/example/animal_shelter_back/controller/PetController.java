package com.example.animal_shelter_back.controller;

import com.example.animal_shelter_back.model.Pet;
import com.example.animal_shelter_back.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> getPets() {
        return petService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable Long id) {
        Optional<Pet> pet = petService.getById(id);
        return pet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pet createPet(@RequestBody Pet pet) {
        return petService.save(pet);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Pet> deletePet(@PathVariable Long id) {
        Optional<Pet> pet = petService.delete(id);
        return pet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/adoptions")
    public List<Pet> getPetsSortedByScore() {
        List<Pet> pets = petService.getAll();
        pets.sort((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));
        return pets;
    }

    @GetMapping("/match")
    public List<Pet> getMatchedPets(
            @RequestParam int idealActive,
            @RequestParam int idealFriendly,
            @RequestParam int idealHealth) {

        List<Pet> pets = petService.getAll();

        pets.sort((p1, p2) -> {
            double score1 = p1.getMatchScore(idealActive, idealFriendly, idealHealth);
            double score2 = p2.getMatchScore(idealActive, idealFriendly, idealHealth);
            return Double.compare(score2, score1);
        });

        return pets;
    }
}