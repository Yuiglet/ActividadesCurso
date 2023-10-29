package com.metaphorce.shopall.data.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import com.metaphorce.shopall.data.usuarios;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

/**
 * DTO for {@link usuarios}
 */

@Setter
@Getter
@Validated
public class usuariosDTO implements Serializable {

    Integer idUsuario;

    @NotBlank(message = "Debe ingresar un usuario valido")
    private String nomUsuario;

    @NotBlank(message = "Debe ingresar una cantidad de producto")
    private String correo;

    @NotBlank(message = "Debe ingresar una contraseña")
    private String contrasena;

    @NotBlank(message = "Debe ingresar un nombre")
    private String nombre;

    @NotBlank(message = "Debe ingresar un apellido paterno")
    private String apellidoPa;

    @NotBlank(message = "Debe ingresar un apellido materno")
    private String apellidoMa;

    @NotBlank(message = "Debe ingresar una direccion")
    private String direccion;

    public usuariosDTO() {

    }
}
