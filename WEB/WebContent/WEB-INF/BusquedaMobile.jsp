<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="uytubeLogica.publicar.DtListaReproduccion"%>
<%@ page import = "uytubeLogica.publicar.DtVideo"%>
<%@ page import = "uytubeLogica.publicar.DtCanal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page errorPage="../error/error404.jsp" %>
<!DOCTYPE html>
<html>

<head>
  <%@include file="cosasComunesDelHead.jsp" %>
  <title>UyTube!</title>
  	  
  	  <script type="text/javascript">
	  	function clickimg(index){
			$('#imagenVideo'+index).click(function(){
			$('#verVideo'+index).click()
			})
	  	}
	</script>	
</head>

<body>

<%@include file="buscadorBootstrap.jsp" %>
	  
	  <div class="container-fluid">
		  <%
			  if (request.getAttribute("videos") != null) {
			  DtVideo[] videos = (DtVideo[]) request.getAttribute("videos");
			  int index=0;
			  for (DtVideo entry : videos) {
		  %>
		 <div class="container">
		    <div class="row">
		        <div class="col-sm-12">
		        <h3> <%=entry.getNombre()%> <small> -<%=entry.getPropietario()%>-</small></h3>
		        </div>
		        <div class="col-sm-12">
		        <form action="watch" method="get"> 
					<input type="hidden" name="opcion" value="ver">
					<input type="hidden" name="ID" value="<%=entry.getIDVideo()%>">
					<input id="verVideo<%=index %>" class="verAhora" type="submit" value="Ver Ahora" style="display: none;"> 
					<img id="imagenVideo<%=index %>" src="<%=entry.getUrl()%>" class="img-thumbnail" alt="..." onclick="clickimg(<%=index %>)" >
				</form> 
		        </div>
		    </div>
		 </div>
	       
	  </div>

	  
	  <%
	  index++;}
			  }%>
</body>


</html>

