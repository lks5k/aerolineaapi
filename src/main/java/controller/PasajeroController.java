package com.generation.aerolineaapi.controller;

import com.generation.aerolineaapi.model.Pasajero;
import com.generation.aerolineaapi.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Pasajero> getAllPasajeros() {
        return pasajeroService.findAll();
    }

    @PostMapping
    public Pasajero createPasajero(@RequestBody Pasajero pasajero) {
        return pasajeroService.save(pasajero);
    }
}