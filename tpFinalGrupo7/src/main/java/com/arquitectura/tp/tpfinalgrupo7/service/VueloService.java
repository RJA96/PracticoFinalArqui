package com.arquitectura.tp.tpfinalgrupo7.service;

import com.arquitectura.tp.tpfinalgrupo7.model.Vuelo;
import java.util.List;

public interface VueloService {
    List<Vuelo> findAll();
    Vuelo findById(Integer id);
    Vuelo save(Vuelo vuelo);
    Vuelo update(Vuelo vuelo);
    void delete(Integer id);
}
