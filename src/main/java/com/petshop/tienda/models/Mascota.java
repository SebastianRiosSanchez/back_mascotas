package com.petshop.tienda.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long idMascota;

    @Column(name = "nombre_mascota")
    private String nombreMascota;

    @Column(name = "edad_mascota")
    private Integer edadMascota;

    @Column(name = "raza_mascota")
    private String razaMascota;

    @Column(name = "color_mascota")
    private String colorMascota;

    @Column(name = "cc_mascota")
    private String ccMascota;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente id_cliente;

//    @ManyToOne
//    @JoinColumn(name = "id_historia")
//    private Historia id_historia;


}
