/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

 package com.mycompany.porcientodeporte;
 /**
  *
  * @author robla
  */
 public class App {
 
     public static void main(String[] args) {
         
         boolean validar_usuario = Usuario.validar_usuario_nombre("User2","contra2");
         String agregar_usuario = Usuario.agregar_usuario("User2","contra2","correo2@gmail.com");
         validar_usuario = Usuario.validar_usuario_mail("correo2@gmail.com","contra2");
         
     }
 }
 
 