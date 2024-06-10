package com.petshop.tienda.services;

import com.petshop.tienda.exceptions.MascotaException;
import com.petshop.tienda.models.Medico;
import com.petshop.tienda.repositorys.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    //Crear
    public Medico crearMedico(Medico nuevoMedico) {
        return medicoRepository.save(nuevoMedico);
    }

    //Obtener todos médicos
    public List<Medico> obtTodosMedicos() {
        return medicoRepository.findAll();
    }

    //Obtener x id
    public Optional<Medico> obtMedicoXId(Long idMedico) {
        return medicoRepository.findById(idMedico);
    }

    //Actualizar
    public Medico actMedico(Long idMedico, Medico nuevoMedico) {
        Optional<Medico> encontrado = medicoRepository.findById(idMedico);
        if (!encontrado.isEmpty()) {
            Medico actualizado = encontrado.get();

            if (nuevoMedico.getNombreMedico() != null) actualizado.setNombreMedico(nuevoMedico.getNombreMedico());
            if (nuevoMedico.getApellidoMedico() != null) actualizado.setApellidoMedico(nuevoMedico.getApellidoMedico());
            if (nuevoMedico.getCcMedico() != null) actualizado.setCcMedico(nuevoMedico.getCcMedico());
            if (nuevoMedico.getEmailMedico() != null) actualizado.setEmailMedico(nuevoMedico.getEmailMedico());
            if (nuevoMedico.getDireccionMedico() != null)
                actualizado.setDireccionMedico(nuevoMedico.getDireccionMedico());
            if (nuevoMedico.getEspecialidad() != null) actualizado.setEspecialidad(nuevoMedico.getEspecialidad());

            return medicoRepository.save(actualizado);
        }
        throw new MascotaException("No se encontró el veterinario con el id: " + idMedico);
    }

    //Eliminar
    public void eliminarMedico(Long idMedico) {
        medicoRepository.deleteById(idMedico);
    }


}
