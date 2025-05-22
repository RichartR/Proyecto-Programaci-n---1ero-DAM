package com.projecte.Objetos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombreUsuario;
    private String apellidosUsuario;
    private String poblacionUsuario;
    private String emailUsuario;
    private Date fechaNacimiento;
    private String nickname;
    private String contrasenya;
    private Rol rolUsuario;

    public Usuario(String nombreUsuario, String apellidosUsuario, String poblacionUsuario, String emailUsuario, Date fechaNacimiento,
            String nickname, String contrasenya) {
        this.id = this.calcularID();
        this.nombreUsuario = nombreUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.poblacionUsuario = poblacionUsuario;
        this.emailUsuario = emailUsuario;
        this.fechaNacimiento = fechaNacimiento;
        this.nickname = nickname;
        this.contrasenya = contrasenya;
        rolUsuario = Rol.ROL_USUARIO;
    }

    @Override
    public String toString() {
        return id + " - " + nombreUsuario + " - " + apellidosUsuario + " - " + poblacionUsuario + " - " + emailUsuario + " - " + nickname + " - " + contrasenya;
    }

    public int calcularID(){
        String ultimaLinea = "";
        try {
            String linea = "";
            BufferedReader archivoDatos = new BufferedReader(new FileReader("com/projecte/datos/datosUsuarios.txt"));
            while ((linea = archivoDatos.readLine()) != null) {
                ultimaLinea = linea;
            }

            String separarLinea [] = ultimaLinea.split(":");
            archivoDatos.close();
            return Integer.parseInt(separarLinea[0]) + 1;
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public String guardarUsuario(){
        return id + ":" + nombreUsuario + ":" + apellidosUsuario + ":" + poblacionUsuario + ":" + emailUsuario + ":" + nickname + ":" + rolUsuario;
    }
}
