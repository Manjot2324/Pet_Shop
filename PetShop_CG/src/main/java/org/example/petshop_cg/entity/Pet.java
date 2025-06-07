
package org.example.petshop_cg.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonBackReference
    private PetCategory category;

    @ManyToMany(mappedBy = "pets")
    @JsonIgnore
    private Set<Employee> employees;

    @ManyToMany
    @JoinTable(
        name = "pet_grooming_relationship",
        joinColumns = @JoinColumn(name = "pet_id"),
        inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    @JsonIgnore
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
    @JsonIgnore
    private Set<PetFood> petFoods;

    @ManyToMany
    @JoinTable(
        name = "pet_supplier_relationship",
        joinColumns = @JoinColumn(name = "pet_id"),
        inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )

    @JsonIgnore
    private Set<Supplier> suppliers;

    @OneToMany(mappedBy = "pet")
    @JsonIgnore
    private Set<Transaction> transactions;

    @Override
    public int hashCode() {
        return Objects.hash(petId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return Objects.equals(petId, pet.petId);
    }

}
