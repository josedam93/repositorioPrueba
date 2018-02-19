/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODELO.Partido;
import MODELO.VotacionesException;
import MODELO.Votante;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author jdani
 */
public class Operaciones {

    public void altaVotante(Votante ObjVotante, Connection Conexion) throws VotacionesException {
        //Alta con sentencia preparada.
        try {

            String ordenSQL = "INSERT INTO ciudadanos VALUES (null,?,?,?,?,?,'N')";
            PreparedStatement PrepSt = Conexion.prepareStatement(ordenSQL);
            PrepSt.setString(1, ObjVotante.getNombre());
            PrepSt.setString(2, ObjVotante.getApellidos());
            PrepSt.setString(3, ObjVotante.getNif());
            PrepSt.setString(4, ObjVotante.getPassword());
            PrepSt.setDate(5, java.sql.Date.valueOf(ObjVotante.getFecha_nac()));

            int rs = PrepSt.executeUpdate();

        } catch (SQLException Ex) {

            String mensaje = Ex.getMessage();
            int codigo = Ex.getErrorCode();
            String alerta = "Error: No se ha realizado el alta correctamente.";
            throw new VotacionesException(codigo, mensaje, alerta);

        }

    }

    public Votante verVotante(Votante ObjVotante, Connection _Conexion) throws VotacionesException {

        Votante Votante = null;
        try {
// Consulta con sentencia preparada (encriptación) .   
            PreparedStatement PrepStm = _Conexion.prepareStatement("SELECT * FROM ciudadanos WHERE nif= ? AND password=?");
            PrepStm.setString(1, ObjVotante.getNif());
            PrepStm.setString(2, ObjVotante.getPassword());
            ResultSet rs = PrepStm.executeQuery();

            if (rs.next()) {
                Votante = new Votante(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("nif"), rs.getString("password"), LocalDate.parse(rs.getString("fecha_nac")), rs.getString("votado"));

            }

            if (Votante == null) {

                throw new SQLException("error", "votante", 402);

            }

            if ("S".equals(Votante.getVotado())) {

                throw new SQLException("Error: no se puede votar más de una vez", "", 403);
            }

        } catch (SQLException Ex) {
            String mensajeError = Ex.getMessage();
            int codigoError = Ex.getErrorCode();
            String alertaError = "Error: no se puede acceder al usuario";
            throw new VotacionesException(codigoError, mensajeError, alertaError);
        }
        return Votante;

    }

    public ArrayList<Partido> obtenerPartidos(Connection Conexion) throws VotacionesException {

        ArrayList<Partido> ArrayListPartido = new ArrayList<Partido>();

        try {

            String ordenSQL = "SELECT * FROM partidos";
            PreparedStatement PrepSt = Conexion.prepareStatement(ordenSQL);
            ResultSet rs = PrepSt.executeQuery();

            while (rs.next()) {

                String nombrePartido = rs.getString("nombre");
                String siglasPartido = rs.getString("siglas");
                String logo = rs.getString("logotipo");
                int votos = rs.getInt("votos");

                Partido Partido = new Partido(nombrePartido, siglasPartido, logo, votos);
                ArrayListPartido.add(Partido);

            }
        } catch (SQLException Ex) {

            String mensajeError = Ex.getMessage();
            int codigoError = Ex.getErrorCode();
            String alertaError = "Error: no se han podido obtener los partidos";
            throw new VotacionesException(codigoError, mensajeError, alertaError);

        }

        return ArrayListPartido;
    }

    public void realizarVoto(Votante ObjVotante, Partido ObjPartido, Connection Conexion) throws VotacionesException, SQLException {

        try {

            Conexion.setAutoCommit(false);

            String ordenSQL = "UPDATE ciudadanos SET votado='S' WHERE nif=? AND clave =?";
            PreparedStatement PrepSt = Conexion.prepareStatement(ordenSQL);
            PrepSt.setString(1, ObjVotante.getNif());
            PrepSt.setString(2, ObjVotante.getPassword());
            int rs = PrepSt.executeUpdate();

            String ordenSQL2 = "UPDATE partidos SET votos_partido=votos_partido+1 WHERE siglas = ?";
            PreparedStatement PrepStm = Conexion.prepareStatement(ordenSQL2);
            PrepStm.setString(1, ObjPartido.getSiglas());
            int rst = PrepStm.executeUpdate();

            if (rst == 0) {

                throw new SQLException("No se pudo añadir el voto", "votacion", 405);

            }
            Conexion.commit();

        } catch (SQLException Ex) {

            Conexion.rollback();

        }

    }
    public ArrayList<Votante> obtenerCenso(Connection Conexion) throws VotacionesException {

        ArrayList<Votante> ArrayListVotante = new ArrayList<Votante>();

        try {

            String ordenSQL = "SELECT * FROM ciudadanos";
            PreparedStatement PrepSt = Conexion.prepareStatement(ordenSQL);
            ResultSet rs = PrepSt.executeQuery();

            while (rs.next()) {

                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String nif = rs.getString("nif");
                String votado = rs.getString("votado");
                LocalDate fechaNac = rs.getDate("fecha_nac").toLocalDate();

                Votante Votante = new Votante(nombre, apellidos, nif, fechaNac, votado);
                ArrayListVotante.add(Votante);

            }
        } catch (SQLException Ex) {

            String mensajeError = Ex.getMessage();
            int codigoError = Ex.getErrorCode();
            String alertaError = "Error: no se ha podido obtener el censo de las elecciones.";
            throw new VotacionesException(codigoError, mensajeError, alertaError);

        }

        return ArrayListVotante;
    }
}
