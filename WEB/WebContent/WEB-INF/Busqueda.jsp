<%@ page import = "uytubeLogic.logica.DtVideo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultados De Busqueda</title>
</head>
<body>
	algo?
	<%
	if (request.getAttribute("videos") != null) {
%>
<ul>
	<%
		DtVideo[] vid = (DtVideo[]) request.getAttribute("videos");
		for (DtVideo entry : vid) {
			String nombreV=entry.getNombre();
			String descV=entry.getDescripcion();
			Integer duracionMM=entry.getDuracion()/60;
			Integer duracionSS=entry.getDuracion()%60;
			String duracionV = String.format("%02d:%02d", duracionMM, duracionSS);
			String propietarioV = entry.getPropietario();
			request.setAttribute("IDVideo", entry.getIDVideo().toString());
			request.setAttribute(nombreV, nombreV);
	%>
	<li>
	<div>
	<form action="watch" method="get"> 
	<input type="hidden" name="opcion" value="ver">
	<input type="hidden" name="ID" value="<%=entry.getIDVideo()%>">
	<input type="submit" value="Ver Ahora">Nombre : </form> <%=nombreV%><%=duracionV %><br>
	Propietario : <%=propietarioV %> <br>
	Descripcion : <%=descV %><br>
	</div>
	</li>
	
	<%
		}
	}
	%>
</ul>)
</body>
</html>