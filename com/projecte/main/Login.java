package com.projecte.main;

import java.util.Scanner;

public class Login {
    public void pedirDatos(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("------Login usuario------");
        System.out.print ("Correo: ");
        String correo = scanner.nextLine();
        //logica para ver si el correo existe entre un try cax en un if, donde lea el archivo de los usuarios con un foreach
        //si lo encuentra entonces sigue a la contraseña, si no se lo vuelve a pedir y le marca el error con el try catch hasta
        //que añada un correo válido o se salga (si le da al 0.)

        System.out.println("Contraseña: ");
        String contrasenya = scanner.nextLine();

        //para analizar si la contraseña es correcta, se guardará el número de línea en el que se encuentra el correo,
        //y a apartir de ahi, se analizará con la columna de la contraseña, y si es igual se entonces se le da acceso, si no,
        //el usuario tendrá 5 intentos para poner la contraseña, si se agotan los intentos, se le echará del método.
        



        

    }
}
