<%@ page import = "uytubeLogic.logica.DtVideo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
algo?
<%if(request.getAttribute("videos")!=null){%>

<%DtVideo[] vid= (DtVideo[])request.getAttribute("videos"); 
for(DtVideo entry:vid){ %>
				
oh, un video con 
<%out.print((String)request.getAttribute("busqueda")); %><br>
	<% } }%>
</body>
</html>