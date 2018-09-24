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

<script>
 $.datepicker.regional['es'] = {
 closeText: 'Cerrar',
 prevText: '< Ant',
 nextText: 'Sig >',
 currentText: 'Hoy',
 monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
 monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
 dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
 dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
 dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
 weekHeader: 'Sm',
 dateFormat: 'dd/mm/yy',
 firstDay: 1,
 isRTL: false,
 showMonthAfterYear: false,
 yearSuffix: ''
 };
 $.datepicker.setDefaults($.datepicker.regional['es']);
$(function () {
$("#fecha").datepicker();
});
</script>
<script>

$(function () {
$.datepicker.setDefaults($.datepicker.regional["es"]);
$("#datepicker").datepicker({
firstDay: 1
});
});
</script>
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