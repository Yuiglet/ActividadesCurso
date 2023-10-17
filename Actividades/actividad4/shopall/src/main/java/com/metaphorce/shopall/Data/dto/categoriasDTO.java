package com.metaphorce.shopall.data.dto;

import com.metaphorce.shopall.data.categorias;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * DTO for {@link categorias}
 */

@Setter
@Getter
@Validated
public class categoriasDTO {

    Integer idCategoria;

    @NotBlank(message = "Debe ingresar un nombre")
    String nombre;

    @NotBlank(message = "Debe ingresar una descripcion")
    String descripcion;

    public categoriasDTO() {

    }
}
