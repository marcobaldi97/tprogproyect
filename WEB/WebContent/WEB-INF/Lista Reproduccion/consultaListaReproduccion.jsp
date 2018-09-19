<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="consultaListaReproduccion.css">

<meta charset="ISO-8859-1">
<title>UyTube</title>
</head>
<body>
	Seleccione una lista:
	<select style="width:25%" name="cmbLista">
		  <option value="l1">l1</option>
          <option value="l2">l2</option>
          <option value="l3">l3</option>
          <option value="l4">l4</option>
	</select>
	<br><br><br>
	<form>
  		Nombre:
  		<input type="text" name="nombreLIsta" disabled><br>
  		<br>
  		Categorias:<br>
  		<ul style="list-style-type:disc">
	  	<li>cat1</li>
	  	<li>cat2</li>
	  	<li>cat3</li>
		</ul>
		Video:<br>
  		<select style="width:25%" name="cmbVideo">
		  <option value="v1">v1</option>
          <option value="v2">v2</option>
          <option value="v3">v3</option>
          <option value="v4">v4</option>
		</select>
		<input type="submit" value="Ver Detalles">
	</form>
	<br>
	
	
</body>
</html>