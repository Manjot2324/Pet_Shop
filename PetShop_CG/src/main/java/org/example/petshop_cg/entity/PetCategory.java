
package org.example.petshop_cg.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pet_categories")
public class PetCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String name;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private Set<Pet> pets;

    @Override
    public int hashCode() {
        return Objects.hash(categoryId); // Only use categoryId, not pets
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PetCategory)) return false;
        PetCategory category = (PetCategory) o;
        return Objects.equals(categoryId, category.categoryId);
        }
}
