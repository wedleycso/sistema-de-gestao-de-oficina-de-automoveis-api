package com.developer.sistema_de_gestao_de_oficina_de_automoveis.repository;

import com.developer.sistema_de_gestao_de_oficina_de_automoveis.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByName(String name);
}
