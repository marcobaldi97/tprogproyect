<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="uytubeLogic.logica.DtListaReproduccion"%>
<%@ page import = "uytubeLogica.publicar.DtVideo"%>
<%@ page import = "uytubeLogica.publicar.Privacidad"%>
<%@ page import = "uytubeLogica.publicar.DtCanal"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="consultaListaReproduccion.css">

<meta charset="UTF-8">
<title>UyTube</title>
</head>
	<body>


<table id="TablaContenidos">
<tr>
<th valign="top"> Videos </th>
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
		
		
		<%
		if((DtListaReproduccion[]) request.getAttribute("listasPrivadasSesion")!=null){
		DtListaReproduccion[] listasPrivadas=(DtListaReproduccion[]) request.getAttribute("listasPrivadasSesion");
		for(DtListaReproduccion entry: listasPrivadas){
				
		%>
	<tr>
	<td>Lista de Reproduccion Privada
	<form action="playlist" method="get"> 
	<input type="hidden" name="action" value="details">
	<input type="hidden" name="nameList" value="<%=entry.getNombre()%>">
	<input type="hidden" name="ownerList" value="<%=entry.getPropietario() %>">
	<input type="submit" value="Ver Info">
	</form>
	<form action="modifyPlaylist" method="get"> 
	<input type="hidden" name="action" value="modify">
	<input type="hidden" name="nameList" value="<%=entry.getNombre()%>">
	<input type="hidden" name="ownerList" value="<%=entry.getPropietario() %>">
	<input type="submit" value="Modificar">
	</form>
	</td>
	<td id="NombreTD"><%=entry.getNombre()%></td>
	<td id="PropietarioTD"><%=entry.getPropietario() %></td>
	</tr>
	
	<%	
		}}
	%>
		<tr>
		<td>	
	
	
	
</tr>
</table>



</body>
</html>