package com.petshop.tienda.controllers;

import com.petshop.tienda.models.Medico;
import com.petshop.tienda.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medico")
@CrossOrigin(origins = {"http://localhost:4200"})
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    //Post
    @PostMapping
    public Medico crearMedico(@RequestBody Medico nuevoMedico) {
        return medicoService.crearMedico(nuevoMedico);
    }

    //get
    @GetMapping
    public List<Medico> obtTodosMedicos() {
        return medicoService.obtTodosMedicos();
    }

    //get x id
    @GetMapping("/{id}")
    public Optional<Medico> obtMedicoXId(@PathVariable("id") Long idMedico) {
        return medicoService.obtMedicoXId(idMedico);
    }

    //put
    @PutMapping("/{id}")
    public Medico actMedico(@PathVariable("id") Long id, @RequestBody Medico medico) {
        return medicoService.actMedico(id, medico);
    }

    //delete
    @DeleteMapping("/{id}")
    public void eliminaMedico(@PathVariable("id") Long id) {
        medicoService.eliminarMedico(id);
    }
}
