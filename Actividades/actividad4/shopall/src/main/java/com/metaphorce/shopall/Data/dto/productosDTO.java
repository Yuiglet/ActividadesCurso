package com.metaphorce.shopall.data.dto;

import com.metaphorce.shopall.data.productos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * DTO for {@link productos}
 */
@Setter
@Getter
@Validated
public class productosDTO {

    Integer idProducto;

    @NotBlank(message = "Debe ingresar un nombre")
    String nombre;

    @NotBlank(message = "Debe ingresar una descripcion")
    String descripcion;

    @NotNull(message = "Debe ingresar un precio")
    @Positive(message = "Debe ingresar un precio valido")
    Double precio;

    @NotNull(message = "Debe ingresar una categoria")
    @Positive(message = "Debe ingresar una categoria valida")
    Integer id_categoria;
}
