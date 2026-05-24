package com.generation.aerolineaapi.controller;

import com.generation.aerolineaapi.model.Pasajero;
import com.generation.aerolineaapi.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pasajeros")
public class PasajeroController {
    private final PasajeroService pasajeroService;

    @Autowired
    public PasajeroController(PasajeroService pasajeroService) {
        this.pasajeroService = pasajeroService;
    }

    @GetMapping
    public ResponseEntity<List<Pasajero>> getAllPasajeros() {
        return ResponseEntity.ok(pasajeroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pasajero> getPasajeroById(@PathVariable Long id) {
        Pasajero pasajero = pasajeroService.findById(id);
        if (pasajero == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pasajero);
    }

    @PostMapping
    public ResponseEntity<Pasajero> createPasajero(@RequestBody Pasajero pasajero) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pasajeroService.save(pasajero));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pasajero> updatePasajero(@PathVariable Long id, @RequestBody Pasajero datos) {
        Pasajero actualizado = pasajeroService.update(id, datos);
        if (actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePasajero(@PathVariable Long id) {
        pasajeroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}