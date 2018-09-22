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
	<% 
		DtCategoria[] cat= (DtCategoria[]) request.getAttribute("listarCategorias");
		
	%>
	<ul style="list-style-type:disc">
		<li><%  
		  for(int i = 0; i < cat.length; i++)
		    {
		       out.println((String)cat[i].getNombre());
		    }
		%></li>
	</ul>
</body>
</html>