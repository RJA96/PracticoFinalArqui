package com.arquitectura.tp.tpfinalgrupo7.controller;

import com.arquitectura.tp.tpfinalgrupo7.model.Vuelo;
import com.arquitectura.tp.tpfinalgrupo7.service.VueloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/vuelo")
public class VueloController {

    private final VueloService vueloService;

    @Autowired
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Vuelo> findAll() {
        return vueloService.findAll();
    }

    @GetMapping("/id")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Vuelo findById(@RequestParam("id") Integer id) {
        return vueloService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Vuelo save(@RequestBody Vuelo vuelo) {
        return vueloService.save(vuelo);
    }

    @PutMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Vuelo update(@RequestBody Vuelo vuelo) {
        return vueloService.update(vuelo);
    }

    @DeleteMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void delete(@RequestParam("id") Integer id) {
        vueloService.delete(id);
    }
}

