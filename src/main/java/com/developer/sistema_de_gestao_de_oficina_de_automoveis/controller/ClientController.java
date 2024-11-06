package com.developer.sistema_de_gestao_de_oficina_de_automoveis.controller;

import com.developer.sistema_de_gestao_de_oficina_de_automoveis.model.Client;
import com.developer.sistema_de_gestao_de_oficina_de_automoveis.repository.CreateClient;
import com.developer.sistema_de_gestao_de_oficina_de_automoveis.repository.UpdateClient;
import com.developer.sistema_de_gestao_de_oficina_de_automoveis.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/client")
@Validated
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        Client client = this.clientService.findById(id);
        return ResponseEntity.ok().body(client);
    }

    @PostMapping
    @Validated(CreateClient.class)
    public ResponseEntity<Client> create(@Valid @RequestBody Client client) {
        this.clientService.create(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Validated(UpdateClient.class)
    public ResponseEntity<Void> update(@Valid @RequestBody Client client, @PathVariable Long id) {
        client.setId(id);
        this.clientService.update(client);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
