package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.data.dto.credencialesDTO;
import com.metaphorce.shopall.data.dto.respuestaGenerica;
import com.metaphorce.shopall.service.authService;
import com.metaphorce.shopall.service.jwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class authController {
    @Value("${myapp.username}")
    private String configuredUsername;

    @Value("${myapp.password}")
    private String configuredPassword;

    @Autowired
    private final jwtService JwtService;

    @Autowired
    private authService autenticacionService;

    public authController(jwtService JwtService) {
        this.JwtService = JwtService;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<respuestaGenerica> authenticate(@Valid @RequestBody credencialesDTO credentials) {
        respuestaGenerica respuesta = autenticacionService.getTokenUsuario(credentials);
        HttpStatus status = null;
        if(respuesta.isExito()){
            status =  HttpStatus.OK;
            respuesta.setCodigo(status.value());
        }else{
            status = HttpStatus.BAD_REQUEST;
            respuesta.setCodigo(status.value());
        }
        return new ResponseEntity<>(respuesta,status);
    }
}
