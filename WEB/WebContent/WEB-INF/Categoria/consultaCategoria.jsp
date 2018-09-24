<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "uytubeLogic.logica.DtCategoria"%>
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
	
	<%
		DtCategoria[] cat= (DtCategoria[]) request.getAttribute("listarCategorias");
		for (DtCategoria entry : cat) {
			String nombreC=entry.getNombre();
			
	%>
		  <option value="null">Categorias...</option>
          <option value="<%=nombreC%>"><%=nombreC%></option>
     <%}%>     
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