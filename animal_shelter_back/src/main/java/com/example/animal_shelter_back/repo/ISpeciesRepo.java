package com.example.animal_shelter_back.repo;

import com.example.animal_shelter_back.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISpeciesRepo extends JpaRepository<Species, Long> {
}
