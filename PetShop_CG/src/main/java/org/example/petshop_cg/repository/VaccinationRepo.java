package org.example.petshop_cg.repository;

import org.example.petshop_cg.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepo extends JpaRepository<Vaccination,Integer> {
}
