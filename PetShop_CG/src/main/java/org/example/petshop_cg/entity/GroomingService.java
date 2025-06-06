
package org.example.petshop_cg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "grooming_services")
public class GroomingService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;

    private String name;
    private String description;
    private BigDecimal price;
    private Boolean available;

    @ManyToMany(mappedBy = "groomingServices")
    private Set<Pet> pets;

    // Getters and setters...
}
