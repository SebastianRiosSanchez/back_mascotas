package com.petshop.tienda.controllers;

import com.petshop.tienda.models.Cliente;
import com.petshop.tienda.models.Historia;
import com.petshop.tienda.services.HistoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/historia")
public class HistoriaController {

    @Autowired
    private HistoriaService historiaService;

    //post
    @PostMapping
    public Historia crearHistoria(@RequestBody Historia nuevaHistoria) {
        return historiaService.crearHistoria(nuevaHistoria);
    }

    //Get
    @GetMapping
    public List<Historia> obtTodasHistorias() {
        return historiaService.obtHistoria();
    }

    //Get X Id
    @GetMapping("/{id}")
    public Optional<Historia> obtHistoriaXId(@PathVariable("id") Long id) {
        return historiaService.obtHistoriaXId(id);
    }

    //Put
    @PutMapping("/{id}")
    public Historia actHistoria(@PathVariable("id") Long id, @RequestBody Historia historia) {
        return historiaService.actHistoria(id, historia);
    }

    //Delete
    @DeleteMapping("/{id}")
    public void eliminarHistoria(@PathVariable("id") Long id) {
        historiaService.eliminarHistoria(id);
    }

}
