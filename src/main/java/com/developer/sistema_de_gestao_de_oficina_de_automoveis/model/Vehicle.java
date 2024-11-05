package com.developer.sistema_de_gestao_de_oficina_de_automoveis.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = Vehicle.TABLE_NAME)
public class Vehicle {
    public static final String TABLE_NAME = "vehicle";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "model", nullable = false, length = 254)
    @NotNull
    @NotEmpty
    private String model;

    @Column(name = "year", nullable = false)
    @NotNull
    private Integer year;

    @Column(name = "licensePlate", nullable = false, length = 10)
    @NotNull
    @NotEmpty
    private String licensePlate;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Service> services;

    // Getters e Setters

}