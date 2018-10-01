<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="uytubeLogic.logica.DtListaReproduccion"%>
<%@ page import = "uytubeLogic.logica.DtVideo"%>
<%@ page import = "uytubeLogic.logica.SystemHandler.Privacidad"%>
<%@ page import = "uytubeLogic.logica.DtCanal"%>

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


<table id="TablaContenidos">
<tr>
<th valign="top"> Tipo </th>
<th valign="top"> Nombre </th>
<th valign="top"> Propietario </th>

</tr>
	
	
		<%
		DtListaReproduccion[] listas=(DtListaReproduccion[]) request.getAttribute("listarListasReproduccion");
		for(DtListaReproduccion entry: listas){
			if(entry.getPrivado().equals(Privacidad.PUBLICO)){	
		%>
	<tr>
	<td>Lista de Reproduccion
	<form action="playlist" method="get"> 
	<input type="hidden" name="action" value="details">
	<input type="hidden" name="nameList" value="<%=entry.getNombre()%>">
	<input type="hidden" name="ownerList" value="<%=entry.getPropietario() %>">
	<input type="submit" value="Ver Info"> </form> 
	</td>
	<td id="NombreTD"><%=entry.getNombre()%></td>
	<td id="PropietarioTD"><%=entry.getPropietario() %></td>
	</tr>
	
	<%	}
		}
	%>
		<tr>
		<td>
	
	
	
</tr>
</table>



</body>
</html>