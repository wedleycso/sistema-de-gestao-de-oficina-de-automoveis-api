package com.developer.sistema_de_gestao_de_oficina_de_automoveis.service;

import com.developer.sistema_de_gestao_de_oficina_de_automoveis.model.Client;
import com.developer.sistema_de_gestao_de_oficina_de_automoveis.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client findById(Long id) {
        Optional<Client> client = this.clientRepository.findById(id);
        return client.orElseThrow(() -> new RuntimeException(
                "Cliente não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()
        ));
    }

    @Transactional
    public Client create(Client client) {
        client.setId(null);
        return this.clientRepository.save(client);
    }

    @Transactional
    public Client update(Client client) {
        Client newClient = findById(client.getId());
        newClient.setName(client.getName());
        newClient.setEmail(client.getEmail());
        newClient.setPhone(client.getPhone());
        
        // Se houver novos veículos, atualiza a referência do cliente em cada um
        if (client.getVehicles() != null) {
            newClient.getVehicles().clear();
            client.getVehicles().forEach(vehicle -> {
                vehicle.setClient(newClient);
                newClient.getVehicles().add(vehicle);
            });
        }
        
        return this.clientRepository.save(newClient);
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        try {
            this.clientRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Erro ao excluir esse cliente, pois há entidades relacionadas!");
        }
    }
}
