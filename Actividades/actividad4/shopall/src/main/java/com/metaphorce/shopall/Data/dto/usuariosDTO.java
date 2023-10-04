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
    Long idUsuario;
    String nomUsuario;
    String correo;
    String contrasena;
    String nombre;
    String apellidoPa;
    String apellidoMa;
    String direccion;
    String idTienda;
    public usuariosDTO() {

    }
}
