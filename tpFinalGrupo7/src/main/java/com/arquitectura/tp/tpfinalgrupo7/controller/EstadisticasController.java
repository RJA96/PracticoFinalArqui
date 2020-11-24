package com.arquitectura.tp.tpfinalgrupo7.controller;

import com.arquitectura.tp.tpfinalgrupo7.model.Estadisticas;
import com.arquitectura.tp.tpfinalgrupo7.service.EstadisticasService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticasController {


    final EstadisticasService estadisticasService;

    @Autowired
    public EstadisticasController(EstadisticasService estadisticasService) {
        this.estadisticasService = estadisticasService;
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Estadisticas getAllEstadisticas(@PathVariable("userId") Integer id) {
        return estadisticasService.getAllEstadisticasByUserId(id);
    }

    @GetMapping("/kilometros-recorridos/{viajeId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public int getTraveledKmsByViaje(@PathVariable("viajeId") Integer id) {
        return estadisticasService.getTraveledKmsByViaje(id);
    }

    @GetMapping("/ciudades-visitadas/{viajeId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Set<String> getVisitedCities(@PathVariable("viajeId") Integer id) {
        return estadisticasService.getVisitedCitiesByViaje(id);
    }

    @GetMapping("/huella-carbono/{viajeId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Double getHuellaCarbono(@PathVariable("viajeId") Integer id) {
        return estadisticasService.getHuellaCarbono(id);
    }

    @GetMapping("/horas-vuelo/{viajeId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Long getHorasVuelo (@PathVariable("viajeId") Integer id) {
        return estadisticasService.getHorasVuelo(id);
    }

    @GetMapping("/paises-visitados/{viajeId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Set<String> getPaisesVisitados(@PathVariable("viajeId") Integer id) {
        return estadisticasService.getVisitedCountriesByViaje(id);
    }


}
