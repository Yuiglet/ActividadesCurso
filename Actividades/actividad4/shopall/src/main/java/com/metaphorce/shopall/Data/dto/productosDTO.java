package com.metaphorce.shopall.data.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class productosDTO {
    Long idProducto;
    String nombre;
    String descripcion;
    Double precio;
    String categoria;
    String tienda;
}
