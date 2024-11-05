package com.developer.sistema_de_gestao_de_oficina_de_automoveis.service;

import com.developer.sistema_de_gestao_de_oficina_de_automoveis.model.Client;
import com.developer.sistema_de_gestao_de_oficina_de_automoveis.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client findById(Long id) {
        Optional<Client> client = this.clientRepository.findById(id);
        return client.orElseThrow(() -> new RuntimeException(
                "Usuário não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()
        ));
    }

    @Transactional
    public Client create(Client client) {
        client.setId(null);
        client = this.clientRepository.save(client);
        this.clientRepository.saveAll(client.getName());
        return client;
    }

    @Transactional
    public Client update(Client client) {
        Client newClient = findById(client.getId());
        newClient.setName(client.getName());
        newClient.setEmail(client.getEmail());
        newClient.setPhone(client.getPhone());
        newClient.setVehicles(client.getVehicles());
        return this.clientRepository.save(newClient);
    }

    public void delete(Long id) {
        findById(id);
        try{
            this.clientRepository.deleteById(id);
        }  catch (Exception e){
            throw new RuntimeException("Erro ao excluir esse cliente pois há entidades relacionadas!");
        }
    }
}
