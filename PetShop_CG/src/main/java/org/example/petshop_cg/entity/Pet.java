
package org.example.petshop_cg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer petId;

    private String name;
    private String breed;
    private Integer age;
    private BigDecimal price;
    private String description;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private PetCategory category;

    @ManyToMany(mappedBy = "pets")
    private Set<Employee> employees;

    @ManyToMany
    @JoinTable(
        name = "pet_grooming_relationship",
        joinColumns = @JoinColumn(name = "pet_id"),
        inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<GroomingService> groomingServices;

    @ManyToMany
    @JoinTable(
        name = "pet_vaccination_relationship",
        joinColumns = @JoinColumn(name = "pet_id"),
        inverseJoinColumns = @JoinColumn(name = "vaccination_id")
    )
    private Set<Vaccination> vaccinations;

    @ManyToMany
    @JoinTable(
        name = "pet_food_relationship",
        joinColumns = @JoinColumn(name = "pet_id"),
        inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private Set<PetFood> petFoods;

    @ManyToMany
    @JoinTable(
        name = "pet_supplier_relationship",
        joinColumns = @JoinColumn(name = "pet_id"),
        inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private Set<Supplier> suppliers;

    @OneToMany(mappedBy = "pet")
    private Set<Transaction> transactions;

    // Getters and setters...
}
