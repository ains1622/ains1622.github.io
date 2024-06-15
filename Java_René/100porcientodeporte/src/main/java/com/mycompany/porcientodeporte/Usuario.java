/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porcientodeporte;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author robla
 */


public class Usuario {
    
    private static String username = "User1";
    private static String password = "contraseña";
    private String correo;
    private boolean isAdmin;
 
    public static boolean validar_usuario_nombre(){
        
         Connection conexion = ConexionDB.Conectar();
         boolean esValido;
         
        if (conexion != null) {
            try {
                // Crear un Statement para ejecutar la consulta
                Statement statement = conexion.createStatement();
                // Ejecutar la consulta SQL
                ResultSet resultSet = statement.executeQuery("SELECT user_validate_password('"+username+"','"+password+"')");
                
                // Iterar a través del ResultSet y almacenar el valor retornado
                while (resultSet.next()) {
                    // Suponiendo que la columna que quieres almacenar sea un entero
                    esValido = resultSet.getBoolean(1);
                    if (esValido){
                        System.out.println("Valor obtenido: TRUE");
                        return true;
                    }
                    else {
                        System.out.println("Valor obtenido: FALSE");
                        return false;
                    }
                }
                
                // Cerrar el ResultSet y el Statement
                resultSet.close();
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                // Cerrar la conexión
                ConexionDB.Desconectar(conexion);
            }
        } else {
            System.out.println("No se pudo obtener una conexión a la base de datos.");
        }
        
        return false;
    }
}
