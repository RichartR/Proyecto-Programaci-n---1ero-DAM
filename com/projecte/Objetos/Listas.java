package com.projecte.Objetos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Listas {

    static final Scanner sc = new Scanner(System.in);

    static String mensajeError = "El campo no puede estar vacio";

    public static boolean crearActor(ArrayList<Actor> actores) throws CampoVacio {

        try {
            String nombre;
            do {
                System.out.println("Nombre del actor:");
                nombre = sc.nextLine();

                if(nombre.isEmpty()){
                    throw new CampoVacio(mensajeError);
                }
            } while (nombre.isEmpty());

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

            String nacionalidad;
            do {
                System.out.println("Nacionalidad del Actor:");
                nacionalidad = sc.nextLine();
                if(nacionalidad.isEmpty()){
                    throw new CampoVacio(mensajeError);
                }
            } while (nacionalidad.isEmpty());

            String genero;
            do {                
                System.out.println("Género: (H o M)");
                genero = sc.nextLine();
                if(genero.isEmpty()){
                    throw new CampoVacio(mensajeError);
                } else if(!(genero.equalsIgnoreCase("h") ||genero.equalsIgnoreCase("m"))){
                    System.out.println("Debe introducir un género correcto [H/M].");
                }
            } while (genero.isEmpty() || !(genero.equalsIgnoreCase("m") ||genero.equalsIgnoreCase("h")));

            Actor actor = new Actor(nombre, edad, nacionalidad, genero);

            actores.add(actor);

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/datos/actor.dades", false));) {
                out.writeObject(actores);
                out.close();
            } catch (IOException e) {
                System.out.println("Problema: " + e);
            }

        } catch (InputMismatchException e){
            sc.nextLine();
            System.out.println("Tipo de valor incorrecto.");
        } catch (Exception e) {
            System.out.println("Problema: " + e);
        }

        return true;
    }

    public static boolean crearDirector(ArrayList<Director> directores) throws CampoVacio {

        try {
            String nombre;
            do {
                System.out.println("Nombre del director:");
                nombre = sc.nextLine();

                if(nombre.isEmpty()){
                    throw new CampoVacio(mensajeError);
                }
            } while (nombre.isEmpty());

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

            String nacionalidad;
            do {
                System.out.println("Nacionalidad del Actor:");
                nacionalidad = sc.nextLine();
                if(nacionalidad.isEmpty()){
                    throw new CampoVacio(mensajeError);
                }
            } while (nacionalidad.isEmpty());

            String genero;
            do {                
                System.out.println("Género: (H o M)");
                genero = sc.nextLine();
                if(genero.isEmpty()){
                    throw new CampoVacio(mensajeError);
                } else if(!(genero.equalsIgnoreCase("h") ||genero.equalsIgnoreCase("m"))){
                    System.out.println("Debe introducir un género correcto [H/M].");
                }
            } while (genero.isEmpty() || !(genero.equalsIgnoreCase("m") ||genero.equalsIgnoreCase("h")));

            Director director = new Director(nombre, edad, nacionalidad, genero);

            directores.add(director);

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/datos/director.dades", false));) {
                out.writeObject(directores);
                out.close();
            } catch (IOException e) {
                System.out.println("Problema: " + e);
            }

        } catch (InputMismatchException e){
            sc.nextLine();
            System.out.println("Tipo de valor incorrecto.");
        } catch (Exception e) {
            System.out.println("Problema: " + e);
        }

        return true;
    }

    public static boolean crearPelicula(ArrayList<Pelicula> peliculas) throws CampoVacio {

        try {

            String titulo;
            do {
                System.out.println("Título de la película:");
                titulo = sc.nextLine();

                if(titulo.isEmpty()){
                    throw new CampoVacio(mensajeError);
                }
            } while (titulo.isEmpty());

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

            String genero;
            do {
                System.out.println("Género de la película: (EJ: Terror)");
                genero = sc.nextLine();

                if(genero.isEmpty()){
                    throw new CampoVacio(mensajeError);
                }
            } while (genero.isEmpty());

            String director;
            do {
                System.out.println("Director que lo dirigió:");
                director = sc.nextLine();

                if(director.isEmpty()){
                    throw new CampoVacio(mensajeError);
                }
            } while (director.isEmpty());
            System.out.println("Duración de la película (En minutos):");
            int duracionMinutos = sc.nextInt();
            sc.nextLine();

            Pelicula pelicula = new Pelicula(titulo, anyoSalida, genero, director, duracionMinutos);
            peliculas.add(pelicula);

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/datos/pelicula.dades", false));) {
                out.writeObject(peliculas);
                out.close();
            } catch (IOException e) {
                System.out.println("Problema: " + e);
            }

        } catch (InputMismatchException e){
            sc.nextLine();
            System.out.println("Tipo de valor incorrecto.");
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
    public static boolean eliminarActor(ArrayList<Actor> actores, String rolUsuario, String usuario) {
        System.out.println("¿Qué actor quieres eliminar? (Introduce el número del actor que aparece en la lista, introduce 0 para salir)");
        Actor.mostrarActores(actores);
        int opcion = sc.nextInt();
        sc.nextLine();

        if(opcion > actores.size() || opcion < 0){
            System.out.println("No existe ese actor.");
            return false;
        }

        if(opcion == 0){
            System.out.println("Saliendo...");
            return false;
        }

        Iterator <Actor> iterator = actores.iterator();
        while(iterator.hasNext()){
            Actor actor = iterator.next();
            if(opcion - 1 == actores.indexOf(actor)){
                iterator.remove();
                if(rolUsuario.equalsIgnoreCase("ROL_ADMIN")){
                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/datos/actor.dades", false));) {
                        out.writeObject(actores);
                        System.out.println("Actor eliminado.");
                        return true; //Salir del método
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/usuarios/" + usuario + "/actores.llista", false));) {
                        out.writeObject(actores);
                        System.out.println("Actor eliminado.");
                        return true; //Salir del método
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
        }

        return true;
    }

    public static boolean eliminarPelicula(ArrayList<Pelicula> pelicula, String rolUsuario, String usuario) {
        System.out.println("¿Qué actor quieres eliminar? (Introduce el número del actor que aparece en la lista, introduce 0 para salir)");
        Pelicula.mostrarPeliculas(pelicula);
        int opcion = sc.nextInt();
        sc.nextLine();

        if(opcion > pelicula.size() || opcion < 0){
            System.out.println("No existe ese actor.");
            return false;
        }

        if(opcion == 0){
            System.out.println("Saliendo...");
            return false;
        }

        Iterator <Pelicula> iterator = pelicula.iterator();
        while(iterator.hasNext()){
            Pelicula actor = iterator.next();
            if(opcion - 1 == pelicula.indexOf(actor)){
                iterator.remove();
                if(rolUsuario.equalsIgnoreCase("ROL_ADMIN")){
                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/datos/pelicula.dades", false));) {
                        out.writeObject(pelicula);
                        System.out.println("Pelicula eliminada.");
                        return true; //Salir del método
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/usuarios/" + usuario + "/peliculas.llista", false));) {
                        out.writeObject(pelicula);
                        System.out.println("Pelicula eliminada.");
                        return true; //Salir del método
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
        }

        return true;
    }

    public static boolean eliminarDirector(ArrayList<Director> directores, String rolUsuario, String usuario) {
        System.out.println("¿Qué actor quieres eliminar? (Introduce el número del actor que aparece en la lista, introduce 0 para salir)");
        Director.mostrarDirectores(directores);
        int opcion = sc.nextInt();
        sc.nextLine();

        if(opcion > directores.size() || opcion < 0){
            System.out.println("No existe ese actor.");
            return false;
        }

        if(opcion == 0){
            System.out.println("Saliendo...");
            return false;
        }

        Iterator <Director> iterator = directores.iterator();
        while(iterator.hasNext()){
            Director actor = iterator.next();
            if(opcion - 1 == directores.indexOf(actor)){
                iterator.remove();
                if(rolUsuario.equalsIgnoreCase("ROL_ADMIN")){
                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/datos/director.dades", false));) {
                        out.writeObject(directores);
                        System.out.println("Actor eliminado.");
                        return true; //Salir del método
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/usuarios/" + usuario + "/directores.llista", false));) {
                        out.writeObject(directores);
                        System.out.println("Actor eliminado.");
                        return true; //Salir del método
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
        }

        return true;
    }
}
