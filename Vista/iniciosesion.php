<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Lista de Tablas y Registros</title>
</head>
<body>
  <h1>Lista de Tablas y Registros</h1>

  <?php
  // Conexión a la base de datos
  $servername = "localhost";
  $username = "root";
  $password = "contraseña";
  $database = "nombre_de_la_base_de_datos";

  // Crear conexión
  $conn = new mysqli($servername, $username, $password, $database);

  // Verificar conexión
  if ($conn->connect_error) {
    die("Error de conexión: " . $conn->connect_error);
  }

  // Obtener lista de tablas
  $sql_tables = "SHOW TABLES";
  $result_tables = $conn->query($sql_tables);

  if ($result_tables->num_rows > 0) {
    // Iterar sobre cada tabla
    while($row_table = $result_tables->fetch_assoc()) {
      $table_name = $row_table['Tables_in_' . $database];
      echo "<h2>Tabla: $table_name</h2>";

      // Obtener registros de la tabla
      $sql_records = "SELECT * FROM $table_name";
      $result_records = $conn->query($sql_records);

      if ($result_records->num_rows > 0) {
        // Imprimir registros en una tabla
        echo "<table border='1'>";
        while($row_record = $result_records->fetch_assoc()) {
          echo "<tr>";
          foreach ($row_record as $key => $value) {
            echo "<td>$key: $value</td>";
          }
          echo "</tr>";
        }
        echo "</table>";
      } else {
        echo "No se encontraron registros en la tabla $table_name";
      }
    }
  } else {
    echo "No se encontraron tablas en la base de datos";
  }

  // Cerrar conexión
  $conn->close();
  ?>
</body>
</html>
