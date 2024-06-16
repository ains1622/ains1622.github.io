package com.mycompany.porcientodeporte;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String resultado = Usuario.agregar_usuario(username, password, email);

        response.setContentType("text/html");
        response.getWriter().write("<html><body>");
        if (resultado.contains("EXITO")) {
            response.getWriter().write("<h2>Registro exitoso</h2>");
        } else {
            response.getWriter().write("<h2>Error en el registro: " + resultado + "</h2>");
        }
        response.getWriter().write("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("registro.html");
    }
}
