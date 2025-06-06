package org.example.petshop_cg.repository;

import org.example.petshop_cg.entity.PetFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetFoodRepo extends JpaRepository<PetFood,Integer> {
}
