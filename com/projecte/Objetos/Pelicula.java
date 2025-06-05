package com.projecte.Objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Pelicula implements Serializable, Comparable<Pelicula>, Gestionable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private int anyoSalida; 
    private String genero;
    private String director;
    private int duracionMinutos;
    
    //Constructors
    public Pelicula(String titulo, int anyoSalida, String genero, String director, int duracion) {
        this.titulo = titulo;
        this.anyoSalida = anyoSalida;
        this.genero = genero;
        this.director = director;
        this.duracionMinutos = duracion;
    }

    //Getters y Setters
    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracion) {
        this.duracionMinutos = duracion;
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
        return "Título: " + titulo + " | Género: " + genero + " | Año sálida: " + anyoSalida + " | Director: " + director + " | Duración: " + duracionMinutos;
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

    @Override
    public int compareTo(Pelicula pelicula) {
        return this.titulo.compareTo(pelicula.getIdentificador());
    }

    public static Comparator<Pelicula> porAnyoYTitulo(){
        return new Comparator<Pelicula>(){

            @Override
            public int compare(Pelicula peliculaUno, Pelicula peliculaDos) {
                int comparacion = Integer.compare(peliculaUno.getAnyoSalida(), peliculaDos.getAnyoSalida());
                if(comparacion == 0){
                    comparacion = peliculaUno.getIdentificador().compareTo(peliculaDos.getIdentificador());
                }
                return comparacion;
            }
        };
    }

    /* Métodos de la inferfaz Gestionable */
    @Override
    public String getIdentificador() {
        return this.titulo;
    }

    @Override
    public String resumen() {
        return "Título: " + titulo + " | Género: " + genero;
    }

    @Override
    public String mostrarDetalles() {
        return "Título: " + titulo + " | Género: " + genero + " | Año sálida: " + anyoSalida + " | Director: " + director + " | Duración: " + duracionMinutos;
    }
}


