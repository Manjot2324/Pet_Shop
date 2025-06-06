package org.example.petshop_cg.repository;

import org.example.petshop_cg.entity.PetCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetCategoryRepo extends JpaRepository<PetCategory,Integer> {
}
