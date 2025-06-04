package com.projecte.Objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Actor implements Serializable, Comparable<Actor>, Gestionable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int edad;
    private String nacionalidad;
    private String genero;

    // Constructors

    public Actor(String nombre, int edad, String nacionalidad, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.genero = genero;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    //!Métodos
    @Override
    public String toString() {
        return "Nombre: " + nombre + " | " + "Género: " + genero + " | " + "Nacionalidad: " + nacionalidad + " | " + "Edad: " + edad + " años";
    }

    public static void mostrarActores(ArrayList<Actor> actores) {
        if (actores.size() == 0) {
            System.out.println("Lista de directores vacía.\nVolviendo al menú...");
            return;
        }
        
        System.out.println("\nLista de actores:");
        for (int i = 0; i < actores.size(); i++) {
            System.out.println((i+1) + ". " + actores.get(i));
        }
    }

    @Override
    public int compareTo(Actor actor) {
        return this.nombre.compareTo(actor.getIdentificador());
    }

    public static Comparator<Actor> porEdadYNombre(){
        return new Comparator<Actor>(){

            @Override
            public int compare(Actor actorUno, Actor actorDos) {
                int comparacion = Integer.compare(actorUno.getEdad(), actorDos.getEdad());
                if(comparacion == 0){
                    comparacion = actorUno.getIdentificador().compareTo(actorDos.getIdentificador());
                }
                return comparacion;
            }
        };
    }

    /* Métodos de la inferfaz Gestionable */

    @Override
    public String resumen() {
        return "Nombre: " + nombre + "Edad: " + edad + " años";
    }

    @Override
    public String mostrarDetalles() {
        return "Nombre: " + nombre + " | " + "Género: " + genero + " | " + "Nacionalidad: " + nacionalidad + " | " + "Edad: " + edad + " años";
    }

    @Override
    public String getIdentificador() {
        return this.nombre;
    }
}
