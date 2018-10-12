<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@ page import = "uytubeLogic.logica.DtCategoria"%>
  <%@ page import = "uytubeLogic.logica.Fabrica"%>
  <%@ page import = "uytubeLogic.logica.IVideoCtrl"%>
  <%@ page import = "uytubeLogic.logica.IUsuarioCtrl"%>
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
            <input type="text" name="nickname" id="nickname" onblur="comprobarDisponibilidadUsr()" ><br>
            Correo electronico:<br>
            <input type="email" name="email" id="email" onblur="comprobarDisponibilidadUsr()"><br>
            <p id="disponible"></p>
            <script>
           		 function comprobarDisponibilidadUsr() {
           			var xhttp = new XMLHttpRequest();
	                xhttp.onreadystatechange = function () {
	                  if (this.readyState == 4 && this.status == 200) {
	                	                	 
	                	//  if(mensaje=="")alert(this.responseText,"¡ALERTA!");
	                	document.getElementById("disponible").innerHTML = this.responseText;
	                	
	                  }
	                };
	                var nickname = document.getElementById("nickname").value;
	                var encodedNick= encodeURIComponent(nickname);
	                xhttp.open("POST", "newUser?opcion=checkDispUsr&nickname="+encodedNick+"&email="+document.getElementById("email").value, true);
	                xhttp.send();	                
	            }
           		
       	       
       	     </script>
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
					Fabrica fabrica = Fabrica.getInstance();
					IVideoCtrl videoCtr = fabrica.getIVideoCtrl();
			 		DtCategoria[] cat = videoCtr.listarCategorias();
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

</body>
</html>
