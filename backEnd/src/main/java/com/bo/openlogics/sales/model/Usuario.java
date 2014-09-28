package com.bo.openlogics.sales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by json on 2/09/14.
 */

@Entity
@Table(name = "USUARIOS", schema = "SALESFORCE")
public class Usuario extends EntidadBase {

    @Column(name = "NOMBRE_USUARIO", length=10)
    private String nombreUsuario;

    @Column(name = "PASSWORD", length=10)
    private String password;

    @Column(name = "NOMBRE", length=50)
    private String nombres;

    @Column(name = "PATERNO", length=50)
    private String paterno;

    @Column(name = "MATERNO", length=50)
    private String materno;

    @Column(name = "EMAIL", length=50)
    private String zona;

    @Column(name = "ESTADO", length=10)
    private String estado;

    @Column(name = "ROL", length=50)
    private String rol;


    public Usuario() {
    }

    public Usuario(String nombreUsuario, String password, String nombres, String paterno, String materno, String zona, String estado, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombres = nombres;
        this.paterno = paterno;
        this.materno = materno;
        this.zona = zona;
        this.estado = estado;
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
