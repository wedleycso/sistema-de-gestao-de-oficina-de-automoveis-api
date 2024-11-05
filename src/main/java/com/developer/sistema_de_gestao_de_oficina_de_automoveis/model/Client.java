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
@Table(name = Client.TABLE_NAME)
public class Client {
    public static final String TABLE_NAME = "client";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    @NotNull
    @NotEmpty
    private String name;

    @Column(name = "email", nullable = false, length = 254)
    @NotNull
    @NotEmpty
    private String email;

    @Column(name = "phone", nullable = false, length = 15)
    @NotNull
    @NotEmpty
    private String phone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles;


}