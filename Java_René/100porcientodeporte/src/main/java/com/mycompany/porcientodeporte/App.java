package com.mycompany.porcientodeporte;

public class App {

    // Método para manejar la solicitud POST de registro desde un servidor web
    public static String manejarRegistro(String username, String correo, String password) {
        // Crear una instancia de Usuario y establecer los datos ingresados
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setCorreo(correo);
        usuario.setPassword(password);

        // Llamar a los métodos en Usuario para validar y agregar usuario
        boolean esValido = usuario.validarUsuarioPorNombre();
        String resultado = usuario.agregarUsuario();

        return resultado;
    }
}
