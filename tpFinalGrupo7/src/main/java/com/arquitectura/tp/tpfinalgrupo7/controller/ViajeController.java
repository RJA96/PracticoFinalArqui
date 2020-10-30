package com.arquitectura.tp.tpfinalgrupo7.controller;

import com.arquitectura.tp.tpfinalgrupo7.model.Plan;
import com.arquitectura.tp.tpfinalgrupo7.model.Viaje;
import com.arquitectura.tp.tpfinalgrupo7.service.ViajeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("viaje")
@CrossOrigin
public class ViajeController {
    
    private ViajeService viajeService;

    @Autowired
    public ViajeController(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    @GetMapping
    public List<Viaje> findAll() {
        return viajeService.findAll();
    }

    @GetMapping("/id")
    public Viaje findById(@RequestParam("id") Integer id) {
        return viajeService.findById(id);
    }

    @PostMapping
    public Viaje save(@RequestBody Viaje viaje) {
        return viajeService.save(viaje);
    }

    @PutMapping
    public Viaje update(@RequestBody Viaje viaje) {
        return viajeService.update(viaje);
    }

    @DeleteMapping
    public void delete(@RequestParam("id") Integer id) {
        viajeService.delete(id);
    }

    @GetMapping("planes/viajeId")
    public List<Plan> getPlanesById(@RequestParam("viajeId") Integer id) {
        return this.viajeService.findPlanesByViajeId(id);
    }
}
