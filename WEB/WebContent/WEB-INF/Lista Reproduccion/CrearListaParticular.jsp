<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Lista Particular</title>
</head>
<body>
	<form action="newPlaylist" method="post">
	  Nombre de la lista<br>
	  <input type="text" name="nombreLista"><br>
	  Privacidad<br>
	  <input type="radio" name="grupoPrivacidad" value="Publico" checked>Publico<br>
	  <input type="radio" name="grupoPrivacidad" value="Privado">Privado<br>
	  <input type="hidden" name="action" value="crearLDR">
	  <button type="submit">Crear</button>
	  </form>
</body>
</html>