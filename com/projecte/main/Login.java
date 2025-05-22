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
    public void pedirDatos() throws IOException{

        
        Scanner scanner = new Scanner(System.in);

        boolean correoValido = false;
        String correo;


        
        while (!correoValido) {
            System.out.print("------Login usuario------ (Pulsa 0 para salir.)");
            System.out.print ("Correo: ");
            correo = scanner.nextLine();

            if (correo.equals("0")) {
                System.out.print("Saliendo del login de usuarios.");
                return;
            }

            try  {
                FileReader archivo = new FileReader("../datos/datosUsuarios.txt");
                BufferedReader br = new BufferedReader(archivo);
                String linea;
                int contadorLinea = 0;
                boolean encontrado = false;
                int lineaCorreo = 0;

                while ((linea = br.readLine()) != null) {
                    String [] partes = linea.split(":");
                    if (partes[4].equals(correo)) {
                    lineaCorreo = contadorLinea;
                    encontrado = true;
                    break;
    
                    }
                    contadorLinea ++;
                }

                if (!encontrado) {
                   System.out.print("Correo no encontrado, por favor, ingrese un correo nuevo.");   
                } 
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Introduzca la contraseña del usuario");
            String constrasenya = scanner.nextLine();

            boolean contrasenyaValida = false;
            
            while (!contrasenyaValida) {
                try {
                    
                    FileReader archivo = new FileReader("../datos/usuariosContras.txt");
                    BufferedReader br = new BufferedReader(archivo);
                    String linea;
                    int intentos = 5;

                    while ((linea = br.readLine()) != null) {
                        while (intentos != 0) {
                            
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        



        

    }
}
