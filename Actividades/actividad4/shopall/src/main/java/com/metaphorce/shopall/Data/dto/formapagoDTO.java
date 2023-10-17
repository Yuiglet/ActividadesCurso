package com.metaphorce.shopall.data.dto;

import com.metaphorce.shopall.data.formapago;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * DTO for {@link formapago}
 */

@Setter
@Getter
@Validated
public class formapagoDTO {

    Integer idPago;

    @NotBlank(message = "Debe ingresar un nombre")
    String nombre;

    @NotBlank(message = "Debe ingresar una descripcion")
    String descripcion;

    public formapagoDTO() {

    }
}
