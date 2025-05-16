package com.projecte.main;

import com.projecte.Objetos.Usuario;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Registro {

    static Scanner sc = new Scanner(System.in);

    public static void registrarUsuario() {
        System.out.println("Por favor, indique su nombre:");
        String nombreUsuario = sc.nextLine();

        System.out.println("Por favor, indique sus apellidos:");
        String apellidosUsuario = sc.nextLine();
        System.out.println("Por favor, indique población donde reside:");
        String poblacionUsuario = sc.nextLine();
        System.out.println("Por favor, indique su email:");
        String email = sc.nextLine();
        System.out.println("Por favor, indique fecha de nacimiento:");
        String fechanacimientoUsuario = sc.nextLine(); //hacer una función que pille el datetime para el tema del nacimiento.
        System.out.println("¿Cuál será su Nickname?");
        String nicknameUsuario = sc.nextLine();
        System.out.println("¿Cuál será su contraseña?"); // Aqui entrará un búcle para asegurarse que poner bien dos veces la contraseña.

        String contrasenyaUsuario = sc.nextLine();

        Usuario nuevoUsuario = new Usuario(nombreUsuario, apellidosUsuario, poblacionUsuario, email, null, nicknameUsuario, contrasenyaUsuario);

        try {
            FileOutputStream fos = new FileOutputStream("../datos/datosUsuarios.txt");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(nuevoUsuario);
            out.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
