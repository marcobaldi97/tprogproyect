<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="uytubeLogic.logica.DtListaReproduccion"%>
<%@ page import = "uytubeLogic.logica.DtVideo"%>
<%@ page import = "uytubeLogic.logica.SystemHandler.Privacidad"%>
<%@ page import = "uytubeLogic.logica.DtCanal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="error404.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../buscador.jsp" %>

<style>table{
	width: 100%;
	table-layout: fixed;
}
th {
	color: white;
	padding: 15px;
    text-align: left;
    border-bottom: 1px solid #ddd;
    background-color: #ff0000;
    color: white;
    vertical-align: text-top;
}
td {
    padding: 15px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}
tr:nth-child(even) {background-color: #f2f2f2;}</style>
<link rel="stylesheet" href="/media/styles/Busqueda.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultados De Consulta</title>
</head>
<body>


<table id="TablaContenidos">
<tr>
<th valign="top"> Tipo </th>
<th valign="top"> Nombre </th>
<th valign="top"> Propietario </th>

</tr>
	<%
		DtVideo[] vid = (DtVideo[]) request.getAttribute("videos");
		for (DtVideo entry : vid) {
			String nombreV=entry.getNombre();
			String descV=entry.getDescripcion();
			String propietarioV = entry.getPropietario();
			request.setAttribute("IDVideo", entry.getIDVideo().toString());
			request.setAttribute(nombreV, nombreV);
			if(entry.getPrivacidad().equals(Privacidad.PUBLICO)){
	%>
	<tr>
	<td>Video
	<form action="watch" method="get"> 
	<input type="hidden" name="opcion" value="ver">
	<input type="hidden" name="ID" value="<%=entry.getIDVideo()%>">
	<input type="submit" value="Ver Ahora"> </form> 
	</td>
	<td id="NombreTD"><%=nombreV%></td>
	<td id="PropietarioTD"><%=propietarioV %></td>
	</tr>
	
	<%
	}
		}		
		
	
		DtListaReproduccion[] listas=(DtListaReproduccion[]) request.getAttribute("listas");
		for(DtListaReproduccion entry: listas){
			if(entry.getPrivado().equals(Privacidad.PUBLICO)){
		%>
	<tr>
	<td>Lista de Reproduccion
	<form action="watch" method="get"> 
	<input type="hidden" name="opcion" value="consulta">
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