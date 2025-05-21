package com.projecte.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
//logica para ver si el correo existe entre un try cax en un if, donde lea el archivo de los usuarios con un foreach
        //si lo encuentra entonces sigue a la contraseña, si no se lo vuelve a pedir y le marca el error con el try catch hasta
        //que añada un correo válido o se salga (si le da al 0.)

        //para analizar si la contraseña es correcta, se guardará el número de línea en el que se encuentra el correo,
        //y a apartir de ahi, se analizará con la columna de la contraseña, y si es igual se entonces se le da acceso, si no,
        //el usuario tendrá 5 intentos para poner la contraseña, si se agotan los intentos, se le echará del método.

public class Login {
    public void pedirDatos(){

        
        Scanner scanner = new Scanner(System.in);

        System.out.print("------Login usuario------");
        System.out.print ("Correo: ");
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

                
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        



        

    }
}
