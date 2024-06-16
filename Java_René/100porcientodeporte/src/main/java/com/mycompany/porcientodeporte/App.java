package com.mycompany.porcientodeporte;

public class App {

    public static void main(String[] args) {
        // Ejemplo de cómo manejar el registro directamente desde App (sin servidor web)
        String username = "usuarioPrueba";
        String correo = "correo@example.com";
        String password = "contrasena123";

        // Crear una instancia de Usuario y establecer los datos
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setCorreo(correo);
        usuario.setPassword(password);

        // Llamar a los métodos en Usuario para validar y agregar usuario
        boolean esValido = usuario.validarUsuarioPorNombre();
        String resultado = usuario.agregarUsuario();

        System.out.println("Resultado del registro: " + resultado);
    }

    // Método para manejar la solicitud POST de registro desde un servidor web (ejemplo para ilustrar)
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
