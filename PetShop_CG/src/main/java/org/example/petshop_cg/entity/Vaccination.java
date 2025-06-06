
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
@Table(name = "vaccinations")
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vaccinationId;

    private String name;
    private String description;
    private BigDecimal price;
    private Boolean available;

    @ManyToMany(mappedBy = "vaccinations")
    @JsonIgnore
    private Set<Pet> pets;

    // Getters and setters...

    @Override
    public int hashCode() {
        return Objects.hash(vaccinationId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vaccination)) return false;
        Vaccination vaccination = (Vaccination) o;
        return Objects.equals(vaccinationId, vaccination.vaccinationId);
    }
}
