package com.petshop.tienda.AuthController;

import com.petshop.tienda.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private Long idCliente;

    private String nombreCliente;

    private String apellidoCliente;

    private String ccCliente;

    private String emailCliente;

    private String passCliente;

    private String direccionCliente;

    private Role role;

}
