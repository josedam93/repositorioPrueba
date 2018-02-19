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
public class VotacionesException extends Exception {

    private int codigo;
    private String mensaje;
    private String alerta;

    public VotacionesException(int codigo, String mensaje, String alerta) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.alerta = alerta;
    }

    @Override
    public String toString() {
        return "Exceptions{" + "codigo=" + codigo + ", mensaje=" + mensaje + ", alerta=" + alerta + '}';
    }
    
    
}
