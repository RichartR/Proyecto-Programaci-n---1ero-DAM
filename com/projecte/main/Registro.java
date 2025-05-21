package com.projecte.main;

import com.projecte.Objetos.Usuario;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        
        String email;
        do {
            System.out.println("Por favor, indique su email (debe contener '@'):");
            email = sc.nextLine();
        } while (!email.contains("@"));
        
        Date fechaNacimientoUsuario = null;
        System.out.println("Por favor, indique fecha de nacimiento (dd/mm/yyyy):");
        boolean fechaCorrecta = false;
        do {
            try {
                fechaNacimientoUsuario = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
                fechaCorrecta = true;
            } catch (ParseException e) {
                System.out.println("Formato de fecha incorrecto, por favor, vuelva a intentarlo.");
            }
        } while (!fechaCorrecta);
        
        System.out.println("¿Cuál será su Nickname?");
        String nicknameUsuario = sc.nextLine();
        
        String contrasenyaUsuario, confirmarContrasenya;
        do {
            System.out.println("¿Cuál será su contraseña?");
            contrasenyaUsuario = sc.nextLine();
            System.out.println("Por favor, confirme su contraseña:");
            confirmarContrasenya = sc.nextLine();
        } while (!contrasenyaUsuario.equals(confirmarContrasenya));

        Usuario nuevoUsuario = new Usuario(nombreUsuario, apellidosUsuario, poblacionUsuario, email, fechaNacimientoUsuario, nicknameUsuario, contrasenyaUsuario);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\Deberes esta semana\\Proyecto-Programaci-n---1ero-DAM\\com\\projecte\\datos\\datosUsuarios.txt", true))) { //Cambiar el path obviamente, es que estaba testeando en mi PC ú3ù
            writer.write(nuevoUsuario.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println(e);
        }

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\Deberes esta semana\\Proyecto-Programaci-n---1ero-DAM\\com\\projecte\\datos\\usuariosContras.txt", true))) { //Cambiar el path obviamente, es que estaba testeando en mi PC ú3ù
            writer.write(confirmarContrasenya);
            writer.newLine();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

