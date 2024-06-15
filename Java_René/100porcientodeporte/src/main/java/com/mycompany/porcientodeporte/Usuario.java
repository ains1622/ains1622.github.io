package com.mycompany.porcientodeporte;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Usuario {

    public static boolean validar_usuario_nombre(String username, String password) {
        Connection conexion = ConexionDB.Conectar();
        boolean esValido;

        if (conexion != null) {
            try {
                Statement statement = conexion.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT user_validate_password('" + username + "','" + password + "')");

                while (resultSet.next()) {
                    esValido = resultSet.getBoolean(1);
                    if (esValido) {
                        System.out.println("Valor obtenido: TRUE");
                        return true;
                    } else {
                        System.out.println("Valor obtenido: FALSE");
                        return false;
                    }
                }

                resultSet.close();
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                ConexionDB.Desconectar(conexion);
            }
        } else {
            System.out.println("No se pudo obtener una conexión a la base de datos.");
        }

        return false;
    }

    public static boolean validar_usuario_mail(String correo, String password) {
        Connection conexion = ConexionDB.Conectar();
        boolean esValido;

        if (conexion != null) {
            try {
                Statement statement = conexion.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT mail_validate_password('" + correo + "','" + password + "')");

                while (resultSet.next()) {
                    esValido = resultSet.getBoolean(1);
                    if (esValido) {
                        System.out.println("Valor obtenido: TRUE");
                        return true;
                    } else {
                        System.out.println("Valor obtenido: FALSE");
                        return false;
                    }
                }

                resultSet.close();
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                ConexionDB.Desconectar(conexion);
            }
        } else {
            System.out.println("No se pudo obtener una conexión a la base de datos.");
        }

        return false;
    }

    public static String agregar_usuario(String username, String password, String correo) {
        if (username == null || password == null || correo == null) return "ERROR: campos vacíos";

        Connection conexion = ConexionDB.Conectar();

        if (conexion != null) {
            try {
                Statement statement = conexion.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT agregar_usuario('" + username + "','" + password + "','" + correo + "');");

                if (resultSet.next()) {
                    String resultado = resultSet.getString(1);
                    resultSet.close();
                    statement.close();
                    return resultado;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                return "ERROR: " + ex.getMessage();
            } finally {
                ConexionDB.Desconectar(conexion);
            }
        } else {
            return "ERROR: No se pudo obtener una conexión a la base de datos.";
        }

        return "ERROR: desconocido";
    }
}
