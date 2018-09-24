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
	
	<form action="/UyTubeWeb/list" method="get">
	<ul>
	<%
		DtCategoria[] cat= (DtCategoria[]) request.getAttribute("listarCategorias");
		for (DtCategoria entry : cat) {
			String nombreC=entry.getNombre();
	%>
	
	<li>
	<div>
	<%=nombreC %><br>
	</div>
	</li>
		<%}%>
	</ul>
	</form>
	
	
</body>
</html>