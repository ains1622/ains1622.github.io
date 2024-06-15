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

    public static boolean validar_usuario_mail(){
        
        Connection conexion = ConexionDB.Conectar();
        boolean esValido;
        
       if (conexion != null) {
           try {
               // Crear un Statement para ejecutar la consulta
               Statement statement = conexion.createStatement();
               // Ejecutar la consulta SQL
               ResultSet resultSet = statement.executeQuery("SELECT mail_validate_password('"+correo+"','"+password+"')");
               
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
   
   public static String agregar_usuario( ){
       if(username==null) return "ERROR: usuario no ingresado";
       else if(password==null) return "ERROR: contraseña no ingresada";
       else if(correo==null) return "ERROR: correo no ingresado";
       
       Connection conexion = ConexionDB.Conectar();
        
       if (conexion != null) {
           try {
               // Crear un Statement para ejecutar la consulta
               Statement statement = conexion.createStatement();
               // Ejecutar la consulta SQL
               ResultSet resultSet = statement.executeQuery("SELECT agregar_usuario('"+username+"','"+password+"','"+correo+"');");
               
               String resultado;
               
               // Iterar a través del ResultSet y almacenar el valor retornado
               while (resultSet.next()) {
                   // Suponiendo que la columna que quieres almacenar sea un entero
                   resultado = resultSet.getString(1);
                   if (resultado.contains("ERROR")){
                       System.out.println("Valor obtenido: ERROR");
                       return resultado;
                   }
                   else {
                       System.out.println("Valor obtenido: EXITO");
                       return resultado;
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
       
       return "ERROR: desconocido";
       
   }
   
}
