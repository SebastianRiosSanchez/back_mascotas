package com.petshop.tienda.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "apellido_cliente")
    private String apellidoCliente;

    @Column(name = "cc_cliente")
    private String ccCliente;

    @Column(name = "email_cliente")
    private String emailCliente;

    @Column(name = "direccion_cliente")
    private String direccionCliente;

}
