package com.projecte.menus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuLogueado {
    static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenuLogueado(){ //Menú que aparece una vez ya estás logueado
        int opcion = 0;
        do {
            System.out.println("\n===== Bienvenido =====\n¿Qué desea hacer?\n1.- Ver listas\n2.- Añadir datos a una lista\n3.- Eliminar datos de una lista\n4.- Salir");
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
                    System.out.println("Ver");
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
}
