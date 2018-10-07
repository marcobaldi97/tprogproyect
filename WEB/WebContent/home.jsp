<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
  <%@include file="WEB-INF/cosasComunesDelHead.jsp" %>
  <title>UyTube!</title>
</head>

<body>
  <%@include file="WEB-INF/buscador.jsp" %>
  <div class="main-container">
    <%@include file="WEB-INF/sidebar.jsp" %>
    <div class="main-content">
      <form action="cargarDatosPrueba">
        <button type="button" onclick="test()">Cargar Datos de Prueba</button>
      </form>
      <p id="Datos"></p>
    </div>
  </div>
  <script>

    function test() {
      var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
          document.getElementById("Datos").innerHTML = this.responseText;
        }
      };
      xhttp.open("GET", "cargarDatos", true);
      xhttp.send();
    }</script>
</body>

</html>
