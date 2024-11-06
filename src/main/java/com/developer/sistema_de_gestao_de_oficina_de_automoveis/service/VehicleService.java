package com.developer.sistema_de_gestao_de_oficina_de_automoveis.service;

import com.developer.sistema_de_gestao_de_oficina_de_automoveis.model.Client;
import com.developer.sistema_de_gestao_de_oficina_de_automoveis.model.Vehicle;
import com.developer.sistema_de_gestao_de_oficina_de_automoveis.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    
    @Autowired
    private ClientService clientService;

    public Vehicle findById(Long id) {
        Optional<Vehicle> vehicle = this.vehicleRepository.findById(id);
        return vehicle.orElseThrow(() -> new RuntimeException(
                "Veículo não encontrado! Id: " + id + ", Tipo: " + Vehicle.class.getName()
        ));
    }

    @Transactional
    public Vehicle create(Vehicle vehicle) {
        // Verifica se o cliente existe
        Client client = clientService.findById(vehicle.getClient().getId());
        vehicle.setId(null);
        vehicle.setClient(client);
        
        // Inicializa a lista de serviços se necessário
        if (vehicle.getServices() != null) {
            vehicle.getServices().forEach(service -> service.setVehicle(vehicle));
        }
        
        return this.vehicleRepository.save(vehicle);
    }
} 