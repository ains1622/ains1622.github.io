/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porcientodeporte;

/**
 *
 * @author robla
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    
     // Configuración de la conexión
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "123456";

    // Método para establecer la conexión
    public static Connection Conectar() {
        Connection conexion = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
        }
        return conexion;
    }

    // Método para cerrar la conexión
    public static void Desconectar(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
    
}
