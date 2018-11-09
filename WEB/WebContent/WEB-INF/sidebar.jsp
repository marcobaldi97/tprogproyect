<div class="vertical-menu" style="width : 20%">
  <a href="#" class="active"><h3>Bienvenido</h3></a><br>
  <div id="LoggedInInfo"></div>
  <h3>Categorias</h3>
  <h4>
  <div id="categorias"></div>
  </h4>
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
