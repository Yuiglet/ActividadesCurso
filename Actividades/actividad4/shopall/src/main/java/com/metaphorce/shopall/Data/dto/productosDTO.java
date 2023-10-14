package com.metaphorce.shopall.data.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class productosDTO {
    Integer idProducto;
    String nombre;
    String descripcion;
    Double precio;
    Integer id_categoria;
}
