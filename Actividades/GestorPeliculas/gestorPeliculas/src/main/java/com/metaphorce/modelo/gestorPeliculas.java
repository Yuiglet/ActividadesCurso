package com.metaphorce.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class gestorPeliculas {
    private List<Pelicula> peliculas;

    public gestorPeliculas() {
        this.peliculas = new ArrayList<>();
    }

    // Método para agregar una película a la colección
    public void AgregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    // Método para eliminar una película por ID
    public void EliminarPelicula(int id) {
        peliculas.removeIf(pelicula -> pelicula.getIdPelicula() == id);
    }

    // Método para obtener todas las películas
    public List<Pelicula> ObtenerPeliculas() {
        return peliculas;
    }

    // Método para obtener las películas disponibles
    public List<Pelicula> ObtenerPeliculasDisponibles() {
        List<Pelicula> disponibles = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getDisponible().equalsIgnoreCase("Disponible")) {
                disponibles.add(pelicula);
            }
        }
        return disponibles;
    }

    // Método para obtener las películas no disponibles
    public List<Pelicula> ObtenerPeliculasNoDisponibles() {
        List<Pelicula> noDisponibles = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getDisponible().equalsIgnoreCase("No Disponible")) {
                noDisponibles.add(pelicula);
            }
        }
        return noDisponibles;

    }

    // Método para marcar una película como disponible por ID
    public void MarcarPeliculaComoDisponible(int id) {
        // Buscar la película por ID
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getIdPelicula() == id) {
                // Marcar la película como disponible
                pelicula.setDisponible("Disponible");
                return; // Salir del bucle una vez que se haya encontrado la película
            }
        }
        // En caso de no encontral la pelicula
        throw new IllegalArgumentException("No se encontró una película con el ID especificado.");
    }
}
