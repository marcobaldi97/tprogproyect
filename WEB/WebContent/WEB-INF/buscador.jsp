<div class="topnav">
  <div class="topnav-home">
    <a href="home" id="homeButton">
      <img src="media/images/Logo.png" alt="Home" title="UyTube">
    </a>
  </div>
  <form class="topnav-search-form" action="search" method="get">
    <input class="topnav-search-input" type="text" name="busqueda" placeholder="Buscar...">
    <button class="topnav-search-submit" type="submit">Mandale Mecha!</button>
  </form>
  <div class="topnav-login-logout" id=loginlogout></div>
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

