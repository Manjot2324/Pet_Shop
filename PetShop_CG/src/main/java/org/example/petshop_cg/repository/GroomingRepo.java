package org.example.petshop_cg.repository;

import org.example.petshop_cg.entity.GroomingService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroomingRepo extends JpaRepository<GroomingService,Integer> {

}
