<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Locale"%>
<%@ page import = "uytubeLogica.publicar.*"%>
<%@ page import = "uytubeLogica.publicar.Privacidad"%>
<%@ page import = "uytubeLogica.publicar.DtCanal"%>
<%@ page import = "uytubeLogica.publicar.DtCategoria"%>
<%@ page import = "uytubeLogica.publicar.DtVideoHistorial"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<%@include file="../buscador.jsp" %>
<%@include file="../cosasComunesDelHead.jsp" %>
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
<title>Historial</title>
</head>
<body>


<table id="TablaContenidos">
	<tr>
	<th valign="top"> Videos </th>
	<th valign="top"> Nombre </th>
	<th valign="top"> Propietario </th>
	<th valign="top"> Cantidad de Visitas </th>
	<th valign="top"> Ultima Visita </th>
	</tr>
	
	<%
		DtVideoHistorial[] listas = (DtVideoHistorial[]) request.getAttribute("historial");
		DateFormat goodDf = new SimpleDateFormat("EEEEE dd 'de' MMMMM 'del' yyyy",Locale.forLanguageTag("es-ES"));
		for(DtVideoHistorial entry: listas){
			
	%>
		
	<tr>
	<td>Video
	<form action="watch" method="get"> 
	<input type="hidden" name="opcion" value="ver">
	<input type="hidden" name="ID" value="<%=entry.getVideo().getIDVideo()%>">
	<input class="verAhora" type="submit" value="Ver Ahora"> </form> 
	</td>
	<td id="Nombre"><%=entry.getVideo().getNombre()%></td>
	<td id="Propietario"><%=entry.getVideo().getPropietario()%></td>
	<td id="Cantidad de visitas"><%= entry.getCantidadVisita()%></td>
	<td id="Ultima visita"><%= goodDf.format(entry.getUltimaVisita().getFecha().toGregorianCalendar().getTime())%></td>
	</tr>
	
	<%	}
		
	%>
		
</table>



</body>
</html>