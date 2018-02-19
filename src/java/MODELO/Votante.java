/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.time.LocalDate;

/**
 *
 * @author jdani
 */
public class Votante {

    private String nombre;
    private String apellidos;
    private String nif;
    private String password;
    private LocalDate fecha_nac;
    private String votado;

    public Votante(String nombre, String apellidos, String nif, String password, LocalDate fecha_nac) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.password = password;
        this.fecha_nac = fecha_nac;
    }

    public Votante(String nombre, String apellidos, String nif, String password, LocalDate fecha_nac, String votado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.password = password;
        this.fecha_nac = fecha_nac;
        this.votado = votado;
    }

    public Votante(String nombre, String apellidos, String nif, LocalDate fecha_nac, String votado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.fecha_nac = fecha_nac;
        this.votado = votado;
    }
    

    public Votante(String nif, String password) {
        this.nif = nif;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getVotado() {
        return votado;
    }

    public void setVotado(String votado) {
        this.votado = votado;
    }

    @Override
    public String toString() {
        return "Votante{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", fecha_nac=" + fecha_nac + ", votado=" + votado + '}';
    }

   
}
