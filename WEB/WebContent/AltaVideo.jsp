<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="media/styles/AltaVideo.css">

<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script src="jquery.ui.datepicker-es.js"></script>


<%@ page import = "uytubeLogic.logica.DtCategoria"%>
<%@ page import = "uytubeLogic.logica.Fabrica"%>
<%@ page import = "uytubeLogic.logica.IVideoCtrl"%>
<%@include file="WEB-INF/buscador.jsp" %>
<title>Alta Video</title>
</head>
<body>
	<form action="/UyTubeWeb/newVideo" method="get">
		Nombre del Video:<br/>
		<input type="text" name="nombreVideo"/><br/>
		Duracion:<br/>
		<input type="text" name="duracionVideo"/><br/>
		URL:<br/>
		<input type="text" name="urlVideo"/><br/>
		Descripcion:<br/>
		<input type="text" name="descVideo"/><br/>
		Fecha:<br/>
		<script type="text/javascript" src="fechaInput.js"></script>
		<input type="text" id="datepicker" name="fechaVideo"><br/>
		Categoria:<br/>
		
		 <select name="categoria">
			<% 
			Fabrica fabrica = Fabrica.getInstance();
			IVideoCtrl videoCtr = fabrica.getIVideoCtrl();
    		DtCategoria[] cat = videoCtr.listarCategorias(); 
        	String opciones="";
          	for (int i=0;i<cat.length;i++)
          	{
          	 opciones=opciones+"<option value="+cat[i].getNombre()+">"+cat[i].getNombre()+"</option>";
          
    	     	}
      		%>
			<%=opciones %>
         </select></br>
       	 <button id="crearVideo" name="opcion" value="altaVideo">Crear</button>
     </form>
</body>
</html>