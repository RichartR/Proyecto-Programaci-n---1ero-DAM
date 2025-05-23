package com.projecte.Objetos;

import java.io.Serializable;
import java.util.List;

public class Actor implements Serializable {
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
        return "Nombre: " + nombre + " | " + "Género: " + genero + " | " + "Nacionalidad: " + nacionalidad + " | " + "Edad: " + edad + "\n";
    }

    public static void mostrarActoresPersonal(){
        
    }

    public static void mostrarActoresGenerales(List<Actor> actores) {
        if (actores.isEmpty()) {
            System.out.println("Lista de directores vacía.\nVolviendo al menú...");
            return;
        }

        for (Actor a : actores) {
            a.toString();
        }
    }

}
