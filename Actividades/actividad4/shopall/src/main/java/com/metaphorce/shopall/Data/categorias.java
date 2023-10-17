package com.metaphorce.shopall.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categorias")
public class categorias {

    @Id
    @Column(name = "id_categoria", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;
}
