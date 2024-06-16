package com.mycompany.porcientodeporte;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Usuario {

    public static String agregar_usuario(String username, String password, String correo) {
        if (username == null) return "ERROR: usuario no ingresado";
        else if (password == null) return "ERROR: contraseña no ingresada";
        else if (correo == null) return "ERROR: correo no ingresado";

        Connection conexion = ConexionDB.Conectar();

        if (conexion != null) {
            try {
                Statement statement = conexion.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT agregar_usuario('" + username + "','" + password + "','" + correo + "');");

                String resultado = "ERROR: desconocido";

                while (resultSet.next()) {
                    resultado = resultSet.getString(1);
                }

                resultSet.close();
                statement.close();
                return resultado;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                ConexionDB.Desconectar(conexion);
            }
        } else {
            System.out.println("No se pudo obtener una conexión a la base de datos.");
        }

        return "ERROR: desconocido";
    }
}
