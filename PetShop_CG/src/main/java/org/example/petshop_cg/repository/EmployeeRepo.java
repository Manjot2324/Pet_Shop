package org.example.petshop_cg.repository;

import jdk.jfr.Registered;
import org.example.petshop_cg.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
