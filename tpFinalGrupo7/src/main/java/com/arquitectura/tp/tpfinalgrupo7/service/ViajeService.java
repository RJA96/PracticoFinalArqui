package com.arquitectura.tp.tpfinalgrupo7.service;

import com.arquitectura.tp.tpfinalgrupo7.model.Plan;
import com.arquitectura.tp.tpfinalgrupo7.model.Viaje;
import java.util.List;

public interface ViajeService {
    List<Viaje> findAll();
    Viaje findById(Integer id);
    Viaje save(Viaje viaje);
    Viaje update(Viaje viaje);
    void delete(Integer id);
    boolean existsById(Integer idViaje);
    List<Plan> findPlanesByViajeId(Integer id);
}
