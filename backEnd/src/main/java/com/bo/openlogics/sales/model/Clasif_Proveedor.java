package com.bo.openlogics.sales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: rloza
 * Date: 3/09/14
 * Time: 11:31
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "CLASIF_PROVEEDORES", schema = "SALESFORCE")
public class Clasif_Proveedor extends EntidadBase{

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento ;

    @Column(name = "DIRECCION")
    private String direccion ;

    @Column(name = "TELEFONO")
    private String telefono ;

    @Column(name = "FAX")
    private String fax ;

    @Column(name = "EMAIL")
    private String email ;

    @Column(name = "CONTACTO")
    private String contacto ;

    @Column(name = "CUENTA_PP")
    private String cuenta_pp ;

    @Column(name = "CUENTA_P")
    private String cuenta_p ;

    public Clasif_Proveedor(){

    }

    public Clasif_Proveedor(String nombre, String numeroDocumento, String direccion, String telefono, String fax, String email, String contacto, String cuenta_pp, String cuenta_p) {
        this.nombre = nombre;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fax = fax;
        this.email = email;
        this.contacto = contacto;
        this.cuenta_pp = cuenta_pp;
        this.cuenta_p = cuenta_p;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getnumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCuenta_pp() {
        return cuenta_pp;
    }

    public void setCuenta_pp(String cuenta_pp) {
        this.cuenta_pp = cuenta_pp;
    }

    public String getCuenta_p() {
        return cuenta_p;
    }

    public void setCuenta_p(String cuenta_p) {
        this.cuenta_p = cuenta_p;
    }
}
