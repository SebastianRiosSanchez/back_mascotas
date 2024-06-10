package com.petshop.tienda.services;

import com.petshop.tienda.exceptions.MascotaException;
import com.petshop.tienda.models.Mascota;
import com.petshop.tienda.repositorys.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    //Crear una nueva mascota
    public Mascota crearMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    //Obtener todas las mascotas
    public List<Mascota> obtTodasMascotas() {
        return mascotaRepository.findAll();
    }

    //Obtener mascota por id
    public Optional<Mascota> obtMascotaXId(Long idMascota) {
        return mascotaRepository.findById(idMascota);
    }

    //Actualizar mascota
    public Mascota actMascota(@PathVariable Long id, @RequestBody Mascota nuevaMascota) {
        Optional<Mascota> encontrada = mascotaRepository.findById(id);
        if (!encontrada.isEmpty()) {
            Mascota actualizada = encontrada.get();
            if (nuevaMascota.getNombreMascota() != null) actualizada.setNombreMascota(nuevaMascota.getNombreMascota());
            if (nuevaMascota.getEdadMascota() != null) actualizada.setEdadMascota(nuevaMascota.getEdadMascota());
            if (nuevaMascota.getRazaMascota() != null) actualizada.setRazaMascota(nuevaMascota.getRazaMascota());
            if (nuevaMascota.getColorMascota() != null) actualizada.setCcMascota(nuevaMascota.getColorMascota());
            if (nuevaMascota.getCcMascota() != null) actualizada.setCcMascota(nuevaMascota.getCcMascota());

            return mascotaRepository.save(actualizada);
        }
        throw new MascotaException("No se encontró la mascota con el id: " + id);
    }

    //Eliminar 1 mascota
    public void eliminarMascota(Long idMascota) {
        mascotaRepository.deleteById(idMascota);
    }
}
