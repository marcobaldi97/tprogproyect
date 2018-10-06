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



<table id="TablaContenidos">
<tr>
<th valign="top"> Tipo </th>
<th valign="top"> Nombre </th>
<th valign="top"> Propietario </th>

</tr>
	<%
	DtListaReproduccion infoLista = (DtListaReproduccion) request.getAttribute("infoLista");
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
	<input type="hidden" name="ID" value="<%=entry.getIDVideo()%>">
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