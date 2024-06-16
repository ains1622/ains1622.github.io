package com.mycompany.porcientodeporte;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registroServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String correo = req.getParameter("correo");
        String password = req.getParameter("password");

        // Lógica para agregar el usuario
        String resultado = Usuario.agregar_usuario(username, password, correo);

        // Configurar la respuesta
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("{\"status\":\"" + (resultado.contains("ERROR") ? "error" : "success") + "\",\"message\":\"" + resultado + "\"}");
    }
}
