package com.metaphorce.shopall.data;

import jakarta.persistence.*;

public class productos {
    @Id
    @Column(name = "idProducto", nullable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;
    @Column(name = "precio", nullable = false, length = 10)
    private double precio;

    @Column(name = "categoriaId", nullable = false, length = 10)
    private String categoria;

    @Column(name = "idTienda", nullable = false, length = 10)
    private String tienda;
}
