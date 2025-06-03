package com.projecte.Objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
public class Director implements Serializable, Comparable<Director>, Gestionable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int edad;
    private String nacionalidad;
    private String genero;

    

        //Constructors

        public Director(String nombre, int edad, String nacionalidad, String genero) {
            this.nombre = nombre;
            this.edad = edad;
            this.nacionalidad = nacionalidad;
            this.genero = genero;
        }

    //Getters y Setters

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

    //Métodos
    @Override
    public String toString() {
        return "Nombre: " + nombre + " | " + "Género: " + genero + " | " + "Nacionalidad: " + nacionalidad + " | " + "Edad: " + edad + " años";
    }

    public static void mostrarDirectores(ArrayList<Director> directores) {
        if (directores.size() == 0) {
            System.out.println("Lista de directores vacía.\nSaliendo al menú...");
        }

        System.out.println("\nDirectores:");

        for (int i = 0; i <  directores.size(); i++) {
            System.out.println((i+1) + ". " + directores.get(i));
        }
    }

    @Override
    public int compareTo(Director director) {
        return this.nombre.compareTo(director.getNombre());
    }

    public static Comparator<Director> porEdadYNombre(){
        return new Comparator<Director>(){

            @Override
            public int compare(Director directorUno, Director directorDos) {
                int comparacion = Integer.compare(directorUno.getEdad(), directorDos.getEdad());
                if(comparacion == 0){
                    comparacion = directorUno.getNombre().compareTo(directorDos.getNombre());
                }
                return comparacion;
            }
        };
    }


    /* Métodos de la inferfaz Gestionable */
    @Override
    public String getIdentificador() {
        return this.nombre;
    }

    @Override
    public String resumen() {
        return "Nombre: " + nombre + "Edad: " + edad + " años";
    }

    @Override
    public String mostrarDetalles() {
        return "Nombre: " + nombre + " | " + "Género: " + genero + " | " + "Nacionalidad: " + nacionalidad + " | " + "Edad: " + edad + " años";
    }

}
