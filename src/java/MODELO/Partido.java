/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

/**
 *
 * @author jdani
 */
public class Partido {

    private String nombre;
    private String siglas;
    private String logo;
    private int votos;

    public Partido() {
    }

    public Partido(String nombre, String siglas, String logo, int votos) {
        this.nombre = nombre;
        this.siglas = siglas;
        this.logo = logo;
        this.votos = votos;
    }

    public Partido(String siglas) {
        this.siglas = siglas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    @Override
    public String toString() {
        return "Partido{" + "nombre=" + nombre + ", siglas=" + siglas + ", logo=" + logo + ", votos=" + votos + '}';
    }
    
    
}
