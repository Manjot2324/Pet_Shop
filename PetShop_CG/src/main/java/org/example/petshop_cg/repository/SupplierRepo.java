package org.example.petshop_cg.repository;

import org.example.petshop_cg.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier,Integer> {
}
