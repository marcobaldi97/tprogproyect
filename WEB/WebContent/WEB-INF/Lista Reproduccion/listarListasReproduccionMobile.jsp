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
<%
if(request.getAttribute("listas") != null){
	DtListaReproduccion[] listas = (DtListaReproduccion[]) request.getAttribute("listas");
}
%>
<div class="container-fluid" style="width : 100%;">
	<div class="row">
		<div class="col-xs-12"><h1>Listas reproducción</h1></div>
	</div>
	<div style="padding-left : 5%; padding-right : 5%; width : 100%;" class="container-fluid">
		<%if(request.getAttribute("listas") != null){
			DtListaReproduccion[] listas = (DtListaReproduccion[]) request.getAttribute("listas");
			for(int index = 0; index < listas.length ; index++){
				String nombreLista = listas[index].getNombre();
				String[] nombresCategorias = new String[listas[index].getCategoriasLDR().size()];
				List<DtCategoria> listaDtcategoria = listas[index].getCategoriasLDR();
				Integer jota = 0;
				for (Iterator<DtCategoria> iter = listaDtcategoria.iterator(); iter.hasNext(); ) {
					DtCategoria element = iter.next();
					nombresCategorias[jota] = element.getNombre();
					jota++;
				}
				String categoriasAnexadas = "";
				for (int i = 0; i < nombresCategorias.length; i++){
					categoriasAnexadas =  categoriasAnexadas +", "+ nombresCategorias[i];
				}
		%>
		<div class="row">
			<div class="col-xs-2"><h3><%=nombreLista%></h3></div>
			<div class="col-xs-7"><h3>Categorias: <%=categoriasAnexadas%></h3></div>
			<div class="col-xs-3">
					<form action="playlist" method="get"> 
						<input type="hidden" name="action" value="details">
						<input type="hidden" name="nameList" value="<%=nombreLista%>">
						<input type="hidden" name="ownerList" value="<%=listas[index].getPropietario() %>">
						<input class="verAhora btn btn-danger" type="submit" value="Ver Info"> 
					</form> 
			</div>
		</div>
		<%	}
		}//carga las listas %>
	</div>
</div>
<script type="text/javascript">

</script>
</body>
</html>