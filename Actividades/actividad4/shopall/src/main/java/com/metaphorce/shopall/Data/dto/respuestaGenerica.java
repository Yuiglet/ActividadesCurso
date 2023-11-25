package com.metaphorce.shopall.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class respuestaGenerica {

    private int codigo;
    private boolean exito;
    private String mensaje;
    private List<Object> datos;

    public respuestaGenerica(){
        this.datos = new ArrayList<>();
    }

    public respuestaGenerica(int codigo, boolean exito, String mensaje) {
        super();
        this.codigo = codigo;
        this.exito = exito;
        this.mensaje = mensaje;
    }
}
