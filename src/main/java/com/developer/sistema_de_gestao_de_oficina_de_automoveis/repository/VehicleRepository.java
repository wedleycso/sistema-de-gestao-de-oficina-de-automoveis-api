package com.developer.sistema_de_gestao_de_oficina_de_automoveis.repository;

import com.developer.sistema_de_gestao_de_oficina_de_automoveis.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
} 