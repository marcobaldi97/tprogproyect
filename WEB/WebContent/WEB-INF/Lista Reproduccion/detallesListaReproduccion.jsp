<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="uytubeLogic.logica.DtListaReproduccion"%>
<%@ page import = "uytubeLogic.logica.DtVideo"%>
<%@ page import = "uytubeLogic.logica.SystemHandler.Privacidad"%>
<%@ page import = "uytubeLogic.logica.DtCanal"%>
<%@ page import = "uytubeLogic.logica.DtCategoria"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UyTube</title>
</head>
<body>

<%
	DtListaReproduccion infoLista = (DtListaReproduccion) request.getAttribute("infoLista");
%>

<p>Nombre: <%=infoLista.getNombre()%></p>


<p>Categorias:
<%
	for(DtCategoria entry: infoLista.getCategoriasLDR())
	{
%>

[<%=entry.getNombre()%>]

<%} %>
</p>

<table id="TablaContenidos">
<tr>
<th valign="top"> Tipo </th>
<th valign="top"> Nombre </th>
<th valign="top"> Propietario </th>

</tr>
	<%
		DtVideo[] vid = (DtVideo[]) request.getAttribute("videosLista");
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
		%>

	

</table>

</body>
</html>