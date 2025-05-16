package com.projecte.Objetos;

public enum Rol {
    ROL_ADMIN("ROL_ADMIN"),
    ROL_USUARIO("ROL_USUARIO");

    /* Atributos */
    private String rol;

    /* Constructor */
    Rol(String rol){
        this.rol = rol;
    }

    /* Gettes y Setters */
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
