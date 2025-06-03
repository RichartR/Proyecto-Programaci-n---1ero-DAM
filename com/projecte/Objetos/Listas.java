package com.projecte.Objetos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Listas {

    static final Scanner sc = new Scanner(System.in);

    public static boolean crearActor(ArrayList<Actor> actores) {

        // private String nombre;
        // private int edad;
        // private String nacionalidad;
        // private String genero;
        try {

            System.out.println("Nombre del actor:");
            String nombre = sc.nextLine();

            //Comprobar si ya existe
            for (int i = 0; i < actores.size(); i++) {
                if (nombre.equalsIgnoreCase(actores.get(i).getNombre())) {
                    System.out.println("Ya existe un actor con ese nombre. Volviendo a la selección de listas...");
                    return false; //Salir al menú de añadir a listas generales
                }
            }
  
            System.out.println("Edad del actor:");
            int edad = sc.nextInt();
            sc.nextLine();
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
            System.out.println("Problema: " + e);
        }

        return true;
    }

    public static boolean crearDirector(ArrayList<Director> directores) {

        // private String nombre;
        // private int edad;
        // private String nacionalidad;
        // private String genero;
        try {

            System.out.println("Nombre del director:");
            String nombre = sc.nextLine();

            //Comprobar si ya existe
            for (int i = 0; i < directores.size(); i++) {
                if (nombre.equalsIgnoreCase(directores.get(i).getNombre())) {
                    System.out.println("Ya existe un director con ese nombre. Volviendo a la selección de listas...");
                    return false; //Salir al menú de añadir a listas generales
                }
            }

            System.out.println("Edad del director:");
            int edad = sc.nextInt();
            sc.nextLine();

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
            System.out.println("Problema: " + e);
        }

        return true;
    }

    public static boolean crearPelicula(ArrayList<Pelicula> peliculas) {

        // private String titulo;
        // private int anyoSalida; 
        // private String genero;
        // private String director;
        try {
            System.out.println("Título de la película:");
            String titulo = sc.nextLine();

            //Comprobar si ya existe
            for (int i = 0; i < peliculas.size(); i++) {
                if (titulo.equalsIgnoreCase(peliculas.get(i).getTitulo())) {
                    System.out.println("Ya existe una película con ese título. Volviendo a la selección de listas...");
                    return false; //Salir al menú de añadir a listas generales
                }
            }

            System.out.println("Año en la que salió :");
            int anyoSalida = sc.nextInt();
            sc.nextLine();
            System.out.println("Género de la película: (EJ: Terror)");
            String genero = sc.nextLine();
            System.out.println("Director que lo dirigió:");
            String director = sc.nextLine();
            System.out.println("Dime la duración de la película (En minutos)");
            int duracionMinutos = sc.nextInt();

            Pelicula pelicula = new Pelicula(titulo, anyoSalida, genero, director, duracionMinutos);
            peliculas.add(pelicula);

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/datos/pelicula.dades", false));) {
                out.writeObject(peliculas);
                out.close();
            } catch (IOException e) {
                System.out.println("Problema: " + e);
            }

        } catch (Exception e) {
            System.out.println("Problema: " + e);
        }

        return true;
    }

    /* Añadir elementos a listas privadas */
    public static boolean anyadirActor(ArrayList<Actor> actoresUsuario, ArrayList<Actor> actoresGlobal, String usuario) {
        Actor.mostrarActores(actoresGlobal);
        System.out.println("¿Qué actor quieres añadir? (Introduce el número del actor que aparece en la lista)");
        int opcion = sc.nextInt();
        sc.nextLine();

        if(opcion > actoresGlobal.size() || opcion <= 0){
            System.out.println("No existe ese actor.");
            return false;
        }

        for (int i = 0; i < actoresGlobal.size(); i++) {
            if(opcion - 1 == i){

                //Comprobar si ya existe
                for (int j = 0; j < actoresUsuario.size(); j++) {
                    if(actoresGlobal.get(i).getNombre().equalsIgnoreCase(actoresUsuario.get(j).getNombre())){
                        System.out.println("Ya existe el actor \"" + actoresGlobal.get(i) + "\" en la lista." );
                        return false;
                    }
                }

                //Añadir actor
                actoresUsuario.add(actoresGlobal.get(i));
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/usuarios/" + usuario + "/actores.llista", false));) {
                    out.writeObject(actoresUsuario);
                    System.out.println("Actor añadido.");
                } catch (IOException e) {
                    System.out.println("Problema: " + e.getMessage());
                }
            }
        }
        return true;
    }

    public static boolean anyadirPelicula(ArrayList<Pelicula> peliculaUsuario, ArrayList<Pelicula> peliculaGlobal, String usuario) {
        Pelicula.mostrarPeliculas(peliculaGlobal);
        System.out.println("¿Qué película quieres añadir? (Introduce el número del actor que aparece en la lista)");
        int opcion = sc.nextInt();
        sc.nextLine();

        if(opcion > peliculaGlobal.size() || opcion <= 0){
            System.out.println("No existe ese actor.");
            return false;
        }
        
        for (int i = 0; i < peliculaGlobal.size(); i++) {
            if(opcion - 1 == i){

                //Comprobar si ya existe
                for (int j = 0; j < peliculaUsuario.size(); j++) {
                    if(peliculaGlobal.get(i).getTitulo().equalsIgnoreCase(peliculaUsuario.get(j).getTitulo())){
                        System.out.println("Ya existe esa pelicula.");
                        return false;
                    }
                }

                //Añadir pelicula
                peliculaUsuario.add(peliculaGlobal.get(i));
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/usuarios/" + usuario + "/peliculas.llista", false));) {
                    out.writeObject(peliculaUsuario);
                    System.out.println("Pelicula añadida.");
                } catch (IOException e) {
                    System.out.println("Problema: " + e.getMessage());
                }
            }
        }

        return true;
    }

    public static boolean anyadirDirector(ArrayList<Director> directorUsuario, ArrayList<Director> directorGlobal, String usuario) {
        Director.mostrarDirectores(directorGlobal);
        System.out.println("¿Qué director quieres añadir? (Introduce el número del actor que aparece en la lista)");
        int opcion = sc.nextInt();
        sc.nextLine();

        if(opcion > directorGlobal.size() || opcion <= 0){
            System.out.println("No existe ese director.");
            return false;
        }
        
        for (int i = 0; i < directorGlobal.size(); i++) {
            if(opcion - 1 == i){

                //Comprobar si ya existe
                for (int j = 0; j < directorUsuario.size(); j++) {
                    if(directorGlobal.get(i).getNombre().equalsIgnoreCase(directorUsuario.get(j).getNombre())){
                        System.out.println("Ya existe el director \"" + directorGlobal.get(i-1) + "\" en la lista." );
                        return false;
                    }
                }

                //Añadir director
                System.out.println("nombre " + directorGlobal.get(i-1).getNombre());
                directorUsuario.add(directorGlobal.get(i-1));
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/usuarios/" + usuario + "/directores.llista", false));) {
                    out.writeObject(directorUsuario);
                    System.out.println("Director añadido.");
                } catch (IOException e) {
                    System.out.println("Problema: " + e.getMessage());
                }
            }
        }
        return true;
    }

    /* Eliminar elementos de listas generales */
    public static boolean eliminarActor(ArrayList<Actor> actoresGlobal) {
        System.out.println("¿Qué actor quieres eliminar? (Introduce el número del actor que aparece en la lista, introduce 0 para salir)");
        Actor.mostrarActores(actoresGlobal);
        int opcion = sc.nextInt();
        sc.nextLine();

        if(opcion > actoresGlobal.size() || opcion < 0){
            System.out.println("No existe ese actor.");
            return false;
        }

        if(opcion == 0){
            System.out.println("Saliendo...");
            return false;
        }

        Iterator <Actor> iterator = actoresGlobal.iterator();
        while(iterator.hasNext()){
            Actor actor = iterator.next();
            if(opcion - 1 == actoresGlobal.indexOf(actor)){
                iterator.remove();
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/datos/actor.dades", false));) {
                    out.writeObject(actoresGlobal);
                    System.out.println("Actor eliminado.");
                    return true; //Salir del método
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        return true;
    }

    public static boolean eliminarPelicula(ArrayList<Pelicula> peliculaGlobal) {
        System.out.println("¿Qué actor quieres eliminar? (Introduce el número del actor que aparece en la lista, introduce 0 para salir)");
        Pelicula.mostrarPeliculas(peliculaGlobal);
        int opcion = sc.nextInt();
        sc.nextLine();

        if(opcion > peliculaGlobal.size() || opcion < 0){
            System.out.println("No existe ese actor.");
            return false;
        }

        if(opcion == 0){
            System.out.println("Saliendo...");
            return false;
        }

        Iterator <Pelicula> iterator = peliculaGlobal.iterator();
        while(iterator.hasNext()){
            Pelicula actor = iterator.next();
            if(opcion - 1 == peliculaGlobal.indexOf(actor)){
                iterator.remove();
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/datos/actor.dades", false));) {
                    out.writeObject(peliculaGlobal);
                    System.out.println("Pelicula eliminada.");
                    return true; //Salir del método
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        return true;
    }

    public static boolean eliminarDirector(ArrayList<Director> directoresGlobal) {
        System.out.println("¿Qué actor quieres eliminar? (Introduce el número del actor que aparece en la lista, introduce 0 para salir)");
        Director.mostrarDirectores(directoresGlobal);
        int opcion = sc.nextInt();
        sc.nextLine();

        if(opcion > directoresGlobal.size() || opcion < 0){
            System.out.println("No existe ese actor.");
            return false;
        }

        if(opcion == 0){
            System.out.println("Saliendo...");
            return false;
        }

        Iterator <Director> iterator = directoresGlobal.iterator();
        while(iterator.hasNext()){
            Director actor = iterator.next();
            if(opcion - 1 == directoresGlobal.indexOf(actor)){
                iterator.remove();
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/datos/actor.dades", false));) {
                    out.writeObject(directoresGlobal);
                    System.out.println("Director eliminado.");
                    return true; //Salir del método
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        return true;
    }
}
