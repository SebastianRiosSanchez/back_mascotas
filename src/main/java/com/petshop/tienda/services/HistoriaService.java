package com.petshop.tienda.services;

import com.petshop.tienda.exceptions.MascotaException;
import com.petshop.tienda.models.Historia;
import com.petshop.tienda.repositorys.HistoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriaService {

    @Autowired
    private HistoriaRepository historiaRepository;

    //Crear
    public Historia crearHistoria(Historia nuevaHistoria) {
        return historiaRepository.save(nuevaHistoria);
    }

    //Obtener todas
    public List<Historia> obtHistoria() {
        return historiaRepository.findAll();
    }

    //Obtener X Id
    public Optional<Historia> obtHistoriaXId(Long idHistoria) {
        return historiaRepository.findById(idHistoria);
    }

    //Actualizar historia
    public Historia actHistoria(Long id, Historia nuevaHistoria) {
        Optional<Historia> encontrada = historiaRepository.findById(id);
        if (!encontrada.isEmpty()) {
            Historia actualizada = encontrada.get();
            if (nuevaHistoria.getFechaHistoria() != null)
                actualizada.setFechaHistoria(nuevaHistoria.getFechaHistoria());
            if (nuevaHistoria.getDescHistoria() != null) actualizada.setDescHistoria(nuevaHistoria.getDescHistoria());
            if (nuevaHistoria.getId_mascota() != null) actualizada.setId_mascota(nuevaHistoria.getId_mascota());
            if (nuevaHistoria.getId_medico() != null) actualizada.setId_medico(nuevaHistoria.getId_medico());

            return historiaRepository.save(actualizada);
        }
        throw new MascotaException("No se encontró la historia con el id: " + id);
    }

    //Eliminar historia
    public void eliminarHistoria(Long idHistoria) {
        historiaRepository.deleteById(idHistoria);
    }

}
