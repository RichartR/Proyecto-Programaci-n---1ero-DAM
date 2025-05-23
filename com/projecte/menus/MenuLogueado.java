package com.projecte.menus;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.projecte.Objetos.Actor;
import com.projecte.Objetos.Director;
import com.projecte.Objetos.Pelicula;

public class MenuLogueado {
    static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenuLogueado(String [] datos){ //Menú que aparece una vez ya estás logueado
        int opcion = 0;

        ArrayList<Actor> actoresGlobal = deserializeActorGlobal();
        ArrayList<Pelicula> peliculasGlobal = deserializePeliculaGlobal();
        ArrayList<Director> directoresGlobal = deserializeDirectorGlobal();

        do {
            System.out.println("\n===== Bienvenido " + datos[0] + " " + datos[1] + " =====\n¿Qué desea hacer?\n1.- Ver listas generales\n2.- Añadir datos a una lista\n3.- Eliminar datos de una lista\n4.- Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número válido.");
                scanner.nextLine();
                continue;
            }
            switch (opcion) {
                case 1:
                    System.out.println(eleccionLista());
                    break;
                case 2:
                    System.out.println("Añadir");
                    break;
                case 3:
                    System.out.println("Eliminar");
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 4);
    }

    //SubMenú listas
    public static int eleccionLista(){
        int opcion = 0;
        do {
            System.out.println("\n¿Qué lista quieres ver? [1. Actores / 2. Películas / 3. Directores]");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número válido.");
                scanner.nextLine();
                continue;
            }
            switch (opcion) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 1 || opcion != 2 || opcion != 3);

        return 0;
    }

    //Deserializar
    public static ArrayList<Actor> deserializeActorGlobal(){
        ArrayList<Actor> actores = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("com/projecte/datos/actor.dades"));
            try{
                actores = (ArrayList<Actor>) in.readObject();  
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch(IOException e) {  
                e.printStackTrace();  
            }
                
            in.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return actores;
    }

    public static ArrayList<Pelicula> deserializePeliculaGlobal(){
        ArrayList<Pelicula> peliculas = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("com/projecte/datos/actor.dades"));
            try{
                peliculas = (ArrayList<Pelicula>) in.readObject();  
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch(IOException e) {  
                e.printStackTrace();  
            }
                
            in.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return peliculas;
    }

    public static ArrayList<Director> deserializeDirectorGlobal(){
        ArrayList<Director> directores = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("com/projecte/datos/actor.dades"));
            try{
                directores = (ArrayList<Director>) in.readObject();  
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch(IOException e) {  
                e.printStackTrace();  
            }
                
            in.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return directores;
    }
}
