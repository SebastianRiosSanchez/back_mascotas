package com.petshop.tienda.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "historia")
public class Historia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historia")
    private Long idHistoria;

    @Column(name = "fecha_historia")
    private String fechaHistoria;

    @Column(name = "desc_historia")
    private String descHistoria;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota id_mascota;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico id_medico;

}
