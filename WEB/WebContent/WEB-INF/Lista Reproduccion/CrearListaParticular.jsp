<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<%@ include file="../cosasComunesDelHead.jsp" %>
<title>Crear Lista Particular</title>
</head>

<body>
  <%@include file="../buscador.jsp" %>
  <div class="main-container">
    <%@include file="../sidebar.jsp" %>
    <div class="main-content">
	<form action="newPlaylist" method="post">
	  Nombre de la lista<br>
	  <input type="text" name="nombreLista"><br>
	  Privacidad<br>
	  <input type="radio" name="grupoPrivacidad" value="Publico" checked>Publico<br>
	  <input type="radio" name="grupoPrivacidad" value="Privado">Privado<br>
	  <input type="hidden" name="action" value="crearLDR">
	  <button type="submit">Crear</button>
	  </form>
    </div>
  </div>
</body>
</html>
