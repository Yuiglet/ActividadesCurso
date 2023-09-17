package com.metaphorce.modelo;

public class Pelicula {
    int idPelicula;
    String nombre;
    Boolean disponible;

    public Pelicula(int id, String nombre, boolean disponible) {
        this.idPelicula = id;
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDisponible() {
        return disponible ? "Disponible" : "No Disponible";
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible.equalsIgnoreCase("Disponible");
    }
}
