package org.example.petshop_cg.controller;

import org.example.petshop_cg.entity.Address;
import org.example.petshop_cg.entity.Customer;
import org.example.petshop_cg.entity.Employee;
import org.example.petshop_cg.entity.Pet;
import org.example.petshop_cg.repository.AddressRepo;
import org.example.petshop_cg.repository.CustomerRepo;
import org.example.petshop_cg.repository.EmployeeRepo;
import org.example.petshop_cg.repository.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

   @Autowired
   private EmployeeRepo employeeRepo;

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Integer id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Customer with ID " + id + " not found"));
    }

    @GetMapping("/customer")
    public List<Customer> findAlLCustmers(){
        return customerRepo.findAll();
    }



//Testing
    @GetMapping("/employee")
    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

}
