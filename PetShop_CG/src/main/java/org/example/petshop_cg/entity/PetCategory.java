
package org.example.petshop_cg.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pet_categories")
public class PetCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Pet> pets;

    // Getters and setters...
}
