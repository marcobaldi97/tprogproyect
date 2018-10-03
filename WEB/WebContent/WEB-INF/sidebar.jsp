<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="media/styles/home.css">
<title>UyTube!</title>
</head>
<body>
<div class="vertical-menu">
  <a href="#" class="active">Bienvenido</a><br>
  Categorias
  <div id="LoggedInInfo"></div>
  <div id="categorias"></div>
  <form id="sideBar" action="list" method="get">
  <input type="hidden" name="action" value="list">
  <button type="submit" value="categorias" class="btn-link" >Categorias</button>
  </form>
  
  <form id="sideBar" action="playlist" method="get">
  <input type="hidden" name="action" value="list">
  <button type="submit" value="categorias" class="btn-link" >Listas</button>
  </form>
  
</div>
<script>
	
		var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
          document.getElementById("categorias").innerHTML = this.responseText;
        }
      };
      xhttp.open("GET", "list?action=listarEmbed", true);
      xhttp.send();
      var xhttpNewVideo = new XMLHttpRequest();
      
      xhttpNewVideo.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
          document.getElementById("LoggedInInfo").innerHTML = this.responseText;
        }
      };
	xhttpNewVideo.open("POST", "login?opcion=checkLoginSidebar", true);
	xhttpNewVideo.send();
</script>
</body>