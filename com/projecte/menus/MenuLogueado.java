package com.projecte.menus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.Iterator;

import com.projecte.Objetos.Actor;
import com.projecte.Objetos.Director;
import com.projecte.Objetos.Listas;
import com.projecte.Objetos.Pelicula;

public class MenuLogueado {
    static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenuLogueado(String [] datos){ //Menú que aparece una vez ya estás logueado
        int opcion = 0;

        ArrayList<Actor> actoresGlobal = deserializeActorGlobal();
        ArrayList<Pelicula> peliculasGlobal = deserializePeliculaGlobal();
        ArrayList<Director> directoresGlobal = deserializeDirectorGlobal();
        ArrayList<Actor> actoresUsuario = deserializeActorUsuario(datos);
        ArrayList<Pelicula> peliculasUsuario = deserializePeliculaUsuario(datos);
        ArrayList<Director> directoresUsuario = deserializeDirectorUsuario(datos);

        if(datos[3].equalsIgnoreCase("ROL_USUARIO")){
            sincronizarListasUsuarios(actoresGlobal, actoresUsuario, peliculasGlobal, peliculasUsuario, directoresGlobal, directoresUsuario, datos[2]);
        } // Sincronizar las listas de los usuarios con las listas globales

        do {
            System.out.println("\n===== Bienvenido " + datos[0] + " " + datos[1] + " =====\n¿Qué desea hacer?\n1.- Ver listas generales\n2.- Mostrar lista general ordenada\n3.- Añadir datos a una lista general\n4.- Ver listas del usuario\n5.- Añadir datos a lista de usuario\n6.- Eliminar datos de una lista "  + (datos[3].equals("ROL_ADMIN") ? "general" : "del usuario" ) + "\n8.- Salir");
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
                case 1: //Menú de ver listas general
                    eleccionLista(actoresGlobal, actoresUsuario, peliculasGlobal, peliculasUsuario, directoresGlobal, directoresUsuario, opcion, datos);
                    break;
                case 2: //Menú para ordenar listas generales
                    eleccionLista(actoresGlobal, actoresUsuario, peliculasGlobal, peliculasUsuario, directoresGlobal, directoresUsuario, opcion, datos);
                    break;
                case 3: //Menú de añadir datos general
                    eleccionLista(actoresGlobal, actoresUsuario, peliculasGlobal, peliculasUsuario, directoresGlobal, directoresUsuario, opcion, datos);
                    break;
                case 4: //Menú de ver listas usuario
                    eleccionLista(actoresGlobal, actoresUsuario, peliculasGlobal, peliculasUsuario, directoresGlobal, directoresUsuario, opcion, datos);
                    break;
                case 5: //Menú de añadir datos usuario
                    eleccionLista(actoresGlobal, actoresUsuario, peliculasGlobal, peliculasUsuario, directoresGlobal, directoresUsuario, opcion, datos);
                    break;
                case 6: //Menú de eliminar datos
                    eleccionLista(actoresGlobal, actoresUsuario, peliculasGlobal, peliculasUsuario, directoresGlobal, directoresUsuario, opcion, datos);
                    break;
                case 7: //Menú de ordenación
                    eleccionLista(actoresGlobal, actoresUsuario, peliculasGlobal, peliculasUsuario, directoresGlobal, directoresUsuario, opcion, datos);
                    break;
                case 8: //Salir
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 7);
    }

