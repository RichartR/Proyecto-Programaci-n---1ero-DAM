package com.projecte.Objetos;

import java.util.List;

public class Pelicula {
    private String titulo;
    private int anyoSalida; 
    private String genero;
    private String director;
    


    //Constructors
    public Pelicula(String titulo, int anyoSalida, String genero, String director) {
        this.titulo = titulo;
        this.anyoSalida = anyoSalida;
        this.genero = genero;
        this.director = director;
    }
    //Getters y Setters

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
        return "Título: " + titulo + " | " + "Género: " + genero + " | " + "Año sálida: " + anyoSalida + " | " + "Director: " + director + "\n";
    }

    public static void mostrarPeliculas(List<Pelicula> peliculas){
        if (peliculas.isEmpty()) {
            System.out.println("Lista de películas vacía.\nSaliendo al menú.");
            return;
        }

        for (Pelicula p : peliculas) {
            p.toString();
        }
    }
}


