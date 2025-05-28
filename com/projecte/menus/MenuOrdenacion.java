package com.projecte.menus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
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
                    System.out.println("\n===== Menú de ordenación ====\n1. Por título\n2. Por duración\n3. Por año + título\n4. Salir");
                    System.out.print("Seleccione una opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un número válido.");
                    scanner.nextLine();
                    continue;
                }

                switch (opcion) {
                    case 1:
                        if(tipoListas.equalsIgnoreCase("global")){
                            if(opcionMenu == 1){
                                System.out.println("Actores");
                            } else if(opcionMenu == 2){
                                Collections.sort(peliculasGlobal);
                            } else {
                                System.out.println("Directores");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Por duración");
                        break;
                    case 3:
                        System.out.println("Por año + título");
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
}
