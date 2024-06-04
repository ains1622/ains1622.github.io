<?php
// Conexión a la base de datos
$servername = "localhost"; // Cambia esto por tu servidor de base de datos
$username = "root"; // Cambia esto por tu nombre de usuario de MySQL
$password = "123456"; // Cambia esto por tu contraseña de MySQL
$database = "sys"; // Cambia esto por el nombre de tu base de datos

// Crear conexión
$conn = new mysqli($servername, $username, $password, $database);

// Verificar conexión
if ($conn->connect_error) {
    die("Error de conexión: " . $conn->connect_error);
}

// Consulta SQL para seleccionar nombres de la tabla usuarios
$sql = "SELECT nombre FROM usuarios";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // Imprimir nombres de usuarios
    while($row = $result->fetch_assoc()) {
        echo "<p>" . $row["nombre"] . "</p>";
    }
} else {
    echo "No se encontraron usuarios";
}

// Cerrar conexión
$conn->close();
?>
