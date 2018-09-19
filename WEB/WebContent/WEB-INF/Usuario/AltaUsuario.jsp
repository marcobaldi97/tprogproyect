<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="AltaUsuario.css">
	<meta charset="ISO-8859-1">
	<title>Alta Usuario</title>
</head>
<body>
	<form>
	  Nickname:<br>
	  <input type="text" name="nickname"><br>
	  Correo electronico:<br>
	  <input type="email" name="correo_electronico"><br>
	  Nombre:<br>
	  <input type="text" name="nombre"><br>
	  Apellido:<br>
	  <input type="text" name="apellido"><br>
	  Contraseña:<br>
	  <input type="password" name="contrasenia"><br>
	  Confirmar Contraseña:<br>
	  <input type="password" name="contraseniaConfirmacion"><br>
	  Fecha nacimiento:<br>
	  <input type="date" name="fecha_nacimiento"><br>
	  Imagen(opcional):<br>
	  <input type="file" name="filename" accept="image/gif, image/jpeg, image/png"><br>
	  Nombre canal(opcional):<br>
	  <input type="text" name="nombre_canal"><br>
	  Descripcion:<br>
	  <input type="textarea" name="descripcion"><br>
	  Defina su privacidad:<br>
	  <input type="radio" name="privacidad" value="Privado">Privado
	  <input type="radio" name="privacidad" value="Publico">Publico<br>
	  Categoria(opcional)<br>
	  	<select>
		  <option value="cat1">cat1</option>
		  <option value="cat2">cat2</option>
		  <option value="cat3">cat3</option>
		  <option value="cat4">cat4</option>
		</select><br>
	  <input type="submit" value="Confirmar" name="boton_confirmacion">
	  <input type="reset" value="Limpiar campos" name="boton_limpiar"><br>
	</form>
</body>
</html>