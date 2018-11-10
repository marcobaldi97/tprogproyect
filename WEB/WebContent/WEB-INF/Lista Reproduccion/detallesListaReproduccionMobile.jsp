<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="uytubeLogica.publicar.Privacidad"%>
<%@ page import="uytubeLogica.publicar.DtCanal"%>
<%@ page import="uytubeLogica.publicar.DtCategoria"%>
<%@ page import="uytubeLogica.publicar.DtVideo"%>
<%@ page import="uytubeLogica.publicar.DtListaReproduccion"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="../buscador.jsp"%>
<%@include file="../cosasComunesDelHead.jsp"%>
</head>
<body>
	<%
		DtListaReproduccion infoLista = (DtListaReproduccion) request.getAttribute("infoLista");
	%>
	<div class="container">
		<div class="container" id="nombreLista">
			<div class="row">
				<div class="col-xs-12" style="font-size:10vw">
					<%=infoLista.getNombre()%>
				</div>
			</div>
		</div>
		<div class="container-fluid" id="categorias">
			<div class="row">

				<div class="col-xs-8" ><h4 style="float:left">Categorias:</h4></div>
			</div>

			<div class="row">
					<%
						for (DtCategoria cat : infoLista.getCategoriasLDR()) {
					%>

						
							<div class="col-xs-4" style="border:1px solid black; font-size:3.8vw" >
								<div >
								<%=cat.getNombre()%>
								</div>
							</div>
						
					<%
						}
					%>
				
			</div>

		</div>
	</div>

</body>
</html>