package com.arquitectura.tp.tpfinalgrupo7.service;

import com.arquitectura.tp.tpfinalgrupo7.model.Vuelo;
import com.arquitectura.tp.tpfinalgrupo7.repository.VueloRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueloServiceImpl implements VueloService{

    private final VueloRepository vueloRepository;

    @Autowired
    public VueloServiceImpl(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @Override
    public List<Vuelo> findAll() {
        return vueloRepository.findAll();
    }

    @Override
    public Vuelo findById(Integer id) {
        return vueloRepository.findById(id).orElse(new Vuelo());
    }

    @Override
    public Vuelo save(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    @Override
    public Vuelo update(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    @Override
    public void delete(Integer id) {
        vueloRepository.deleteById(id);
    }
}
