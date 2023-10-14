package com.metaphorce.shopall.data.dto;

import lombok.Getter;
import lombok.Setter;
import com.metaphorce.shopall.data.usuarios;
import java.io.Serializable;

/**
 * DTO for {@link usuarios}
 */

@Setter
@Getter
public class usuariosDTO implements Serializable {
    Integer idUsuario;
    String nomUsuario;
    String correo;
    String contrasena;
    String nombre;
    String apellidoPa;
    String apellidoMa;
    String direccion;
    public usuariosDTO() {

    }
}