    //SubMenú listas
    public static void eleccionLista(ArrayList<Actor> actoresGlobales, ArrayList<Actor> actoresUsuario, ArrayList<Pelicula> peliculasGlobal, ArrayList<Pelicula> peliculasUsuario, ArrayList<Director> directoresGlobal, ArrayList<Director> directoresUsuario, int opcion, String [] datos){
        int opcionTipo = 0;
        boolean salir = false;
        do {
            System.out.println("\n¿Qué lista quieres ver? [1. Actores / 2. Películas / 3. Directores / 4. Salir]");
            try {
                opcionTipo = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número válido.");
                scanner.nextLine();
                continue;
            }
            String tipoListas = "";
            switch (opcionTipo) {
                case 1: //Actores
                    switch (opcion) {
                        case 1: //Ver lista global
                            Actor.mostrarActores(actoresGlobales);
                            salir = true;
                            break;
                        case 2: //Ordenar datos global
                            tipoListas = "global";
                            if(MenuOrdenacion.menuOrdenacion(actoresGlobales, actoresUsuario, peliculasGlobal, peliculasUsuario, directoresGlobal, directoresUsuario, opcionTipo, tipoListas)){
                                salir = true;
                            }
                            break;
                        case 3: //Añadir datos global
                            if(Listas.crearActor(actoresGlobales)){
                                salir = true;
                            }
                            break;
                        case 4: //Ver lista usuario
                            Actor.mostrarActores(actoresUsuario);
                            salir = true;
                            break;
                        case 5: 
                            tipoListas = "usuario";
                            if(MenuOrdenacion.menuOrdenacion(actoresGlobales, actoresUsuario, peliculasGlobal, peliculasUsuario, directoresGlobal, directoresUsuario, opcionTipo, tipoListas)){
                                salir = true;
                            }
                        case 6: //Añadir datos usuario
                            if(Listas.anyadirActor(actoresUsuario, actoresGlobales, datos[2])){
                                salir = true;
                            }
                            break;
                        case 7: //Eliminar datos
                        if(datos[3].equals("ROL_ADMIN")){ 
                            if(Listas.eliminarActor(actoresGlobales)){
                                salir = true;
                            }
                        } else {
                            // Falta el método eliminar de la lista del usuario
                        }
                        default:
                            break;
                    }
                    break;
                case 2: //Películas
                    switch (opcion) {
                        case 1: //Ver lista global
                            Pelicula.mostrarPeliculas(peliculasGlobal);
                            salir = true;
                            break;
                        case 2:
                            break;
                        case 3: //Añadir datos global
                            if (Listas.crearPelicula(peliculasGlobal)) {
                                salir = true;
                            };
                            break;
                        case 4: //Ver lista usuario
                            Pelicula.mostrarPeliculas(peliculasUsuario);
                            salir = true;
                            break;
                        case 5: //Añadir datos usuario
                            if(Listas.anyadirPelicula(peliculasUsuario, peliculasGlobal, datos[2])){
                                salir = true;
                            }
                            break;
                        case 6: //Eliminar datos
                            if(datos[3].equals("ROL_ADMIN")){
                                if(Listas.eliminarPelicula(peliculasGlobal)){
                                    salir = true;
                                } else{

                                }
                            }
                        default:
                            break;
                    }
                    break;
                case 3: //Directores
                    switch (opcion) {
                        case 1: //Ver lista global
                            Director.mostrarDirectores(directoresGlobal);
                            salir = true;
                            break;
                        case 2:
                            break;
                        case 3: //Añadir datos global
                            if(Listas.crearDirector(directoresGlobal)){
                                salir = true;
                            }
                            break;
                        case 4: //Ver lista usuario
                            Director.mostrarDirectores(directoresUsuario);
                            salir = true;
                            break;
                        case 5: //Añadir datos usuario
                            if(Listas.anyadirDirector(directoresUsuario, directoresGlobal, datos[2])){
                                salir = true;
                            }
                            break;
                        case 6: //Eliminar datos
                            if(datos[3].equals("ROL_ADMIN")){
                                if(Listas.eliminarDirector(directoresGlobal)){
                                    salir = true;
                                } else{
                                    
                                }
                            }
                        default:
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!salir);

    }

    //Deserializar listas globales
    public static ArrayList<Actor> deserializeActorGlobal() {
        ArrayList<Actor> actores = new ArrayList<>(); // Devuelve el array vacío por defecto
    
        File file = new File("com/projecte/datos/actor.dades");
        if (!file.exists() || file.length() == 0) {
            // Si el archivo no existe o está vacío, devolvemos el array vacío
            return actores;
        }
    
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            actores = (ArrayList<Actor>) in.readObject();
        } catch (Exception e) {
            System.out.println("Error al deserializar: " + e.getMessage());
            e.printStackTrace();
        }
    
        return actores;
    }
    
    public static ArrayList<Pelicula> deserializePeliculaGlobal(){
        ArrayList<Pelicula> peliculas = new ArrayList<>(); // Devuelve el array vacío por defecto

        File file = new File("com/projecte/datos/pelicula.dades");
        if (!file.exists() || file.length() == 0) {
            // Si el archivo no existe o está vacío, devolvemos el array vacío
            return peliculas;
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            peliculas = (ArrayList<Pelicula>) in.readObject();
        } catch (Exception e) {
            System.out.println("Error al deserializar: " + e.getMessage());
            e.printStackTrace();
        }
    
        return peliculas;
    }

    public static ArrayList<Director> deserializeDirectorGlobal(){
        ArrayList<Director> directores = new ArrayList<>(); // Devuelve el array vacío por defecto

        File file = new File("com/projecte/datos/director.dades");
        if (!file.exists() || file.length() == 0) {
            // Si el archivo no existe o está vacío, devolvemos el array vacío
            return directores;
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            directores = (ArrayList<Director>) in.readObject();
        } catch (Exception e) {
            System.out.println("Error al deserializar: " + e.getMessage());
            e.printStackTrace();
        }
    
        return directores;
    }

    //Deserializar listas usuario
    public static ArrayList<Actor> deserializeActorUsuario(String [] datos) {
        ArrayList<Actor> actores = new ArrayList<>(); // Devuelve el array vacío por defecto
    
        File file = new File("com/projecte/usuarios/" + datos[2] + "/actores.llista");
        if (!file.exists() || file.length() == 0) {
            // Si el archivo no existe o está vacío, devolvemos el array vacío
            return actores;
        }
    
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            actores = (ArrayList<Actor>) in.readObject();
        } catch (Exception e) {
            System.out.println("Error al deserializar: " + e.getMessage());
            e.printStackTrace();
        }
    
        return actores;
    }
    
