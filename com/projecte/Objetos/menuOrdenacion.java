package com.projecte.Objetos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class menuOrdenacion {

    public static void menu() {
    

        ArrayList<Pelicula> peliculas = new ArrayList<>();

        peliculas.add(new Pelicula("El viaje eterno", 2015, "Ciencia Ficción", "Laura Martínez", "2h 10min"));
        peliculas.add(new Pelicula("Sombras del pasado", 1998, "Drama", "Carlos Ramírez", "1h 45min"));
        peliculas.add(new Pelicula("Risa mortal", 2021, "Comedia negra", "Ana Gómez", "1h 37min"));
        

        Collections.sort(peliculas);


        System.out.println("1.- Por título");
        System.out.println("2. Por duración.");
        System.out.println("3. Por año y título.");

        Scanner sc = new Scanner(System.in);

        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
        Collections.sort(peliculas, Pelicula.ordenarPeliculaPorTitulo(peliculas));
                
                break;
            case 2:

                break;
        
            default:
                break;
        }
    }

    

    
}
