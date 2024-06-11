package com.petshop.tienda.AuthController;

import com.petshop.tienda.Jwt.JTWService;
import com.petshop.tienda.models.Cliente;
import com.petshop.tienda.models.Role;
import com.petshop.tienda.repositorys.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ClienteRepository clienteRepository;
    private final JTWService jtwService;

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {

        Cliente cliente = Cliente.builder()
                .nombreCliente(request.getNombreCliente())
                .apellidoCliente(request.getApellidoCliente())
                .ccCliente(request.getCcCliente())
                .emailCliente(request.getEmailCliente())
                .direccionCliente(request.getDireccionCliente())
                .role(Role.USER)
                .build();

        clienteRepository.save(cliente);

        return AuthResponse.builder()
                .token(jtwService.getToken(cliente))
                .build();
    }
}
