package com.projecte.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


        //y a apartir de ahi, se analizará con la columna de la contraseña, y si es igual se entonces se le da acceso, si no,
        //el usuario tendrá 5 intentos para poner la contraseña, si se agotan los intentos, se le echará del método.

        //!!Leer linea en la que está el correo y leer la misma linea del archivo usuariosContras.txt. si coincide, login!!

    public class Login {

        public static String[] pedirDatos() throws IOException {
            System.out.println("------Login usuario------ (Pulsa 0 para salir.)");
            Scanner scanner = new Scanner(System.in);
    
            String correo;
            String[] datosSeparados = new String[2];
            int lineaCorreo = -1;
    
            while (true) {
                System.out.print("Correo: ");
                correo = scanner.nextLine();
    
                if (correo.equals("0")) {
                    System.out.println("Saliendo del login de usuarios.");
                    return null;
                }
    
                boolean encontrado = false;
    
                // Buscar el correo en el archivo
                try (BufferedReader br = new BufferedReader(new FileReader("com/projecte/datos/datosUsuarios.txt"))) {
                    String linea;
                    int contadorLinea = 0;
    
                    while ((linea = br.readLine()) != null) {
                        String[] partes = linea.split(":");
                        if (partes.length > 4 && partes[4].equals(correo)) {
                            lineaCorreo = contadorLinea;
                            datosSeparados[0] = partes[1]; // nombre
                            datosSeparados[1] = partes[2]; // apellido
                            encontrado = true;
                            break;
                        }
                        contadorLinea++;
                    }
    
                    if (!encontrado) {
                        System.out.println("Correo no encontrado, por favor, ingrese un correo nuevo.");
                        continue;
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Archivo no encontrado: " + e.getMessage());
                    return null;
                }
    
                // Verificar contraseña
                int intentos = 5;
                while (intentos > 0) {
                    System.out.print("Introduzca la contraseña del usuario: ");
                    String contrasenya = scanner.nextLine();
    
                    try (BufferedReader br = new BufferedReader(new FileReader("com/projecte/datos/usuariosContras.txt"))) {
                        String linea;
                        int lineaActual = 0;
    
                        while ((linea = br.readLine()) != null) {
                            if (lineaActual == lineaCorreo) {
                                if (linea.equals(contrasenya)) {
                                    System.out.println("Las contraseñas coinciden.");
                                    return datosSeparados;
                                } else {
                                    intentos--;
                                    System.out.println("Contraseña incorrecta. Intentos restantes: " + intentos);
                                    if (intentos == 0) {
                                        System.out.println("Intentos excedidos, cerrando...");
                                        return null;
                                    }
                                    break;
                                }
                            }
                            lineaActual++;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Archivo no encontrado: " + e.getMessage());
                        return null;
                    }
                }
            }
        }
    }
