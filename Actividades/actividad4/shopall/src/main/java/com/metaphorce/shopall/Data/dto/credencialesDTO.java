package com.metaphorce.shopall.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Setter
@Getter
@Validated
public class credencialesDTO {
    @NotNull(message = "Debe ingresar un correo valido")
    private String nomUsuario;
    @NotNull(message = "Debe ingresar una contraseña valida")
    private String contrasena;
}
