package com.petshop.tienda.controllers;

import com.petshop.tienda.models.Mascota;
import com.petshop.tienda.services.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mascota")
@CrossOrigin(origins = {"http://localhost:4200"})
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    //Post
    @PostMapping
    public Mascota crearMascota(@RequestBody Mascota nuevaMascota) {
        return mascotaService.crearMascota(nuevaMascota);
    }

    //Get
    @GetMapping
    public List<Mascota> obtTodasMascotas() {
        return mascotaService.obtTodasMascotas();
    }

    //Get X id
    @GetMapping("/{id}")
    public Optional<Mascota> obtMascotaXId(@PathVariable("id") Long idMascota) {
        return mascotaService.obtMascotaXId(idMascota);
    }

    //Put
    @PutMapping("/{id}")
    public Mascota actMascota(@PathVariable("id") Long id, @RequestBody Mascota mascota) {
        return mascotaService.actMascota(id, mascota);
    }

}
