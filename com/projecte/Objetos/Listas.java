package com.projecte.Objetos;


import java.util.List;
import java.util.Scanner;

public class Listas {
    public void menuListasGenerales(List<Director> directores, List<Actor> actores, List<Pelicula> peliculas){
        Scanner scanner = new Scanner(System.in);
        Director director = new Director("Antuan", 19, "Venezuela", "Femenino");
        directores.add(director);


        System.out.println("\n--- Menú de las listas generales ---");
        System.out.println("1-Mostrar lista de directores\n2.Mostrar lista de actores\n3.Mostrar lista de películas");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 2:
                Actor.mostrarActores(actores);
                break;
            case 1:
                Director.mostrarDirectores(directores);
                break;
            case 3:
                Pelicula.mostrarPeliculas(peliculas);
                break;
        
            default:
                break;
        }
        
    }
}
