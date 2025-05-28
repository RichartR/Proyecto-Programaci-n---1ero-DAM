package com.projecte.Objetos;

import java.io.Serializable;
import java.util.ArrayList;

public class Pelicula implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private int anyoSalida; 
    private String genero;
    private String director;
    private String duracion;
    



    //Constructors
    public Pelicula(String titulo, int anyoSalida, String genero, String director, String duracion) {
        this.titulo = titulo;
        this.anyoSalida = anyoSalida;
        this.genero = genero;
        this.director = director;
        this.duracion = duracion;
    }
    //Getters y Setters


    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getAnyoSalida() {
        return anyoSalida;
    }
    public void setAnyoSalida(int anyoSalida) {
        this.anyoSalida = anyoSalida;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    

    //!Métodos


    @Override
    public String toString() {
        return duracion + "Título: " + titulo + " | " + "Género: " + genero + " | " + "Año sálida: " + anyoSalida + " | " + "Director: " + director + " | " ;
    }

    public static void mostrarPeliculas(ArrayList<Pelicula> peliculas) {
        if (peliculas.size() == 0) {
            System.out.println("Lista de películas vacía.\nVolviendo al menú...");
            return;
        }

        System.out.println("\nLista de películas:");
        
        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println((i+1) + ". " + peliculas.get(i));
        }
    }
}


