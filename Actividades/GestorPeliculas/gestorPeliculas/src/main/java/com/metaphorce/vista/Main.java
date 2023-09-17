package com.metaphorce.vista;
import com.metaphorce.modelo.*;

import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        gestorPeliculas gestor = new gestorPeliculas();

        // Crear instancias de películas y agregarlas al gestor
        Pelicula pelicula1 = new Pelicula(1, "Toy Story",  true);
        Pelicula pelicula2 = new Pelicula(2, "Resident Evil I",  true);
        Pelicula pelicula3 = new Pelicula(3, "Star Wars I",  false);

        gestor.AgregarPelicula(pelicula1);
        gestor.AgregarPelicula(pelicula2);
        gestor.AgregarPelicula(pelicula3);

        // Mostrar la lista de películas
        System.out.println("Lista de películas:");
        List<Pelicula> todasLasPeliculas = gestor.ObtenerPeliculas();
        for (Pelicula pelicula : todasLasPeliculas) {
            System.out.println(pelicula.getNombre() + " - Estado: " + pelicula.getDisponible());
        }

        // Eliminar una película (por ID)
        int idAEliminar = 2;
        gestor.EliminarPelicula(idAEliminar);
        System.out.println("\nPelícula eliminada con ID " + idAEliminar);

        // Marcar una película como disponible (por ID)
        int idAMarcar = 1;
        gestor.MarcarPeliculaComoDisponible(idAMarcar);
        System.out.println("\nPelícula marcada como disponible con ID " + idAMarcar);

        // Mostrar la lista de películas no disponibles
        System.out.println("\nLista de películas no disponibles:");
        List<Pelicula> peliculasNoDisponibles = gestor.ObtenerPeliculasNoDisponibles();
        for (Pelicula pelicula : peliculasNoDisponibles) {
            System.out.println(pelicula.getNombre() + " - Estado: " + pelicula.getDisponible());
        }
    }
}