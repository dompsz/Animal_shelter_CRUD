package com.example.animal_shelter_back.service;

import com.example.animal_shelter_back.model.Pet;
import com.example.animal_shelter_back.repo.IPetRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private IPetRepo petRepo;

    public PetService(IPetRepo petRepo) {
        this.petRepo = petRepo;
    }

    public List<Pet> getAll() {
        return petRepo.findAll();
    }

    public Pet save(Pet pet) {
        return petRepo.save(pet);
    }

    public Optional<Pet> getById(Long id) {
        return petRepo.findById(id);
    }

    public Optional<Pet> delete(Long id) {
        Optional<Pet> pet = petRepo.findById(id);
        pet.ifPresent(petRepo::delete);
        return pet;
    }
}
