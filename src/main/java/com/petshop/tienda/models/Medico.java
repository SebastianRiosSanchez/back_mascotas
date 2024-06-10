package com.petshop.tienda.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Long idMedico;

    @Column(name = "nombre_medico")
    private String nombreMedico;

    @Column(name = "apellido_medico")
    private String apellidoMedico;

    @Column(name = "cc_medico")
    private Integer ccMedico;

    @Column(name = "email_medico")
    private String emailMedico;

    @Column(name = "direccion_medico")
    private String direccionMedico;

    @Column(name = "especialidad")
    private String especialidad;

}
