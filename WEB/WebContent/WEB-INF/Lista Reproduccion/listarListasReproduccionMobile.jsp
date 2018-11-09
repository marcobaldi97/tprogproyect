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
</head>
<body>
  <%@include file="../buscadorBootstrap.jsp" %>
<%
if(request.getAttribute("listarListasReproduccion") != null){
	DtListaReproduccion[] listas = (DtListaReproduccion[]) request.getAttribute("listarListasReproduccion");
}
%>
<div class="container-fluid" style="width : 100%;">
	<div class="row">
		<div class="col-xs-12"><h1>Listas reproducción</h1></div>
	</div>
	<div style="padding-left : 5%; padding-right : 5%; width : 100%;" class="container-fluid">
		<%if(request.getAttribute("listarListasReproduccion") != null){
			DtListaReproduccion[] listas=(DtListaReproduccion[]) request.getAttribute("listarListasReproduccion");
			for(DtListaReproduccion entry: listas){
				String nombreLista = entry.getNombre();
				String[] nombresCategorias = new String[entry.getCategoriasLDR().size()];
				Integer jota = 0;
				for (DtCategoria entryCategorias: entry.getCategoriasLDR()) {
					nombresCategorias[jota] = entryCategorias.getNombre();
					jota++;
				}
				String categoriasAnexadas = "";
				for (int i = 0; i < nombresCategorias.length; i++){
					categoriasAnexadas =  categoriasAnexadas +" "+ nombresCategorias[i];
				}
		%>
		<div class="row">
			<div class="col-xs-12"><h3><%=nombreLista%></h3></div>
		</div>
		<div class="row">
			<div class="col-xs-8"><h3>Categorias: <%=categoriasAnexadas%></h3></div>
			<div class="col-xs-4">
					<form action="playlist" method="get"> 
						<input type="hidden" name="action" value="details">
						<input type="hidden" name="nameList" value="<%=nombreLista%>">
						<input type="hidden" name="ownerList" value="<%=entry.getPropietario() %>">
						<input style="width : 100%" class="verAhora btn btn-danger" type="submit" value="Ver Info"> 
					</form> 
			</div>
		</div>
		<%	}//for para recorrer la lista
		}else{%>
		<%}//carga las listas 
		if((DtListaReproduccion[]) request.getAttribute("listasPrivadasSesion")!=null){
			DtListaReproduccion[] listasPrivadas=(DtListaReproduccion[]) request.getAttribute("listasPrivadasSesion");
			for(DtListaReproduccion entry: listasPrivadas){
				String nombreLista = entry.getNombre();
				String[] nombresCategorias = new String[entry.getCategoriasLDR().size()];
				Integer jota = 0;
				for (DtCategoria entryCategorias: entry.getCategoriasLDR()) {
					nombresCategorias[jota] = entryCategorias.getNombre();
					jota++;
				}
				String categoriasAnexadas = "";
				for (int i = 0; i < nombresCategorias.length; i++){
					categoriasAnexadas =  categoriasAnexadas +" "+ nombresCategorias[i];
				}
		%>
		<div class="row">
			<div class="col-xs-12"><h3><%=nombreLista%></h3></div>
		</div>
		<div class="row">
			<div class="col-xs-8"><h3>Categorias: <%=categoriasAnexadas%></h3></div>
			<div class="col-xs-4">
					<form action="playlist" method="get"> 
						<input type="hidden" name="action" value="details">
						<input type="hidden" name="nameList" value="<%=nombreLista%>">
						<input type="hidden" name="ownerList" value="<%=entry.getPropietario() %>">
						<input class="verAhora btn btn-danger" type="submit" value="Ver Info"> 
					</form> 
			</div> 
		</div>
		<%	}//for para recorrer la lista
		}%>
		
	</div>
</div>
</body>
</html>