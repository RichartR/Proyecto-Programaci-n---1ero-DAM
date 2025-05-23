package com.projecte.Objetos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Listas {

    static final Scanner sc = new Scanner(System.in);

    public static void crearActor(ArrayList<Actor> actores) {

        // private String nombre;
        // private int edad;
        // private String nacionalidad;
        // private String genero;
        try {

            System.out.println("Nombre del actor:");
            String nombre = sc.nextLine();
            System.out.println("Edad del actor:");
            int edad = sc.nextInt();
            System.out.println("Nacionalidad del Actor:");
            String nacionalidad = sc.nextLine();
            System.out.println("Género: (F o M)");
            String genero = sc.nextLine();

            Actor actor = new Actor(nombre, edad, nacionalidad, genero);

            actores.add(actor);

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/datos/actor.dades", false));) {
                out.writeObject(actores);
                out.close();
            } catch (IOException e) {
                System.out.println("Problema: " + e);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static void crearDirector(ArrayList<Director> directores) {

        // private String nombre;
        // private int edad;
        // private String nacionalidad;
        // private String genero;
        try {

            System.out.println("Nombre del director:");
            String nombre = sc.nextLine();
            System.out.println("Edad del director:");
            int edad = sc.nextInt();
            System.out.println("Nacionalidad del director:");
            String nacionalidad = sc.nextLine();
            System.out.println("Género: (F o M)");
            String genero = sc.nextLine();

            Director director = new Director(nombre, edad, nacionalidad, genero);

            directores.add(director);

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/datos/director.dades", false));) {
                out.writeObject(directores);
                out.close();
            } catch (IOException e) {
                System.out.println("Problema: " + e);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static void crearPelicula(ArrayList<Pelicula> peliculas) {

        // private String titulo;
        // private int anyoSalida; 
        // private String genero;
        // private String director;
        try {

            System.out.println("Título de la película:");
            String titulo = sc.nextLine();
            System.out.println("Año en la que salió :");
            int anyoSalida = sc.nextInt();
            System.out.println("Género de la película: (EJ: Terror)");
            String genero = sc.nextLine();
            System.out.println("Director que lo dirigió:");
            String director = sc.nextLine();

            Pelicula pelicula = new Pelicula(titulo, anyoSalida, genero, director);
            peliculas.add(pelicula);

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/datos/pelicula.dades", false));) {
                out.writeObject(pelicula);
                out.close();
            } catch (IOException e) {
                System.out.println("Problema: " + e);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
