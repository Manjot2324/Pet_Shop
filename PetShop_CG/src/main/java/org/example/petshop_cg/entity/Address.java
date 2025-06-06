package org.example.petshop_cg.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;

    private String street;
    private String city;
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    // 🔗 One address can be used by many customers
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Customer> customers;

    // 🔗 One address can be used by many employees
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    // 🔗 One address can be used by many suppliers
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private Set<Supplier> suppliers;

}