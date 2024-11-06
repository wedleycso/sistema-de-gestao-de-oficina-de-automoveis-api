package com.developer.sistema_de_gestao_de_oficina_de_automoveis.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = Service.TABLE_NAME)
public class Service {
    public static final String TABLE_NAME = "service";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "description", nullable = false)
    @NotNull
    @NotEmpty
    private String description;

    @Column(name = "price", nullable = false)
    @NotNull
    @Positive
    private Double price;

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDate date;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    // Getters e Setters

}