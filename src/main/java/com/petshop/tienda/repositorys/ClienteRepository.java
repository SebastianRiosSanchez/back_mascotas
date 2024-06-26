package com.petshop.tienda.repositorys;

import com.petshop.tienda.models.Cliente;
import com.petshop.tienda.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByEmailCliente(String emailCliente);

}
