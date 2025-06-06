
package org.example.petshop_cg.entity;

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
    @JsonIgnore
    private Set<Pet> pets;

    @Override
    public int hashCode() {
        return Objects.hash(foodId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PetFood)) return false;
        PetFood petFood = (PetFood) o;
        return Objects.equals(foodId, petFood.foodId);
    }

    // Getters and setters...
}
