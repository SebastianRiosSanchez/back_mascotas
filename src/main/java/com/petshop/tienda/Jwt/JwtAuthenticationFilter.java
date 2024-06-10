package com.petshop.tienda.Jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter { // La clase OncePerRequestFilter se utiliza para crear filtros personalizados y se extiende para garantizar que se ejecute el filtro solo una vez por cada peticción HTTP

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String token = getTokenFromRequest(request);

        //Si el token es nulo le regresamos a la cadena de filtros el control.
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }
        //Se llama al filtro para que siga su curso.
        filterChain.doFilter(request, response);
    }

    //Implementación del método getTokenFromRequest, este método retorna el token que no es más que una cadena de caracteres.
    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION); // Se declara una variable para almacenar el encabezado de la petición.

        //Se verifica si el encabezado tiene el texto y si este comienza por "Bearer ". En caso contrario se retorna nulo.
        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }

}
