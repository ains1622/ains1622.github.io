package com.mycompany.porcientodeporte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {

    private String username;
    private String password;
    private String correo;
    private boolean isAdmin;

    // Constructor vacío
    public Usuario() {
    }

    // Getters y setters para los atributos

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    // Método para validar usuario por nombre de usuario y contraseña
    public boolean validarUsuarioPorNombre() {
        Connection conexion = ConexionDB.Conectar();
        boolean esValido = false;

        if (conexion != null) {
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            try {
                String sql = "SELECT user_validate_password(?, ?)";
                statement = conexion.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, password);

                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    esValido = resultSet.getBoolean(1);
                    System.out.println("Valor obtenido: " + esValido);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    ConexionDB.Desconectar(conexion);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo obtener una conexión a la base de datos.");
        }

        return esValido;
    }

    // Método para agregar un nuevo usuario a la base de datos
    public String agregarUsuario() {
        Connection conexion = ConexionDB.Conectar();

        if (conexion != null) {
            PreparedStatement statement = null;
            try {
                String sql = "INSERT INTO usuarios (username, password, correo) VALUES (?, ?, ?)";
                statement = conexion.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, password);
                statement.setString(3, correo);

                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    return "Usuario agregado exitosamente";
                } else {
                    return "Error al agregar usuario";
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                return "ERROR: " + ex.getMessage();
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    ConexionDB.Desconectar(conexion);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            return "No se pudo obtener una conexión a la base de datos.";
        }
    }
}