    public static ArrayList<Pelicula> deserializePeliculaUsuario(String [] datos){
        ArrayList<Pelicula> peliculas = new ArrayList<>(); // Devuelve el array vacío por defecto

        File file = new File("com/projecte/usuarios/" + datos[2] + "/peliculas.llista");
        if (!file.exists() || file.length() == 0) {
            // Si el archivo no existe o está vacío, devolvemos el array vacío
            return peliculas;
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            peliculas = (ArrayList<Pelicula>) in.readObject();
        } catch (Exception e) {
            System.out.println("Error al deserializar: " + e.getMessage());
            e.printStackTrace();
        }
    
        return peliculas;
    }

    public static ArrayList<Director> deserializeDirectorUsuario(String [] datos){
        ArrayList<Director> directores = new ArrayList<>(); // Devuelve el array vacío por defecto

        File file = new File("com/projecte/usuarios/" + datos[2] + "/directores.llista");
        if (!file.exists() || file.length() == 0) {
            // Si el archivo no existe o está vacío, devolvemos el array vacío
            return directores;
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            directores = (ArrayList<Director>) in.readObject();
        } catch (Exception e) {
            System.out.println("Error al deserializar: " + e.getMessage());
            e.printStackTrace();
        }
    
        return directores;
    }

    /* Sincronizar los cambios de las listas generales */
    public static void sincronizarListasUsuarios(ArrayList<Actor> actoresGlobales, ArrayList<Actor> actoresUsuario, ArrayList<Pelicula> peliculasGlobales, ArrayList<Pelicula> peliculasUsuario, ArrayList<Director> directoresGlobales, ArrayList<Director> directoresUsuario, String usuario) {
        // Sincronizar Actores
        Iterator<Actor> itActor = actoresUsuario.iterator();
        while (itActor.hasNext()) {
            Actor actor = itActor.next();
            if (!actoresGlobales.contains(actor)) {
                itActor.remove();
            }
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/usuarios/" + usuario + "/actores.llista", false))) {
            out.writeObject(actoresUsuario);
        } catch (IOException e) {
            System.out.println("Problema: " + e);
        }

        // Sincronizar Películas
        Iterator<Pelicula> itPelicula = peliculasUsuario.iterator();
        while (itPelicula.hasNext()) {
            Pelicula pelicula = itPelicula.next();
            if (!peliculasGlobales.contains(pelicula)) {
                itPelicula.remove();
            }
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/usuarios/" + usuario + "/peliculas.llista", false))) {
            out.writeObject(peliculasUsuario);
        } catch (IOException e) {
            System.out.println("Problema: " + e);
        }

        // Sincronizar Directores
        Iterator<Director> itDirector = directoresUsuario.iterator();
        while (itDirector.hasNext()) {
            Director director = itDirector.next();
            if (!directoresGlobales.contains(director)) {
                itDirector.remove();
            }
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com/projecte/usuarios/" + usuario + "/directores.llista", false))) {
            out.writeObject(directoresUsuario);
        } catch (IOException e) {
            System.out.println("Problema: " + e);
        }
    }
}
