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

    public static String [] pedirDatos() throws IOException{

        Scanner scanner = new Scanner(System.in);

        boolean correoValido = false;
        String correo;

        while (!correoValido) {
            boolean encontrado = false;
            int contadorLinea = 0;
            String datosUsuario;

            String datosSeparados[] = new String[2];;

            System.out.print("------Login usuario------ (Pulsa 0 para salir.)");
            do {
                System.out.print ("\nCorreo: ");
            correo = scanner.nextLine();

            if (correo.equals("0")) {
                System.out.print("Saliendo del login de usuarios.");
                return null;
            }


            try  {
                FileReader archivo = new FileReader("com/projecte/datos/datosUsuarios.txt");
                BufferedReader br = new BufferedReader(archivo);
                String linea;
                int lineaCorreo = 0;

                while ((linea = br.readLine()) != null) {
                    String [] partes = linea.split(":");
                    if (partes[4].equals(correo)) {
                    lineaCorreo = contadorLinea;
                    encontrado = true;
                    datosUsuario = linea;
                    datosSeparados[0] = datosUsuario.split(":")[1];
                    datosSeparados[1] = datosUsuario.split(":")[2];
                    break;
                    
                }
                contadorLinea++;
                }

                if (!encontrado) {
                   System.out.print("Correo no encontrado, por favor, ingrese un correo nuevo.");   
                } 
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
            } while (!encontrado);
            
            boolean contrasenyaValida = false;
            int intentos = 5;
            
            while (!contrasenyaValida) {
                try {
                    System.out.print("\nIntroduzca la contraseña del usuario: ");
                    String contrasenya = scanner.nextLine();
                    
                    FileReader archivo = new FileReader("com/projecte/datos/usuariosContras.txt");
                    BufferedReader br = new BufferedReader(archivo);
                    String linea;

                    int lineasContrasenya = 0;

                    while ((linea = br.readLine()) != null) {
                        if(contadorLinea == lineasContrasenya && intentos != 0){
                            if(linea.equals(contrasenya)){
                                System.out.println("Las contraseñas coinciden.");
                                return datosSeparados;
                            } else {
                                System.out.println("Contraseña incorrecta inténtelo de nuevo. Intentos restantes " + (intentos - 1));
                                intentos--;
                                
                                if (intentos == 0) {
                                    System.out.println("Intentos excedidos, cerrando...");
                                    return null;
                                }

                                break;
                            }
                        } 
                        lineasContrasenya++;
                    }
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return null;
    }
}
