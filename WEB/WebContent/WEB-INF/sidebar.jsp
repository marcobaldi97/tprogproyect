<div class="vertical-menu">
  <a href="#" class="active">Bienvenido</a><br>
  <div id="LoggedInInfo"></div>
  Categorias
  <div id="categorias"></div>
  
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
