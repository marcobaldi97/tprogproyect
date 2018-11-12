<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="uytubeLogica.publicar.DtListaReproduccion"%>
<%@page import="uytubeLogica.publicar.DtCategoria"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page errorPage="../error/error404.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%@include file="../cosasComunesDelHead.jsp" %>
<title>Listas Reproducción</title>
<style type="text/css">
.verInfoButton{
    background-color: #eee;
    border: none;
    color: #777;
    text-align: center;
    text-decoration: none;
    tex
    display: inline-block;
    font-size: 18px;
}
.verInfoButton:hover{
	background-color: #eee;
	color: black;
}
</style>
</head>
<body>
  <%@include file="../buscadorBootstrap.jsp" %>
<%
if(request.getAttribute("listarListasReproduccion") != null){
	DtListaReproduccion[] listas = (DtListaReproduccion[]) request.getAttribute("listarListasReproduccion");
}
%>
<div class="container-fluid" style="width : 100%; padding ; 5px 5px 5px 5px">
	<div class="row">
		<div class="col-xs-12"><h2>Listas reproducción</h2></div>
	</div>
	<ul class="list-group list-group-flush">
	<div style="padding-left : 5%; padding-right : 5%; width : 100%;" class="container-fluid">
		<%if(request.getAttribute("listarListasReproduccion") != null){
			DtListaReproduccion[] listas=(DtListaReproduccion[]) request.getAttribute("listarListasReproduccion");
			for(DtListaReproduccion entry: listas){
				String nombreLista = entry.getNombre();
				String[] nombresCategorias = new String[entry.getCategoriasLDR().size()];
		%>
		<li class="list-group-item">
		<div class="row">
			<div class="col-xs-8"><%=nombreLista%></div>
			<div class="col-xs-4">
					<form action="playlist" method="get"> 
						<input type="hidden" name="action" value="details">
						<input type="hidden" name="nameList" value="<%=nombreLista%>">
						<input type="hidden" name="ownerList" value="<%=entry.getPropietario() %>">
						<input class="verAhora verInfoButton" type="submit" value="Ver Info"> 
					</form> 
			</div>
		</div>
		</li>
		<%	}//for para recorrer la lista
		}else{%>
		<%}//carga las listas 
		if((DtListaReproduccion[]) request.getAttribute("listasPrivadasSesion")!=null){
			DtListaReproduccion[] listasPrivadas=(DtListaReproduccion[]) request.getAttribute("listasPrivadasSesion");
			for(DtListaReproduccion entry: listasPrivadas){
				String nombreLista = entry.getNombre();
				String[] nombresCategorias = new String[entry.getCategoriasLDR().size()];
		%>
		<li class="list-group-item">
		<div class="row">
			<div class="col-xs-8"><%=nombreLista%></div>
			<div class="col-xs-4">
					<form action="playlist" method="get"> 
						<input type="hidden" name="action" value="details">
						<input type="hidden" name="nameList" value="<%=nombreLista%>">
						<input type="hidden" name="ownerList" value="<%=entry.getPropietario() %>">
						<input class="verAhora verInfoButton" type="submit" value="Ver Info"> 
					</form> 
			</div>
		</div>
		</li>
		<%	}//for para recorrer la lista
		}%>
	</div>
	</ul>
</div>
</body>
</html>