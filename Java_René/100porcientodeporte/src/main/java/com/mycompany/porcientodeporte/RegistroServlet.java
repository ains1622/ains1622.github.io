package com.mycompany.porcientodeporte;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Obtener parámetros del formulario
        String username = request.getParameter("username");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        // Crear una instancia de Usuario y establecer los datos ingresados
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setCorreo(correo);
        usuario.setPassword(password);

        // Llamar a los métodos en Usuario para validar y agregar usuario
        boolean esValido = usuario.validarUsuarioPorNombre();
        String resultado = usuario.agregarUsuario();

        // Preparar respuesta HTML según el resultado del registro
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Resultado de Registro</title></head><body>");
        out.println("<h1>Resultado de Registro</h1>");
        if (esValido && resultado.equals("Usuario agregado exitosamente")) {
            out.println("<p>Registro exitoso para usuario: " + username + "</p>");
            out.println("<p><a href='registro-exitoso.html'>Volver</a></p>");
        } else {
            out.println("<p>Error durante el registro: " + resultado + "</p>");
            out.println("<p><a href='registro-error.html'>Volver</a></p>");
        }
        out.println("</body></html>");
    }
}
