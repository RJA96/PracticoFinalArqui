package com.arquitectura.tp.tpfinalgrupo7.service;

import com.arquitectura.tp.tpfinalgrupo7.model.Plan;
import com.arquitectura.tp.tpfinalgrupo7.model.Viaje;
import com.arquitectura.tp.tpfinalgrupo7.repository.ViajeRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViajeServiceImpl implements ViajeService {

    private ViajeRepository viajeRepository;

    @Autowired
    public ViajeServiceImpl(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    @Override
    public List<Viaje> findAll() {
        List<Viaje> all = viajeRepository.findAll();
        return all;
    }

    @Override
    public Viaje findById(Integer id) {
        return viajeRepository.findById(id).orElse(new Viaje());
    }

    @Override
    public Viaje save(Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    @Override
    public Viaje update(Viaje viaje) {
        Viaje one = viajeRepository.getOne(viaje.getIdViaje());
        if(Objects.nonNull(one)) {
            one.setNombre(viaje.getNombre());
            one.setDestino(viaje.getDestino());
            one.setVuelta(viaje.getVuelta());
            one.setIda(viaje.getIda());
            one.setVuelos(viaje.getPlanes());
            one.setDescripcion(viaje.getDescripcion());
            return viajeRepository.save(one);
        }
        throw new IllegalArgumentException("El id del viaje no existe");
    }

    @Override
    public void delete(Integer id) {
        viajeRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer idViaje) {
        return viajeRepository.existsById(idViaje);
    }

    @Override
    public List<Plan> findPlanesByViajeId(Integer id) {
        return this.viajeRepository.findById(id).orElse(new Viaje()).getPlanes();
    }
}
