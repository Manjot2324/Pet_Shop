
package org.example.petshop_cg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "pet_food")
public class PetFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodId;

    private String name;
    private String brand;
    private String type;
    private Integer quantity;
    private BigDecimal price;

    @ManyToMany(mappedBy = "petFoods")
    private Set<Pet> pets;

    // Getters and setters...
}
