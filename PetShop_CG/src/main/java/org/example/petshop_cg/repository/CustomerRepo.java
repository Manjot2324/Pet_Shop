package org.example.petshop_cg.repository;

import org.example.petshop_cg.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    List<Customer> findById(int id);
}
