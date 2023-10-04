package com.metaphorce.shopall.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "usuarios")

public class usuarios {
    @Id
    @Column(name = "id_usuario", nullable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nom_usuario", nullable = false, length = 45)
    private String nomUsuario;

    @Column(name = "contrasena", nullable = false, length = 12)
    private String contrasena;

    @Column(name = "correo", nullable = false, length = 45)
    private String correo;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Column(name = "apellido_pa", nullable = false, length = 30)
    private String apellidoPa;

    @Column(name = "apellido_ma", nullable = false, length = 30)
    private String apellidoMa;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @Column(name = "id_tienda", nullable = true, length = 45)
    private String idTienda;
}
