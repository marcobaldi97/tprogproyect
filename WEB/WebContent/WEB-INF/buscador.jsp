<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>#homeButton{
	margin left:2%;
	background-color: #e9e9e9;
	float:left;
	padding:0px 0 px;
}
</style>
<link rel="stylesheet" href="media/styles/home.css">
<title>UyTube!</title>
</head>
<body>



<div class="topnav">
<a href="home"id="homeButton"><img src="media/images/Logo.jpg" height="70" width="150" alt="Home"></a>
<a id=loginlogout></a>
  	<form action="search" method="get">
  		<button type="submit">Mandale Mecha!</button>
		<input type="text" name="busqueda" placeholder="Buscar..">
	</form>
</div>



<script>

      var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
          document.getElementById("loginlogout").innerHTML = this.responseText;
        }
      };
      xhttp.open("POST", "login?opcion=checkLogin", true);
      xhttp.send();
    </script>
</body>

</html>

