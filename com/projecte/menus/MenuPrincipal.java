package com.projecte.menus;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.projecte.main.Login;
import com.projecte.main.Registro;

public class MenuPrincipal {
    static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenuPrincipal() throws IOException{
        int opcion = 0;
        do {
            System.out.println("\n===== Bienvenido =====\n¿Qué desea hacer?\n1.- Registrarme\n2.- Iniciar sesión\n3.- Salir");
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
                    System.out.println("\n");
                    Registro.registrarUsuario();
                    break;
                case 2:
                    System.out.println("\n");
                    String [] datos = Login.pedirDatos();
                    if(datos != null){
                        MenuLogueado.mostrarMenuLogueado(datos); //Menú que aparece cuando se confirma el log com.projecte.menus.MenuLogueado
                    }
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 3);
    }
}
