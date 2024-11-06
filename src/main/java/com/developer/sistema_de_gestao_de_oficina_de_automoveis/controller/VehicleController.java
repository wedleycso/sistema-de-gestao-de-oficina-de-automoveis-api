package com.developer.sistema_de_gestao_de_oficina_de_automoveis.controller;

import com.developer.sistema_de_gestao_de_oficina_de_automoveis.model.Service;
import com.developer.sistema_de_gestao_de_oficina_de_automoveis.model.Vehicle;
import com.developer.sistema_de_gestao_de_oficina_de_automoveis.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/{id}/services")
    public ResponseEntity<List<Service>> findAllServicesByVehicleId(@PathVariable Long id) {
        Vehicle vehicle = this.vehicleService.findById(id);
        return ResponseEntity.ok().body(vehicle.getServices());
    }

    @PostMapping
    public ResponseEntity<Vehicle> create(@Valid @RequestBody Vehicle vehicle) {
        Vehicle newVehicle = this.vehicleService.create(vehicle);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newVehicle.getId())
                .toUri();
        return ResponseEntity.created(uri).body(newVehicle);
    }
}
