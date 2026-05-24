package com.generation.aerolineaapi.service;

import com.generation.aerolineaapi.model.Vuelo;
import com.generation.aerolineaapi.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VueloService {
    private final VueloRepository vueloRepository;

    @Autowired
    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    public List<Vuelo> findAll() {
        return vueloRepository.findAll();
    }

    public Vuelo save(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    public Vuelo findById(Long id) {
        return vueloRepository.findById(id).orElse(null);
    }

    public Vuelo update(Long id, Vuelo datos) {
        Vuelo existente = findById(id);
        if (existente == null) return null;
        existente.setOrigen(datos.getOrigen());
        existente.setDestino(datos.getDestino());
        existente.setFechaHora(datos.getFechaHora());
        existente.setEstado(datos.getEstado());
        return vueloRepository.save(existente);
    }

    public void delete(Long id) {
        vueloRepository.deleteById(id);
    }
}