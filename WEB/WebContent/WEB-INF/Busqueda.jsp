<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="uytubeLogica.publicar.DtListaReproduccion"%>
<%@ page import = "uytubeLogica.publicar.DtVideo"%>
<%@ page import = "uytubeLogica.publicar.DtCanal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page errorPage="../error/error404.jsp" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="cosasComunesDelHead.jsp" %>
<style>table{
	width: 100%;
	table-layout: fixed;
}
th {
	color: white;
	padding: 15px;
    text-align: left;
    border-bottom: 1px solid #ddd;
    background-color: #ff0000;
    color: white;
    vertical-align: text-top;
}
td {
    padding: 15px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}
.verAhora{
	background-color: #ee0000;
	border: none;
	color: white;
	padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}
tr:nth-child(even) {background-color: #f2f2f2;}</style>

<%@include file="buscador.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=request.getAttribute("titulo") %></title>
</head>
<body>

<%if (request.getAttribute("videos") != null) {%>
<button onclick="toggleVideos()">Ver/Ocultar Videos</button>
<%}
if (request.getAttribute("listas") != null) { %>
<button onclick="toggleListas()">Ver/Ocultar Listas</button>
<%}
if (request.getAttribute("canales") != null) { %>
<button onclick="toggleCanales()">Ver/Ocultar Canales</button>

<%} %>
<div class="main">	
	Ordenar por:
	<select id="Ordenar" class="icon-menu" onchange="sortTable()">
		<option value=1>Nombre</option>
		<option value=5 selected>Fecha Publicacion</option>
	</select>
	<%
	DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	DateFormat goodDf = new SimpleDateFormat("EEEEE dd 'de' MMMMM 'del' yyyy",Locale.forLanguageTag("es-ES"));
	if (request.getAttribute("videos") != null) {
%>
<table id="TablaContenidos">
<tr>
<th valign="top"> Tipo </th>
<th valign="top"> Nombre </th>
<th valign="top"> Descripcion </th>
<th valign="top"> Propietario </th>
<th valign="top"> Fecha publicación </th>
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
	<tr class="videoRow">
	<td>Video
	<form action="watch" method="get"> 
	<input type="hidden" name="opcion" value="ver">
	<input type="hidden" name="ID" value="<%=entry.getIDVideo()%>">
	<input class="verAhora" type="submit" value="Ver Ahora"> </form> 
	</td>
	<td id="NombreTD"><%=nombreV%></td>
	<td id="DescripcionTD"><%=descV %></td>
	<td id="PropietarioTD"><%=propietarioV %></td>
	<td id="FechaTD"><%=goodDf.format(entry.getFechaPublicacion().getFecha().toGregorianCalendar().getTime()) %></td>
	<%String fechaHidden=df.format(entry.getFechaPublicacion().getFecha().toGregorianCalendar().getTime()); %>
	<td style="display:none;"><%=fechaHidden%></td>
	
	</tr>
	
	<%
		}
	}
	if(request.getAttribute("listas")!=null){
		DtListaReproduccion[] listas=(DtListaReproduccion[]) request.getAttribute("listas");
		for(DtListaReproduccion entry: listas){%>
	<tr class="listaRow">
	<td>Lista de Reproduccion
	<form action="playlist" method="get"> 
	<input type="hidden" name="action" value="details">
	<input type="hidden" name="nameList" value="<%=entry.getNombre() %>">
	<input type="hidden" name="ownerList" value="<%=entry.getPropietario() %>">
	<input class="verAhora" type="submit" value="Ver Info"> </form> 
	</td>
	<td id="NombreTD"><%=entry.getNombre()%></td>
	<td id="DescripcionTD"></td>
	<td id="PropietarioTD"><%=entry.getPropietario() %></td>
	<td id="FechaTD"><%=goodDf.format(entry.getUltimoVideo().toGregorianCalendar().getTime()) %></td>
	<%String fechaHidden=df.format(entry.getUltimoVideo().toGregorianCalendar().getTime()); %>
	<td style="display:none;"><%=fechaHidden%></td>
	
	</tr>
	
	<%	}
	}
	if(request.getAttribute("canales")!=null){
		for(DtCanal entry:(DtCanal[])request.getAttribute("canales")){
			%>
		<tr class="canalRow">
		<td>Canal
	<form action="profile" method="get"> 
	<input type="hidden" name="opcion" value="Perfil">
	<input type="hidden" name="nickname" value="<%=entry.getPropietario()%>">
	<input class="verAhora" type="submit" value="Ver Canal"> </form> 
	</td>
		<td id="NombreTD"><%=entry.getNombre()%></td>
		<td id="DescripcionTD"><%=entry.getDescripcion() %></td>
		<td id="PropietarioTD"><%=entry.getPropietario() %></td>
		<td id="FechaTD"><%=goodDf.format(entry.getUltimoVideo().toGregorianCalendar().getTime()) %></td>
		<%String fechaHidden=df.format(entry.getUltimoVideo().toGregorianCalendar().getTime()); %>
	<td style="display:none;"><%=fechaHidden%></td>
	<%	}
	}
	%>
	</tr>
</table>

</div>
<script>
function toggleVideos(){
	var x = document.getElementsByClassName("videoRow");
	if(x[0].style.display != "none"){
	for(i=0 ; i < x.length ; i++){
		x[i].style.display = "none";
	}
	}else{
	for(i=0 ; i < x.length ; i++){
		x[i].style.display = "table-row";
	}
	}
}
function toggleListas(){
var x = document.getElementsByClassName("listaRow");
	if(x[0].style.display != "none"){
	for(i=0 ; i < x.length ; i++){
		x[i].style.display = "none";
	}
	}else{
	for(i=0 ; i < x.length ; i++){
		x[i].style.display = "table-row";
	}
	}
	
}
function toggleCanales(){
var x = document.getElementsByClassName("canalRow");
	if(x[0].style.display != "none"){
	for(i=0 ; i < x.length ; i++){
		x[i].style.display = "none";
	}
	}else{
	for(i=0 ; i < x.length ; i++){
		x[i].style.display = "table-row";
	}
	}
}
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