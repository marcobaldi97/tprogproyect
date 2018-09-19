<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="consultaCategoria.css">
<meta charset="ISO-8859-1">
<title>UyTube</title>
</head>
<body>
	Seleccione una categoria:
	<select style="width:25%" name="cmbCategoria">
		  <option value="cat1">cat1</option>
          <option value="cat2">cat2</option>
          <option value="cat3">cat3</option>
          <option value="cat4">cat4</option>
	</select>
	<br><br><br>
	Videos:
	<br>
	<table style="width:35%" name='tableVideo'>
		<tr>
		    <th>Nombre</th>
		    <th>Propietario</th> 
		</tr>
	</table>
	<br><br><br>
	Listas de Reproduccion:
	<table style="width:35%" name='tableListas'>
		<tr>
		    <th>Nombre</th>
		    <th>Propietario</th> 
		</tr>
	</table>
</body>
</html>