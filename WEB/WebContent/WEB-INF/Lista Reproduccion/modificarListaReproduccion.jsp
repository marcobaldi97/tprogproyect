<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="uytubeLogic.logica.DtListaReproduccion"%>
<%@page import="uytubeLogic.logica.ListaReproduccion.TipoLista"%>
<%@ page import = "uytubeLogic.logica.DtVideo"%>
<%@ page import = "uytubeLogic.logica.SystemHandler.Privacidad"%>
<%@ page import = "uytubeLogic.logica.DtCanal"%>
<%@ page import = "uytubeLogic.logica.DtCategoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>Modificar Lista Reprodcuccion</title>
</head>
<body>

<% DtListaReproduccion infoLista = (DtListaReproduccion) request.getAttribute("infoLista"); 
	if(infoLista.getTipoLista().equals(TipoLista.PARTICULAR)){
%>

<div class="main-content">
	<form action="modifyPlaylist" method="get">
	  Privacidad<br>
	  <input type="radio" name="grupoPrivacidad" value="Publico" checked>Publico<br>
	  <input type="radio" name="grupoPrivacidad" value="Privado">Privado<br>
	  <input type="hidden" name="List" value="<%=	infoLista.getNombre()%>">
	  <input type="hidden" name="action" value="Privacy">
	  
	  <button type="submit">Modificar</button>
	  </form>
</div>

<%} %>
<br>

<table id="TablaContenidos">
<tr>
<th valign="top"> Tipo </th>
<th valign="top"> Nombre </th>
<th valign="top"> Propietario </th>

</tr>
	<%
	
	DtVideo[] vid = (DtVideo[]) request.getAttribute("videosLista");
	
		if((String) request.getAttribute("nicknameLogin")!=null){
			String nickname=(String) request.getAttribute("nicknameLogin");
		for (DtVideo entry : vid) {
			String nombreV=entry.getNombre();
			String descV=entry.getDescripcion();
			String propietarioV = entry.getPropietario();
			request.setAttribute("IDVideo", entry.getIDVideo().toString());
			request.setAttribute(nombreV, nombreV);
			System.out.println(nickname);
			System.out.println(entry.getPropietario());
			
	%>
	<tr>
	<td>Videos Lista
	<form action="removeVidPlaylist" method="get"> 
	<input type="hidden" name="action" value="removeVideo">
	<input type="hidden" name="ID" value="<%=  entry.getIDVideo()%>">
	<input type="hidden" name="List" value="<%=	infoLista.getNombre()%>">
	<input type="submit" value="Quitar Video"> </form> 
	</td>
	<td id="NombreTD"><%=nombreV%></td>
	<td id="PropietarioTD"><%=propietarioV %></td>
	</tr>
	<%
	
	}
	}
	%>	

	

</table>




</body>
</html>