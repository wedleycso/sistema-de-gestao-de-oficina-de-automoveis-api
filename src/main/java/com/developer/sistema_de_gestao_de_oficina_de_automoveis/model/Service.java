package com.developer.sistema_de_gestao_de_oficina_de_automoveis.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

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
    @NotEmpty
    private Double price;

    @Column(name = "date", nullable = false)
    @NotNull
    @NotEmpty
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    // Getters e Setters

}