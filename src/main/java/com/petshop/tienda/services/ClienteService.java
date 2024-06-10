package com.petshop.tienda.services;

import com.petshop.tienda.exceptions.MascotaException;
import com.petshop.tienda.models.Cliente;
import com.petshop.tienda.repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //Crear nuevo cliente
    public Cliente crearCliente(Cliente nuevoCliente) {
        return clienteRepository.save(nuevoCliente);
    }

    //Obtener todos los clientes
    public List<Cliente> obtTodosClientes() {
        return clienteRepository.findAll();
    }

    //Obtener x id
    public Optional<Cliente> obtClienteXId(Long idCliente) {
        return clienteRepository.findById(idCliente);
    }

    //Actualizar Cliente
    public Cliente actCliente(Long idCliente, Cliente nuevoCliente) {
        Optional<Cliente> encontrado = clienteRepository.findById(idCliente);
        if (!encontrado.isEmpty()) {
            Cliente actualizado = encontrado.get();

            if (nuevoCliente.getNombreCliente() != null) actualizado.setNombreCliente(nuevoCliente.getNombreCliente());
            if (nuevoCliente.getApellidoCliente() != null)
                actualizado.setApellidoCliente(nuevoCliente.getApellidoCliente());
            if (nuevoCliente.getCcCliente() != null) actualizado.setCcCliente(nuevoCliente.getCcCliente());
            if (nuevoCliente.getEmailCliente() != null) actualizado.setEmailCliente(nuevoCliente.getEmailCliente());
            if (nuevoCliente.getDireccionCliente() != null)
                actualizado.setDireccionCliente(nuevoCliente.getDireccionCliente());

            return clienteRepository.save(actualizado);
        }
        throw new MascotaException("No se encontró el cliente con el id: " + idCliente);
    }

    //Eliminar 1 cliente
    public void eliminarcliente(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }

}
