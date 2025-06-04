package com.projecte.menus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import com.projecte.Objetos.Actor;
import com.projecte.Objetos.Director;
import com.projecte.Objetos.Pelicula;


public class MenuOrdenacion {
    static Scanner scanner = new Scanner(System.in);

    public static boolean menuOrdenacion(ArrayList<Actor> actoresGlobales, ArrayList<Actor> actoresUsuario, ArrayList<Pelicula> peliculasGlobal, ArrayList<Pelicula> peliculasUsuario, ArrayList<Director> directoresGlobal, ArrayList<Director> directoresUsuario, int opcionMenu, String tipoListas){
        int opcion = 0;
        do {
            try {
                    System.out.println("\n===== Menú de ordenación ====\n1. Por título(Películas) o Por nombre(Actores y Directores)\n2. Por duración(Peliculas) o Por edad(Actores y Directores)\n3. Por año y título(Pelicula) o Por edad y nombre(Actores y Directores)\n4. Salir");
                    System.out.print("Seleccione una opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un número válido.");
                    scanner.nextLine();
                    continue;
                }

                switch (opcion) {
                    case 1: // Ordenarpor título/nombre
                        if(tipoListas.equalsIgnoreCase("global")){
                            if(opcionMenu == 1){
                                listaACtorOrdenadaNombre(actoresGlobales);
                            } else if(opcionMenu == 2){
                                listaPeliculaOrdenadaTitulo(peliculasGlobal);
                            } else {
                                listaDirectoresOrdenadaNombre(directoresGlobal);
                            }
                        } else {
                            if(opcionMenu == 1){
                                listaACtorOrdenadaNombre(actoresUsuario);
                            } else if(opcionMenu == 2){
                                listaPeliculaOrdenadaTitulo(peliculasUsuario);
                            } else {
                                listaDirectoresOrdenadaNombre(directoresUsuario);
                            }
                        }
                        break;
                    case 2: //Ordenar por duración/edad
                        if(tipoListas.equalsIgnoreCase("global")){
                            if(opcionMenu == 1){
                                ArrayList<Actor> actoresOrdenar = actoresGlobales;
                                actoresOrdenar.sort(new Comparator<Actor> (){
                                    @Override
                                    public int compare(Actor actorUno, Actor actorDos) {
                                        return Integer.compare(actorUno.getEdad(), actorDos.getEdad());
                                    }
                                });

                                System.out.println("\nActores globales ordenados por nombre:");
                                for (Actor recorrerActores : actoresOrdenar) {
                                    System.out.println(recorrerActores);
                                }
                            } else if(opcionMenu == 2){
                                ArrayList<Pelicula> peliculasOrdenar = peliculasGlobal;
                                peliculasOrdenar.sort(new Comparator<Pelicula> (){
                                    @Override
                                    public int compare(Pelicula peliculaUno, Pelicula peliculaDos) {
                                        return Integer.compare(peliculaUno.getDuracionMinutos(), peliculaDos.getDuracionMinutos());
                                    }
                                });

                                System.out.println("\nPelículas globales ordenadas por duración:");
                                for (Pelicula recorrerPeliculas : peliculasOrdenar) {
                                    System.out.println(recorrerPeliculas);
                                }
                            } else {
                                ArrayList<Director> directoresOrdenar = directoresGlobal;
                                directoresOrdenar.sort(new Comparator<Director> (){
                                    @Override
                                    public int compare(Director directorUno, Director directorDos) {
                                        return Integer.compare(directorUno.getEdad(), directorDos.getEdad());
                                    }
                                });

                                System.out.println("\nDirectores globales ordenados por nombre:");
                                for (Director recorrerDirectores : directoresOrdenar) {
                                    System.out.println(recorrerDirectores);
                                }
                            }
                        } else {
                            if(opcionMenu == 1){
                                ArrayList<Actor> actoresOrdenar = actoresUsuario;
                                actoresOrdenar.sort(new Comparator<Actor> (){
                                    @Override
                                    public int compare(Actor actorUno, Actor actorDos) {
                                        return Integer.compare(actorUno.getEdad(), actorDos.getEdad());
                                    }
                                });

                                System.out.println("\nActores ordenados por nombre:");
                                for (Actor recorrerActores : actoresOrdenar) {
                                    System.out.println(recorrerActores.mostrarDetalles());
                                }
                            } else if(opcionMenu == 2){
                                ArrayList<Pelicula> peliculasOrdenar = peliculasUsuario;
                                peliculasOrdenar.sort(new Comparator<Pelicula> (){
                                    @Override
                                    public int compare(Pelicula peliculaUno, Pelicula peliculaDos) {
                                        return Integer.compare(peliculaUno.getDuracionMinutos(), peliculaDos.getDuracionMinutos());
                                    }
                                });

                                System.out.println("\nPelículas ordenadas por duración:");
                                for (Pelicula recorrerPeliculas : peliculasOrdenar) {
                                    System.out.println(recorrerPeliculas.mostrarDetalles());
                                }
                            } else {
                                ArrayList<Director> directoresOrdenar = directoresUsuario;
                                directoresOrdenar.sort(new Comparator<Director> (){
                                    @Override
                                    public int compare(Director directorUno, Director directorDos) {
                                        return Integer.compare(directorUno.getEdad(), directorDos.getEdad());
                                    }
                                });

                                System.out.println("\nDirectores ordenados por nombre:");
                                for (Director recorrerDirectores : directoresOrdenar) {
                                    System.out.println(recorrerDirectores.mostrarDetalles());
                                }
                            }
                        }
                        break;
                    case 3:
                        if(tipoListas.equalsIgnoreCase("global")){
                            if(opcionMenu == 1){
                                listaACtorOrdenadaEdadyNombre(actoresGlobales);
                            } else if(opcionMenu == 2){
                                listaPeliculaOrdenadaAnyoYTitulo(peliculasGlobal);
                            } else {
                                listaDirectoresOrdenadaEdadYNombre(directoresGlobal);
                            }
                        } else {
                            if(opcionMenu == 1){
                                listaACtorOrdenadaEdadyNombre(actoresUsuario);
                            } else if(opcionMenu == 2){
                                listaPeliculaOrdenadaAnyoYTitulo(peliculasUsuario);
                            } else {
                                listaDirectoresOrdenadaEdadYNombre(directoresUsuario);
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                        break;
                }
        } while (opcion != 4);
        return true;
    }

    /* Ordenar por un elemento */
    public static void listaPeliculaOrdenadaTitulo(ArrayList<Pelicula> peliculas){
        ArrayList<Pelicula> peliculasOrdenar = peliculas;
        Collections.sort(peliculasOrdenar);

        System.out.println("\nLista de películas ordenadas por título:");
        Iterator<Pelicula> iteratorPelicula = peliculasOrdenar.iterator();
        while (iteratorPelicula.hasNext()) {
            System.out.println(iteratorPelicula.next().mostrarDetalles());
        }
    }

    public static void listaACtorOrdenadaNombre(ArrayList<Actor> actores){
        ArrayList<Actor> actoresOrdenar = actores;
        Collections.sort(actoresOrdenar);

        System.out.println("\nLista de películas ordenadas por título:");
        Iterator<Actor> iteratorActor = actoresOrdenar.iterator();
        while (iteratorActor.hasNext()) {
            System.out.println(iteratorActor.next().mostrarDetalles());
        }
    }

    public static void listaDirectoresOrdenadaNombre(ArrayList<Director> directores){
        ArrayList<Director> directoresOrdenar = directores;
        Collections.sort(directoresOrdenar);

        System.out.println("\nLista de películas ordenadas por título:");
        Iterator<Director> iteratorDirector = directoresOrdenar.iterator();
        while (iteratorDirector.hasNext()) {
            System.out.println(iteratorDirector.next().mostrarDetalles());
        }
    }

    /* Clase anónima para controlar la duración de las peliculas */
    public static int ordenarPorDuracion(ArrayList<Pelicula> peliculas){
        ArrayList<Pelicula> peliculasOrdenar = peliculas;
            peliculasOrdenar.sort(new Comparator<Pelicula> (){
                @Override
                public int compare(Pelicula peliculaUno, Pelicula peliculaDos) {
                    return Integer.compare(peliculaUno.getDuracionMinutos(), peliculaDos.getDuracionMinutos());
                }
            });
         
            return 0;
    }

    /* Ordenar por múltiples parámetros */
    public static void listaPeliculaOrdenadaAnyoYTitulo(ArrayList<Pelicula> peliculas){
        ArrayList<Pelicula> peliculasOrdenar = peliculas;
        peliculasOrdenar.sort(Pelicula.porAnyoYTitulo());

        System.out.println("\nLista de películas ordenadas por año de salida y título:");
        Iterator<Pelicula> iteratorPelicula = peliculasOrdenar.iterator();
        while (iteratorPelicula.hasNext()) {
            System.out.println(iteratorPelicula.next().mostrarDetalles());
        }
    }

    public static void listaACtorOrdenadaEdadyNombre(ArrayList<Actor> actores){
        ArrayList<Actor> actoresOrdenar = actores;
        actoresOrdenar.sort(Actor.porEdadYNombre());

        System.out.println("\nLista de actores ordenadas por edad y nombre:");
        Iterator<Actor> iteratorActor = actoresOrdenar.iterator();
        while (iteratorActor.hasNext()) {
            System.out.println(iteratorActor.next().mostrarDetalles());
        }
    }

    public static void listaDirectoresOrdenadaEdadYNombre(ArrayList<Director> directores){
        ArrayList<Director> directoresOrdenar = directores;
        directoresOrdenar.sort(Director.porEdadYNombre());

        System.out.println("\nLista de directores ordenadas por edad y nombre:");
        Iterator<Director> iteratorDirector = directoresOrdenar.iterator();
        while (iteratorDirector.hasNext()) {
            System.out.println(iteratorDirector.next().mostrarDetalles());
        }
    }
}

