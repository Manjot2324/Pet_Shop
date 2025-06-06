
package org.example.petshop_cg.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
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
    private Set<Pet> pets;

    // Getters and setters...
}
