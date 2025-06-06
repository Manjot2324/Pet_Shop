
package org.example.petshop_cg.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;

    private String name;
    private String contactPerson;
    private String phoneNumber;
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(mappedBy = "suppliers")
    private Set<Pet> pets;

    // Getters and setters...
}
