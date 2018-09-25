<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="uytubeLogic.logica.DtListaReproduccion"%>
<%@ page import = "uytubeLogic.logica.DtVideo"%>
<%@ page import = "uytubeLogic.logica.DtCanal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultados De Busqueda</title>
</head>
<body>
	<%@include file="buscador.jsp" %>
	<%@include file="sidebar.jsp" %>
	Ordenar por:
	<select id="Ordenar" class="icon-menu" onchange="sortTable()">
		<option value=1>Nombre</option>
		<option value=5 selected>Fecha Publicacion</option>
	</select>
	<%
	DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	if (request.getAttribute("videos") != null) {
%>
<table id="TablaContenidos">
<tr>
<th> Tipo </th>
<th> Nombre </th>
<th> Descripcion </th>
<th> Propietario </th>
<th> Fecha publicación </th>
</tr>
	<%
		DtVideo[] vid = (DtVideo[]) request.getAttribute("videos");
		for (DtVideo entry : vid) {
			String nombreV=entry.getNombre();
			String descV=entry.getDescripcion();
			String propietarioV = entry.getPropietario();
			request.setAttribute("IDVideo", entry.getIDVideo().toString());
			request.setAttribute(nombreV, nombreV);
	%>
	<tr>
	<td>Video
	<form action="watch" method="get"> 
	<input type="hidden" name="opcion" value="ver">
	<input type="hidden" name="ID" value="<%=entry.getIDVideo()%>">
	<input type="submit" value="Ver Ahora"> </form> 
	</td>
	<td id="NombreTD"><%=nombreV%></td>
	<td id="DescripcionTD"><%=descV %></td>
	<td id="PropietarioTD"><%=propietarioV %></td>
	<td id="FechaTD"><%=entry.getFechaPublicacion().getFecha().toString() %></td>
	<%String fechaHidden=df.format(entry.getFechaPublicacion().getFecha()); %>
	<td style="display:none;"><%=fechaHidden%></td>
	
	</tr>
	
	<%
		}
	}
	if(request.getAttribute("listas")!=null){
		DtListaReproduccion[] listas=(DtListaReproduccion[]) request.getAttribute("listas");
		for(DtListaReproduccion entry: listas){%>
	<tr>
	<td>Lista de Reproduccion
	<form action="watch" method="get"> 
	<input type="hidden" name="opcion" value="consulta">
	<input type="submit" value="Ver Info"> </form> 
	</td>
	<td id="NombreTD"><%=entry.getNombre()%></td>
	<td id="DescripcionTD"></td>
	<td id="PropietarioTD"><%=entry.getPropietario() %></td>
	<td id="FechaTD"><%=entry.getFechaUltimoVideo().toString() %></td>
	<%String fechaHidden=df.format(entry.getFechaUltimoVideo()); %>
	<td style="display:none;"><%=fechaHidden%></td>
	
	</tr>
	
	<%	}
	}
	if(request.getAttribute("canales")!=null){
		for(DtCanal entry:(DtCanal[])request.getAttribute("canales")){
			%>
		<tr>
		<td>Canal
	<form action="watch" method="get"> 
	<input type="hidden" name="opcion" value="consulta">
	<input type="submit" value="Ver Canal"> </form> 
	</td>
		<td id="NombreTD"><%=entry.getNombre()%></td>
		<td id="DescripcionTD"><%=entry.getDescripcion() %></td>
		<td id="PropietarioTD"></td>
		<td id="FechaTD"><%=entry.getFechaUltimoVideo().toString() %></td>
		<%String fechaHidden=df.format(entry.getFechaUltimoVideo()); %>
	<td style="display:none;"><%=fechaHidden%></td>
	<%	}
	}
	%>
	</tr>
</table>)

<script>
function sortTable() {
	var selected = document.getElementById("Ordenar").value;
  var table, rows, switching, i, x, y, shouldSwitch;
  table = document.getElementById("TablaContenidos");
  switching = true;
  /* Make a loop that will continue until
  no switching has been done: */
  while (switching) {
    // Start by saying: no switching is done:
    switching = false;
    rows = table.rows;
    /* Loop through all table rows (except the
    first, which contains table headers): */
    for (i = 1; i < (rows.length - 1); i++) {
      // Start by saying there should be no switching:
      shouldSwitch = false;
      /* Get the two elements you want to compare,
      one from current row and one from the next: */
      x = rows[i].getElementsByTagName("TD")[selected];
      y = rows[i + 1].getElementsByTagName("TD")[selected];
      // Check if the two rows should switch place:
      if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
        // If so, mark as a switch and break the loop:
        shouldSwitch = true;
        break;
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}
</script>
</body>
</html>