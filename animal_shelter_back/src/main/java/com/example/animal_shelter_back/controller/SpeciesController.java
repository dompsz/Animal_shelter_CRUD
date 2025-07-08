package com.example.animal_shelter_back.controller;

import com.example.animal_shelter_back.model.Species;
import com.example.animal_shelter_back.service.SpeciesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/species")
public class SpeciesController {
    private SpeciesService speciesService;

    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @GetMapping
    public List<Species> getSpeciess() {
        return speciesService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Species> getSpecies(@PathVariable Long id) {
        Optional<Species> species = speciesService.getById(id);
        return species.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Species createSpecies(@RequestBody Species species) {
        return speciesService.save(species);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Species> deleteSpecies(@PathVariable Long id) {
        Optional<Species> species = speciesService.delete(id);
        return species.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
