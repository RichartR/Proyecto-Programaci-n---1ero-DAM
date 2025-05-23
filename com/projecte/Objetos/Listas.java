package com.projecte.Objetos;


import java.util.List;
import java.util.Scanner;

public class Listas {

    public void menuListaPersonal(String nombreCarpeta){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Menú de las listas generales ---");
        System.out.println("1-Mostrar lista de directores\n2.Mostrar lista de actores\n3.Mostrar lista de películas\n4.Salir");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) { //en las listas personales se  busca por el id de lo que busque la persona (actor,pelicula,director), si no lo encuentra
            //te devuelve al menú principal y te dice que el id no es válido
            case 2:
                Actor.mostrarActoresPersonal();
                break;
            case 1:
                Director.mostrarDirectoresPersonal();
                break;
            case 3:
                Pelicula.mostrarPeliculasPersonal();
                break;
            case 4:
            System.out.println("Volviendo al menú principal.\nSaliendo...");
            break;
            
        
            default: System.out.println("Opción no válida.");
                break;
        }
    }
    public void menuListasGenerales(List<Director> directores, List<Actor> actores, List<Pelicula> peliculas){
        Scanner scanner = new Scanner(System.in);
        Director director = new Director("Antuan", 19, "Venezuela", "Femenino");
        directores.add(director);


        System.out.println("\n--- Menú de las listas generales ---");
        System.out.println("1-Mostrar lista de directores\n2.Mostrar lista de actores\n3.Mostrar lista de películas\n4.Salir");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 2:
                Actor.mostrarActoresGenerales(actores);
                break;
            case 1:
                Director.mostrarDirectoresGenerales(directores);
                break;
            case 3:
                Pelicula.mostrarPeliculasGenerales(peliculas);
                break;
            case 4:
            System.out.println("Volviendo al menú.\nSaliendo...");
            break;
        
            default: System.out.println("Opción no válida.");
                break;
        }
        
    }
}
