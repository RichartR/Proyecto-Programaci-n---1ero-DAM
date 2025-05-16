package com.projecte.Objetos;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int idReal = 0;
    private int id;
    private String nombreUsuario;
    private String apellidosUsuario;
    private String poblacionUsuario;
    private String emailUsuario;
    private Date fechaNacimiento;
    private String Nickname;
    private String contrasenya;

    public Usuario(String nombreUsuario, String apellidosUsuario, String poblacionUsuario, String emailUsuario, Date fechaNacimiento,
            String nickname, String contrasenya) {
            this.id = idReal++;
        this.nombreUsuario = nombreUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.poblacionUsuario = poblacionUsuario;
        this.emailUsuario = emailUsuario;
        this.fechaNacimiento = fechaNacimiento;
        Nickname = nickname;
        this.contrasenya = contrasenya;
        idReal++;
    }

}
