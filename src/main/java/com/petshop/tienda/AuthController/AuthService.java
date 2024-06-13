package com.petshop.tienda.AuthController;

import com.petshop.tienda.Jwt.JTWService;
import com.petshop.tienda.models.Cliente;
import com.petshop.tienda.models.Role;
import com.petshop.tienda.repositorys.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ClienteRepository clienteRepository;
    private final JTWService jtwService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.emailCliente, request.passCliente));
        UserDetails user = clienteRepository.findByEmailCliente(request.emailCliente).orElseThrow();
        String token = jtwService.getToken(user);
        String role = user.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("Error al obtener el rol");
        return AuthResponse.builder()
                .token(token)
                .rol(role)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {

        Cliente cliente = Cliente.builder()
                .nombreCliente(request.getNombreCliente())
                .apellidoCliente(request.getApellidoCliente())
                .ccCliente(request.getCcCliente())
                .emailCliente(request.getEmailCliente())
                .direccionCliente(request.getDireccionCliente())
                .passCliente(passwordEncoder.encode(request.getPassCliente()))
                .role(Role.USER)
                .build();

        clienteRepository.save(cliente);

        return AuthResponse.builder()
                .token(jtwService.getToken(cliente))
                .build();
    }
}
