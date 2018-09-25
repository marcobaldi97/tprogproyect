<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="media/styles/AltaUsuario.css">
	<meta charset="ISO-8859-1">
	<title>Alta Usuario</title>
	<%@include file="WEB-INF/buscador.jsp" %>
	
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script src="jquery.ui.datepicker-es.js"></script>
	
</head>
<body>

	<form  action="newUser" method ="post">
	  Nickname:<br>
	  <input type="text" name="nickname"><br>
	  Correo electronico:<br>
	  <input type="email" name="email"><br>
	  Nombre:<br>
	  <input type="text" name="nombre"><br>
	  Apellido:<br>
	  <input type="text" name="apellido"><br>
	  Contraseña:<br>
	  <input type="password" name="contrasenia"><br>
	  Confirmar Contraseña:<br>
	  <input type="password" name="contraseniaConfirmacion"><br>
	   <script type="text/javascript" src="fechaInput.js"></script>
	  Fecha nacimiento:<br>
	  <input type="text" id="datepicker" name="fecha_nacimiento"><br/>
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
	  	<select name="categoria">
		  <option value="cat1">cat1</option>
		  <option value="cat2">cat2</option>
		  <option value="cat3">cat3</option>
		  <option value="cat4">cat4</option>
		</select><br>

	 <button type="submit" id="crearUsuario" name="opcion" value="nuevoUsuario">Crear</button>
	  <input type="reset" value="Limpiar campos" name="boton_limpiar" class="input"><br>

	</form>
</body>
</html>