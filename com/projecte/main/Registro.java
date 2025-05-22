package com.projecte.main;

import com.projecte.Objetos.Usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
            if(!email.contains("@")){
                System.out.println("El email es incorrecto, inténtalo de nuevo.");
            }
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

            if(!contrasenyaUsuario.equals(confirmarContrasenya)){
                System.out.println("Las contraseñas no coinciden, inténtelo de nuevo.");
            }
        } while (!contrasenyaUsuario.equals(confirmarContrasenya));

        Usuario nuevoUsuario = new Usuario(nombreUsuario, apellidosUsuario, poblacionUsuario, email, fechaNacimientoUsuario, nicknameUsuario, contrasenyaUsuario);

        //Registrar el usuario en datosUsuarios.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("com/projecte/datos/datosUsuarios.txt", true))) { 
            writer.write(nuevoUsuario.guardarUsuario());
            writer.newLine();
        } catch (IOException e) {
            System.out.println(e);
        }

        //Registrar la contraseña del usuario en usuariosContras.txt
         try (BufferedWriter writer = new BufferedWriter(new FileWriter("com/projecte/datos/usuariosContras.txt", true))) { 
            writer.write(confirmarContrasenya);
            writer.newLine();
        } catch (IOException e) {
            System.out.println(e);
        }

        crearCarpetaUsuario();
    }

    public static void crearCarpetaUsuario(){

        //Obtener el nombre del directorio en base a al email y el id
        String ultimaLinea = "";
        String separarLinea [];
        try (BufferedReader archivoDatos = new BufferedReader(new FileReader("com/projecte/datos/datosUsuarios.txt"));) {
            String linea = ""; 
            while ((linea = archivoDatos.readLine()) != null) {
                ultimaLinea = linea;
            }

            separarLinea = ultimaLinea.split(":");
            archivoDatos.close();

            String cortarCorreo = separarLinea[4].split("@")[0]; //Cortamos el correo y cogemos la primera parte delante del @
            
            String nombreDirectorio = separarLinea[0] + cortarCorreo;
    
    
            File directorio = new File("com/projecte/usuarios/" + nombreDirectorio);
            if (directorio.mkdir()) {
                
                crearArchivosUsuario(nombreDirectorio);
            } else {
                System.out.println("No se ha podido crear el directorio.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearArchivosUsuario(String nombreDirectorio){

        try{
            String nombresArchivos [] = {"peliculas", "directores", "actores"};

            for (int i = 0; i < nombresArchivos.length; i++) {
                File archivo = new File("com/projecte/usuarios/" + nombreDirectorio + "/" + nombresArchivos[i] + ".llista");
                if(archivo.createNewFile()){
                    
                }else {
                    System.out.println("No es posible crear el archivo " + nombresArchivos[i] + ".llista");
                }
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

