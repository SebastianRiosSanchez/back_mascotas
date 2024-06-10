package com.petshop.tienda.controllers;

import com.petshop.tienda.models.Cliente;
import com.petshop.tienda.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //Post
    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente nuevoCliente) {
        return clienteService.crearCliente(nuevoCliente);
    }

    //Get
    @GetMapping
    public List<Cliente> obtTodoCliente() {
        return clienteService.obtTodosClientes();
    }

    //Get X id
    @GetMapping("/{id}")
    public Optional<Cliente> obtClienteXId(@PathVariable("id") Long idCliente) {
        return clienteService.obtClienteXId(idCliente);
    }

    //Put
    @PutMapping("/{id}")
    public Cliente actCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        return clienteService.actCliente(id, cliente);
    }

    //Delete
    @DeleteMapping("/{id}")
    public void eliminaCliente(@PathVariable("id") Long id) {
        clienteService.eliminarcliente(id);
    }

}
