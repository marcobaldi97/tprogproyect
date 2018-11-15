<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@ page import = "uytubeLogica.publicar.DtCategoria"%>
  <%@include file = "../cosasComunesDelHead.jsp" %>
	<link rel="stylesheet" href="media/styles/AltaUsuario.css">
	<title>Alta Usuario</title>
</head>
<body>
	<%@include file="../buscador.jsp" %>

    <div class="main-container">
    <%@include file="../sidebar.jsp" %>
    <div class="main-content">
    	<form class="alta-usuario-form" action="newUser" method ="POST" enctype="multipart/form-data" >
            Nickname:<br>
            <input type="text" name="nickname" id="nickname" onfocus="chequearNickname()">
            <div id="statusNickname">
            </div>
            Correo electronico:<br>
            <input type="email" name="email" id="email" onfocus="chequearEmail()"><br>
            <div id="statusEmail">
            </div>
            Nombre:<br>
            <input type="text" name="nombre"><br>
            Apellido:<br>
            <input type="text" name="apellido"><br>
            Contraseña:<br>
            
            <input type="password" id="contrasenia" name="contrasenia"><br>
            Confirmar Contraseña:<br>
            <input type="password" id="contraseniaConfirmacion" name="contraseniaConfirmacion"><br>
			<a id=correctaPass></a>
            
            <script type="text/javascript" src="fechaInput.js"></script>
            Fecha nacimiento:<br>
            <input type="text" id="datepicker" name="fecha_nacimiento"><br/>
            Imagen(opcional):<br>
            <input type="file" name="filename" accept="image/gif, image/jpeg, image/png"><br>
            Nombre canal(opcional):<br>
            <input type="text" name="nombre_canal"><br>
            Descripcion:<br>
            <input type="textarea" name="descripcion"><br>
            Defina su privacidad:<br>
            <input type="radio" name="privacidad" value="PRIVADO"  checked="checked" >Privado
            <input type="radio" name="privacidad" value="PUBLICO">Publico<br>
            Categoria(opcional)<br>
            <select name="categoria">
         		   <option value="Sin Categoria">Sin Categoria</option>
               		<%
					DtCategoria[] cat = (DtCategoria[]) request.getAttribute("listadoCat");
			     	String opciones="";
			       	for (int i=0;i<cat.length;i++)
			       	{
			       	 opciones=opciones+"<option value="+cat[i].getNombre()+">"+cat[i].getNombre()+"</option>";
			
		 	     	}
      				%>
                    <%=opciones %>
              </select><br />
			 <p id="error"></p>
            <button type="submit">Crear</button>
        	

    	</form>
    </div>
    </div>


<script type="text/javascript">
function chequearNickname()
{
$('#nickname').keyup(function()
		{
			var nickname = $('#nickname').val();
			$('#statusNickname').html('<img style="height : 25px; width: 25px" src="media/images/cargando.gif">');
			
			if(nickname!='')
			{
				var xhttp = new XMLHttpRequest();
			      xhttp.onreadystatechange = function () {
			        if (this.readyState == 4 && this.status == 200) {
			          document.getElementById("statusNickname").innerHTML = this.responseText;
			        }
			      };
			      xhttp.open("POST", "profile?opcion=chequearNickname&nickname="+nickname, true);
			      xhttp.send();
			}
			else
			{
				$('#statusNickname').html('');
			}
		})	
}

function chequearEmail()
{
$('#email').keyup(function()
		{
			var email = $('#email').val();
			$('#statusEmail').html('<img style="height : 25px; width: 25px" src="media/images/cargando.gif">');
			
			if(email!='')
			{
				var xhttp = new XMLHttpRequest();
			      xhttp.onreadystatechange = function () {
			        if (this.readyState == 4 && this.status == 200) {
			          document.getElementById("statusEmail").innerHTML = this.responseText;
			        }
			      };
			      xhttp.open("POST", "profile?opcion=chequearEmail&email="+email, true);
			      xhttp.send();
			}
			else
			{
				$('#statusEmail').html('');
			}
		})	
}



</script>

</body>
</html>
