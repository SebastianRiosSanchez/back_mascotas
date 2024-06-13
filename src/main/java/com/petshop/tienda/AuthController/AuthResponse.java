package com.petshop.tienda.AuthController;

import com.petshop.tienda.models.Cliente;
import com.petshop.tienda.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    String token;
    String rol;

}
