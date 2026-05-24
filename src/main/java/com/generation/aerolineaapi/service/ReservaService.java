package com.generation.aerolineaapi.service;

import com.generation.aerolineaapi.dto.ReservaRequestDTO;
import com.generation.aerolineaapi.dto.ReservaResponseDTO;
import com.generation.aerolineaapi.model.Reserva;
import com.generation.aerolineaapi.repository.PasajeroRepository;
import com.generation.aerolineaapi.repository.ReservaRepository;
import com.generation.aerolineaapi.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final PasajeroRepository pasajeroRepository;
    private final VueloRepository vueloRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository,
                          PasajeroRepository pasajeroRepository,
                          VueloRepository vueloRepository) {
        this.reservaRepository = reservaRepository;
        this.pasajeroRepository = pasajeroRepository;
        this.vueloRepository = vueloRepository;
    }

    public List<ReservaResponseDTO> findAll() {
        return reservaRepository.findAll()
                .stream()
                .map(ReservaResponseDTO::desde)
                .collect(Collectors.toList());
    }

    public ReservaResponseDTO findById(Long id) {
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if (reserva == null) return null;
        return ReservaResponseDTO.desde(reserva);
    }

    public ReservaResponseDTO save(ReservaRequestDTO dto) {
        Reserva reserva = new Reserva();
        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setClase(dto.getClase());
        reserva.setPasajero(pasajeroRepository.findById(dto.getPasajeroId()).orElse(null));
        reserva.setVuelo(vueloRepository.findById(dto.getVueloId()).orElse(null));
        return ReservaResponseDTO.desde(reservaRepository.save(reserva));
    }

    public ReservaResponseDTO update(Long id, ReservaRequestDTO dto) {
        Reserva existente = reservaRepository.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setFechaReserva(dto.getFechaReserva());
        existente.setClase(dto.getClase());
        existente.setPasajero(pasajeroRepository.findById(dto.getPasajeroId()).orElse(null));
        existente.setVuelo(vueloRepository.findById(dto.getVueloId()).orElse(null));
        return ReservaResponseDTO.desde(reservaRepository.save(existente));
    }

    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }
}