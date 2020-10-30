package com.arquitectura.tp.tpfinalgrupo7.controller;

import com.arquitectura.tp.tpfinalgrupo7.model.Vuelo;
import com.arquitectura.tp.tpfinalgrupo7.service.VueloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Vuelo> findAll() {
        return vueloService.findAll();
    }

    @GetMapping("/id")
    public Vuelo findById(@RequestParam("id") Integer id) {
        return vueloService.findById(id);
    }

    @PostMapping
    public Vuelo save(@RequestBody Vuelo vuelo) {
        return vueloService.save(vuelo);
    }

    @PutMapping
    public Vuelo update(@RequestBody Vuelo vuelo) {
        return vueloService.update(vuelo);
    }

    @DeleteMapping
    public void delete(@RequestParam("id") Integer id) {
        vueloService.delete(id);
    }
}

