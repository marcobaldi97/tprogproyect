<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "uytubeLogic.logica.DtCategoria"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="media/styles/home.css">
<meta charset="ISO-8859-1">
<title>UyTube</title>
</head>
<body>
	
	<form id="listaCategorias" action="consult" method="post">
	
	<%
		DtCategoria[] cat= (DtCategoria[]) request.getAttribute("listarCategorias");
		for (DtCategoria entry : cat) {
			String nombreC=entry.getNombre();
	%>
	    
	 
	 <input type="hidden" name="action" value="consult" class="btn-link" >
	
	 <button type="submit" name="type" value="<%=nombreC %>" class="btn-link" ><%=nombreC %></button><br>
	
	<%}%>
	</form>
	
	
</body>
</html>