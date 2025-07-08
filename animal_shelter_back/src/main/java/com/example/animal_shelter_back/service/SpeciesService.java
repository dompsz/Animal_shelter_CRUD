package com.example.animal_shelter_back.service;

import com.example.animal_shelter_back.model.Species;
import com.example.animal_shelter_back.repo.ISpeciesRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeciesService {
    private ISpeciesRepo speciesRepo;

    public SpeciesService(ISpeciesRepo speciesRepo) {
        this.speciesRepo = speciesRepo;
    }

    public List<Species> getAll() {
        return speciesRepo.findAll();
    }

    public Species save(Species species) {
        return speciesRepo.save(species);
    }

    public Optional<Species> getById(Long id) {
        return speciesRepo.findById(id);
    }

    public Optional<Species> delete(Long id) {
        Optional<Species> species = speciesRepo.findById(id);
        species.ifPresent(speciesRepo::delete);
        return species;
    }
}
