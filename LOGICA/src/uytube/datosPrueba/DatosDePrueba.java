package uytube.datosPrueba;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import uytubeLogic.logica.DtCategoria;
import uytubeLogic.logica.DtComentario;
import uytubeLogic.logica.DtFecha;
import uytubeLogic.logica.DtVideo;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.IVideoCtrl;
import uytubeLogic.logica.PropertiesCtrl;
import uytubeLogic.logica.VideoHandler;
import uytubeLogic.logica.SystemHandler.Privacidad;

public class DatosDePrueba {
	private Fabrica fabrica = Fabrica.getInstance();
	private IUsuarioCtrl ICU = fabrica.getIUsuarioCtrl();
	private IVideoCtrl ICV = fabrica.getIVideoCtrl();
	public static byte[] imagenToByte(File archivo){
		 //imagen a byte[]
		try{
			byte[] imgFoto = new byte[(int) archivo.length()]; 
			InputStream inte = new FileInputStream(archivo);
			inte.read(imgFoto);
			return imgFoto;
		}catch(Exception e){
			System.out.println(e.getMessage());}
		return null;
	}
	public void cargarDatosDePrueba() throws IOException{
		PropertiesCtrl prop = PropertiesCtrl.getInstance();
		System.out.println("la property foto es: "+prop.getProperty("fotos"));
		String ubicacionFoto=System.getProperty("user.home")+"/Desktop/"+prop.getProperty("fotos");
	
		//CATEGORIAS
		String MUS="Musica";ICV.crearCategoria(MUS);
		String DEP="Deporte";ICV.crearCategoria(DEP);
		String CAR="Carnaval";ICV.crearCategoria(CAR);
		String NOT="Noticias";ICV.crearCategoria(NOT);
		String ENT="Entretenimiento";ICV.crearCategoria(ENT);
		String COM="Comida";ICV.crearCategoria(COM);
		String JUE="Videojuegos";ICV.crearCategoria(JUE);
		String CYT="Ciencia y Tecnologia";ICV.crearCategoria(CYT);
		String ONG="ONG y activismo";ICV.crearCategoria(ONG);
		String GEN="Gente y blogs";ICV.crearCategoria(GEN);
		String MAS="Mascotas y animales";ICV.crearCategoria(MAS);
		String VIA="Viajes y eventos";ICV.crearCategoria(VIA);

		//USUARIOS
		//las categorias de los canales se las puse para completar datos
		Date fecha;
		DtFecha fechaNac;
		Integer duracion = 1;
		File archivo;
		//public void nuevoUsuario(String nick, String nom, String ape, String e, DtFecha fn, byte[] fo, String nomCanal,
//		String desc, Boolean privacidadE, String catE)
		fecha = asignarFecha("25,02,1962 00:00");
		fechaNac = new DtFecha(fecha);
		String HR="hrubio";
		archivo = new File(ubicacionFoto+"/hr.jpg");
		ICU.nuevoUsuario(HR,"Rufus123", "Horacio", "Rubino", "horacio.rubino@guambia.com.uy", fechaNac, imagenToByte(archivo),
				"Canal Horacio", "El canal Horacio es para publicar contenido divertido",Privacidad.PUBLICO, "Entretenimiento");
		
		fecha = asignarFecha("14,06,1972 00:00");
		fechaNac = new DtFecha(fecha);
		String MB ="mbusca";
		archivo = new File(ubicacionFoto+"/mb.jpg");
		ICU.nuevoUsuario(MB,"Cookier234", "Martin", "Buscaglia", "Martin.bus@agadu.org.uy", fechaNac, imagenToByte(archivo),
				"El bocha", "Mi canal para colgar cosas", Privacidad.PUBLICO, null);
		
		fecha = asignarFecha("07,01,1954 00:00");
		fechaNac = new DtFecha(fecha);
		String HG="hectorg";								 
		ICU.nuevoUsuario(HG,"Poncho345", "Hector", "Guido", "hector.gui@elgalpon.org.uy", fechaNac, null,
				HG, "Canal HG", Privacidad.PUBLICO, null);
		
		fecha=asignarFecha("24,07,1971 00:00");
		fechaNac = new DtFecha(fecha);
		String TC ="tabarec";
		archivo = new File(ubicacionFoto+"/tc.jpg");
		ICU.nuevoUsuario(TC,"Ketchup1", "Tabare", "Cardozo", "tabare.car@agadu.org.uy", fechaNac, imagenToByte(archivo),
				"Tabare", "Mi musica e ainda mais", Privacidad.PUBLICO, MUS);
		
		fecha = asignarFecha("01,01,1947 00:00");
		fechaNac = new DtFecha(fecha);
		String CS="cachilas";
		archivo = new File(ubicacionFoto+"/cs.jpg");
		ICU.nuevoUsuario(CS,"Sancho456", "Walder 'Cachila'", "Silva", "Cachila.sil@c1080.org.uy", fechaNac, imagenToByte(archivo),
				"El Cachila", "Para juntar cosas", Privacidad.PRIVADO, null);
		
		fecha =asignarFecha("16,03,1967 00:00");
		fechaNac = new DtFecha(fecha);
		String JB="juliob";
		ICU.nuevoUsuario(JB,"Salome56", "Julio", "Bocca", "juliobocca@sodre.com.uy", fechaNac, null,
				JB, "Canal de JB", Privacidad.PUBLICO,null);
		
		fecha=asignarFecha("01,01,1975 00:00");
		fechaNac = new DtFecha(fecha);
		String DP="diegop";
		ICU.nuevoUsuario(DP,"Ruffo678", "Diego", "Parodi", "diego@efectocine.com", fechaNac, null,
				DP, "El Canal de DP", Privacidad.PUBLICO,null);
	
		fecha=asignarFecha("25,04,1840 00:00");
		fechaNac = new DtFecha(fecha);
		String KH="kairoh";
		archivo = new File(ubicacionFoto+"/kh.jpg");
		ICU.nuevoUsuario(KH,"Corbata15", "Kairo", "Herrera", "kairoher@pilsenrock.com.uy", fechaNac, imagenToByte(archivo),
				"Kairo Musica", "Videos de grandes canciones de hoy y siempre", Privacidad.PUBLICO, MUS);
		
		fecha=asignarFecha("03,08,1940 00:00");
		fechaNac = new DtFecha(fecha);
		String RH="robinh";
		ICU.nuevoUsuario(RH,"Aquiles67", "Robin", "Henderson", "robin.h@tinglesa.com.uy", fechaNac, null,
				RH, "Henderson", Privacidad.PUBLICO, null);
		
		fecha=asignarFecha("01,04,1960 00:00");
		fechaNac = new DtFecha(fecha);
		String MT="marcelot";
		ICU.nuevoUsuario(MT,"Mancha890", "Marcelo", "Tinelli", "marcelot@ideasdelsur.com.ar", fechaNac, null,
				"Tinelli total", "Todo lo que querias y mas!", Privacidad.PUBLICO , ENT);
		
		fecha=asignarFecha("17,07,1952 00:00");
		fechaNac = new DtFecha(fecha);
		String EN="novick";
		ICU.nuevoUsuario(EN,"Xenon987", "Edgardo", "Novick", "edgardo@novick.com.uy", fechaNac, null,
				"Con la gente", "Preparando las elecciones", Privacidad.PUBLICO, null);
		
		fecha=asignarFecha("28,01,1950 00:00");
		fechaNac = new DtFecha(fecha);
		String SP="sergiop";
		ICU.nuevoUsuario(SP,"Sultan876", "Sergio", "Puglia", "puglia@alpanpan.com.uy", fechaNac, null,
				"Puglia invita", "Programas del ciclo y videos de cocina mastercheef", Privacidad.PUBLICO, COM);
		
		fecha=asignarFecha("17,03,1976 00:00");
		fechaNac = new DtFecha(fecha);
		String AR="chino";
		archivo = new File(ubicacionFoto+"/ar.jpg");
		ICU.nuevoUsuario(AR,"Laika765", "Alvaro", "Recoba", "chino@trico.org.uy", fechaNac, imagenToByte(archivo),
				"Chino Recoba", "Canal de goles con Nacional", Privacidad.PRIVADO, DEP);
		
		fecha=asignarFecha("14,02,1955 00:00");
		fechaNac = new DtFecha(fecha);
		String AP="tonyp";
		archivo = new File(ubicacionFoto+"/ap.jpg");
        ICU.nuevoUsuario(AP,"Kitty543", "Antonio", "Pacheco", "eltony@manya.org.uy", fechaNac, imagenToByte(archivo),
				"Tony Pacheco", "Todos los goles con Peñarol", Privacidad.PRIVADO, DEP);
		
		fecha=asignarFecha("09,08,1960 00:00");
		fechaNac = new DtFecha(fecha);
		String NJ="nicoJ";
		ICU.nuevoUsuario(NJ,"Albino80", "Nicolas", "Jodal", "jodal@artech.com.uy", fechaNac, null,
				"Desde Genexus", "Canal informacion C y T", Privacidad.PUBLICO, CYT);
		
		
		//SEGUIDORES raiz/destino
		ICU.seguirUsuario(HR,HG);ICU.seguirUsuario(HR,DP);
		ICU.seguirUsuario(MB,TC);ICU.seguirUsuario(MB,CS);ICU.seguirUsuario(MB,KH);
		ICU.seguirUsuario(HG,MB);ICU.seguirUsuario(HG,JB);
		ICU.seguirUsuario(TC,HR);ICU.seguirUsuario(TC,CS);
		ICU.seguirUsuario(CS,HR);
		ICU.seguirUsuario(JB,MB);ICU.seguirUsuario(JB,DP);
		ICU.seguirUsuario(DP,HG);
		ICU.seguirUsuario(KH,SP);
		ICU.seguirUsuario(RH,HG);ICU.seguirUsuario(RH,JB);ICU.seguirUsuario(RH,DP);
		ICU.seguirUsuario(MT,CS);ICU.seguirUsuario(MT,JB);ICU.seguirUsuario(MT,KH);
		ICU.seguirUsuario(EN,HR);ICU.seguirUsuario(EN,TC);ICU.seguirUsuario(EN,CS);
		ICU.seguirUsuario(SP,MB);ICU.seguirUsuario(SP,JB);ICU.seguirUsuario(SP,DP);
		ICU.seguirUsuario(AR,AP);
		ICU.seguirUsuario(AP,AR);
		ICU.seguirUsuario(NJ,DP);
		
		
		
		//VIDEOS
		DtCategoria catMUS = new DtCategoria(MUS);
		DtCategoria catNOT = new DtCategoria(NOT);
		DtCategoria catCAR = new DtCategoria(CAR);
		DtCategoria catDEP = new DtCategoria(DEP);
		DtCategoria catCYT = new DtCategoria(CYT);
		
		String V1="Locura celeste";
		ICU.aniadirVideo(TC, V1, null, duracion, fechaNac,"https://youtu.be/PAfbzKcePx0",catMUS, Privacidad.PRIVADO);
		ICU.aniadirVideo(CS, V1, null, duracion, fechaNac,"https://youtu.be/PAfbzKcePx0",catMUS, Privacidad.PRIVADO);
		String V2="Niño payaso";
		ICU.aniadirVideo(TC, V2, null, duracion, fechaNac,"https://youtu.be/K-uEIUnyZPg",catMUS, Privacidad.PRIVADO);
		ICU.aniadirVideo(CS, V2, null, duracion, fechaNac,"https://youtu.be/K-uEIUnyZPg",catMUS, Privacidad.PRIVADO);
		String V3="Sweet child'o mine";
		ICU.aniadirVideo(JB, V3, null, duracion, fechaNac,"https://youtu.be/1w7OgIMMRc4",catMUS,Privacidad.PUBLICO);
		ICU.aniadirVideo(KH, V3, null, duracion, fechaNac,"https://youtu.be/1w7OgIMMRc4",catMUS,Privacidad.PUBLICO);
		String V4="Dancing in the Dark";
		ICU.aniadirVideo(KH, V4, null, duracion, fechaNac,"https://youtu.be/129kuDCQtHs", catMUS, Privacidad.PUBLICO);
		String V5="Thriller";
		ICU.aniadirVideo(JB, V5, null, duracion, fechaNac,"https://youtu.be/sOnqjkJTMaA",catMUS,Privacidad.PUBLICO);
		ICU.aniadirVideo(KH, V5, null, duracion, fechaNac,"https://youtu.be/sOnqjkJTMaA",catMUS,Privacidad.PUBLICO);
		String V6="100 años de FING";
		ICU.aniadirVideo(HG, V6, null, duracion, fechaNac,"https://youtu.be/peGS4TBxSaI",catNOT ,Privacidad.PUBLICO);
		String V7="50 años del InCo";
		ICU.aniadirVideo(HG, V7, null, duracion, fechaNac,"https://youtu.be/GzOJSk4urlM",catNOT , Privacidad.PUBLICO);
		String V8="Ingenieria de Muestra 2017";
		ICU.aniadirVideo(HG, V8, null, duracion, fechaNac,"https://youtu.be/RnaYRA1k5j4", catNOT, Privacidad.PUBLICO);
		String V9="Etapa A contramano Liguilla";
		ICU.aniadirVideo(CS, V9, null, duracion, fechaNac,"https://youtu.be/Es6GRMHXeCQ",catCAR , Privacidad.PRIVADO);
		String V10="Etapa Don Timoteo Liguilla";
		ICU.aniadirVideo(CS, V10, null, duracion, fechaNac,"https://youtu.be/I_spHBU9ZsI",catCAR , Privacidad.PRIVADO);
		String V11="Show de Goles";
		ICU.aniadirVideo(JB, V11, null, duracion, fechaNac,"https://youtu.be/g46w4_kD_lA", catDEP, Privacidad.PUBLICO);
		String V12="Pacheco goles mas recordados";
		ICU.aniadirVideo(TC, V12, null, duracion, fechaNac,"https://youtu.be/wlEd6-HsIxI", catDEP, Privacidad.PRIVADO);
		ICU.aniadirVideo(AP, V12, null, duracion, fechaNac,"https://youtu.be/wlEd6-HsIxI", catDEP, Privacidad.PRIVADO);
		String V13="Inaguracion Estadio Peñarol";
		ICU.aniadirVideo(JB, V13, null, duracion, fechaNac,"https://youtu.be/U6XPJ8Vz72A",catDEP ,Privacidad.PUBLICO);
		String V14="Recoba 20 mejores goles";
		ICU.aniadirVideo(CS, V14, null, duracion, fechaNac,"https://youtu.be/Gy3fZhWdLEQ", catDEP, Privacidad.PRIVADO);
		ICU.aniadirVideo(AR, V14, null, duracion, fechaNac,"https://youtu.be/Gy3fZhWdLEQ", catDEP, Privacidad.PRIVADO);
		String V15="Entrevista a director CUTI";
		ICU.aniadirVideo(NJ, V15, null, duracion, fechaNac,"https://youtu.be/Eq5uBEzI6qs",catCYT,Privacidad.PUBLICO);
		String V16="Ventana al futuro Uruguay y deficit de ingenieros";
		ICU.aniadirVideo(NJ, V16, null, duracion, fechaNac,"https://youtu.be/zBR2pnASlQE",catCYT ,Privacidad.PUBLICO);
		
		//LISTAS PARTICULARES //tienen categoria??
		//ICU.nuevaListaParticular(String nickU, String nombreL, Boolean privada)
		String LP1="Nostalgia";	ICU.nuevaListaParticular(KH,LP1,Privacidad.PUBLICO); //MUS LP1
		String LP2="De fiesta"; ICU.nuevaListaParticular(TC,LP2,Privacidad.PRIVADO);//MUS DEP LP2
 		String LP3="Novedades FING"; ICU.nuevaListaParticular(HG,LP3,Privacidad.PUBLICO);//NOT LP3
		String LP4="De todo un poco";ICU.nuevaListaParticular(CS,LP4,Privacidad.PRIVADO);//MUS DEP CAR LP4
		String LP5="Noticias y CYT";ICU.nuevaListaParticular(NJ,LP5,Privacidad.PUBLICO); //NOT CYT LP5
		String LP6="Solo deportes";ICU.nuevaListaParticular(JB,LP6,Privacidad.PUBLICO); //dep LP6
		
		//DtVideo video = ICU.obtenerInfoAdicVideo(nicknameAutor, nombreVideo);
	//	int idVideo = video.getIDVideo();
		//ICU.agregarVideoLista(nicknameUsuario, idVideo, nombreListaReproduccion);
		DtVideo video = ICU.obtenerInfoAdicVideo(KH,V3);
		int idVideo = video.getiDVideo();
		ICU.agregarVideoLista(KH,idVideo,LP1);
		
		video = ICU.obtenerInfoAdicVideo(KH,V4);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(KH,idVideo,LP1);
		
		video = ICU.obtenerInfoAdicVideo(JB,V5);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(KH,idVideo,LP1);
		
		video = ICU.obtenerInfoAdicVideo(TC,V1);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(TC,idVideo,LP2);
		
		video = ICU.obtenerInfoAdicVideo(TC,V2);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(TC,idVideo,LP2);
		
		video = ICU.obtenerInfoAdicVideo(JB,V11);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(TC,idVideo,LP2);
		
		video = ICU.obtenerInfoAdicVideo(CS,V10);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(TC,idVideo,LP2);
		
		video = ICU.obtenerInfoAdicVideo(HG,V6);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(HG,idVideo,LP3);
		
		video = ICU.obtenerInfoAdicVideo(HG,V7);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(HG,idVideo,LP3);
		
		video = ICU.obtenerInfoAdicVideo(HG,V8);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(HG,idVideo,LP3);
		
		video = ICU.obtenerInfoAdicVideo(CS,V1);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(CS,idVideo,LP4);
		
		video = ICU.obtenerInfoAdicVideo(CS,V2);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(CS,idVideo,LP4);
		
		video = ICU.obtenerInfoAdicVideo(CS,V9);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(CS,idVideo,LP4);
		
		video = ICU.obtenerInfoAdicVideo(CS,V10);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(CS,idVideo,LP4);
		
		video = ICU.obtenerInfoAdicVideo(JB,V13);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(CS,idVideo,LP4);
		
		video = ICU.obtenerInfoAdicVideo(HG,V8);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(NJ,idVideo,LP5);
		
		video = ICU.obtenerInfoAdicVideo(NJ,V16);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(NJ,idVideo,LP5);

		video = ICU.obtenerInfoAdicVideo(JB,V11);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(JB,idVideo,LP6);

		video = ICU.obtenerInfoAdicVideo(JB,V13);
		idVideo = video.getiDVideo();
		ICU.agregarVideoLista(JB,idVideo,LP6);

		//LISTAS POR DEFECTO
		ICU.nuevaListaPorDefecto("Escuchar mas tarde"); //LD1
		ICU.nuevaListaPorDefecto("Deporte total"); //LD2
		ICU.nuevaListaPorDefecto("Novedades generales");//LD3
		
		//COMENTARIOS
		int comentarioPadre;
		//video V7
		VideoHandler vh=VideoHandler.getInstance();
		DtVideo dtVideo =vh.member(V7,HG); //propietario del video HG	
		
		fecha=asignarFecha("5,12,2017 14:35"); DtFecha fechaVideo = new DtFecha(fecha); 
		ICV.nuevoComentario(dtVideo.getiDVideo(),NJ, fechaVideo,"Fue un gran evento" );
			
		comentarioPadre=obtenerIdComentario(dtVideo.getiDVideo(),NJ, fechaVideo);
		fecha = asignarFecha("8,12,2017 01:47");fechaVideo = new DtFecha(fecha); 
		ICV.responderComentario(dtVideo.getiDVideo(),comentarioPadre, HR, fechaVideo, "Para el proximo aniversario ofrezco vamo con Los Momo");
		
		comentarioPadre=obtenerIdComentario(dtVideo.getiDVideo(),HR, fechaVideo);
		fecha = asignarFecha("10,12,2017 17:09");fechaVideo = new DtFecha(fecha); 
		ICV.responderComentario(dtVideo.getiDVideo(),comentarioPadre, TC, fechaVideo, "Yo ofrezco a la banda tb");
		
		dtVideo =vh.member(V6,HG);
		fecha=asignarFecha("07,09,2017 04:56");fechaVideo = new DtFecha(fecha); 
		ICV.nuevoComentario(dtVideo.getiDVideo(), NJ, fechaVideo, "Felicitaciones FING");
		
		dtVideo =vh.member(V8,HG);
		fecha=asignarFecha("23,10,2017 12:58");fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getiDVideo(),KH,fechaVideo, "Un gusto cubrir eventos como este.");
		
		comentarioPadre=obtenerIdComentario(dtVideo.getiDVideo(),NJ, fechaVideo);
		fecha = asignarFecha("11,09,2018 03:45");fechaVideo = new DtFecha(fecha); 
		ICV.responderComentario(dtVideo.getiDVideo(),comentarioPadre, MT, fechaVideo, "Se viene la edicion 2018!!!");
		
		dtVideo =vh.member(V13,JB);
		fecha=asignarFecha("14,11,2016 05:34");fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getiDVideo(),KH,fechaVideo,"Peñarol peñarol!!!");
		
		dtVideo =vh.member(V3,KH);
		fecha=asignarFecha("30,10,2017 02:17");fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getiDVideo(),MT,fechaVideo,"Rock and Rollll");
		dtVideo =vh.member(V3,JB);
		fecha=asignarFecha("30,10,2017 02:17");fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getiDVideo(),MT,fechaVideo,"Rock and Rollll");
		
		dtVideo =vh.member(V4,KH);
		fecha=asignarFecha("25,08,2018 18:00");fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getiDVideo(),MT,fechaVideo,"Anoche exploto!!!");
		
		dtVideo =vh.member(V1,CS);
		fecha=asignarFecha("11,09,2017 03:45");fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getiDVideo(),MT,fechaVideo,"Me encanta este tema");
		comentarioPadre=obtenerIdComentario(dtVideo.getiDVideo(),MT, fechaVideo);
		fecha = asignarFecha("15,09,2017 12:29");fechaVideo = new DtFecha(fecha); 
		ICV.responderComentario(dtVideo.getiDVideo(),comentarioPadre,TC,fechaVideo, "Gracias Marce ;)");
		
		dtVideo =vh.member(V1,TC);
		fecha=asignarFecha("11,09,2017 03:45");fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getiDVideo(),MT,fechaVideo,"Me encanta este tema");
		comentarioPadre=obtenerIdComentario(dtVideo.getiDVideo(),MT, fechaVideo);
		fecha = asignarFecha("15,09,2017 12:29");fechaVideo = new DtFecha(fecha); 
		ICV.responderComentario(dtVideo.getiDVideo(),comentarioPadre,TC,fechaVideo, "Gracias Marce ;)");
		
		dtVideo =vh.member(V1,TC);
		fecha=asignarFecha("15,09,2017 12:29");fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getiDVideo(),TC,fechaVideo,"Mi preferido por lejos!!!");
		
		//ME GUSTA
		video = ICU.obtenerInfoAdicVideo(HG,V7);
		ICV.valorarVideo(video.getiDVideo(),SP, false); //falso = NO LE GUSTA
		
		video = ICU.obtenerInfoAdicVideo(HG,V8);
		ICV.valorarVideo(video.getiDVideo(),SP, true);
		
		video = ICU.obtenerInfoAdicVideo(JB,V11);
		ICV.valorarVideo(video.getiDVideo(),SP, true);
		
		video = ICU.obtenerInfoAdicVideo(KH,V4);
		ICV.valorarVideo(video.getiDVideo(),NJ, false);
		
		video = ICU.obtenerInfoAdicVideo(CS,V1);
		ICV.valorarVideo(video.getiDVideo(),NJ, false);
		
		video = ICU.obtenerInfoAdicVideo(HG,V7);
		ICV.valorarVideo(video.getiDVideo(),NJ, true);
		
		video = ICU.obtenerInfoAdicVideo(HG,V7);
		ICV.valorarVideo(video.getiDVideo(),KH, true);
		
		video = ICU.obtenerInfoAdicVideo(JB,V13);
		ICV.valorarVideo(video.getiDVideo(),KH, true);
		
		video = ICU.obtenerInfoAdicVideo(CS,V1);
		ICV.valorarVideo(video.getiDVideo(),MT, true);
		
		video = ICU.obtenerInfoAdicVideo(HG,V8);
		ICV.valorarVideo(video.getiDVideo(),MT, true);
		
		video = ICU.obtenerInfoAdicVideo(KH,V4);
		ICV.valorarVideo(video.getiDVideo(),MT, true);
		
		//historial
		video = ICU.obtenerInfoAdicVideo(TC, V1);
		ICU.agregarVisita(video.getiDVideo(),TC);
		ICU.agregarVisita(video.getiDVideo(),CS);
	
		video = ICU.obtenerInfoAdicVideo(TC, V2);
		ICU.agregarVisita(video.getiDVideo(),TC);
		ICU.agregarVisita(video.getiDVideo(),CS);
		
		video = ICU.obtenerInfoAdicVideo(CS,V2);
		ICU.agregarVisita(video.getiDVideo(),TC);
		ICU.agregarVisita(video.getiDVideo(),CS);
		
		video = ICU.obtenerInfoAdicVideo(KH,V3);
		agregarVisitasAlHistorial(MB, video.getiDVideo(), 5);
		agregarVisitasAlHistorial(CS, video.getiDVideo(), 20);
		agregarVisitasAlHistorial(JB, video.getiDVideo(), 1);
		agregarVisitasAlHistorial(DP, video.getiDVideo(), 2);
		agregarVisitasAlHistorial(KH, video.getiDVideo(), 8);
		
		video = ICU.obtenerInfoAdicVideo(KH,V4);
		agregarVisitasAlHistorial(KH, video.getiDVideo(), 6);
		agregarVisitasAlHistorial(NJ, video.getiDVideo(), 8);
		
		video = ICU.obtenerInfoAdicVideo(JB, V5);
		agregarVisitasAlHistorial(MB, video.getiDVideo(), 4);
		agregarVisitasAlHistorial(JB, video.getiDVideo(), 1);
		agregarVisitasAlHistorial(DP, video.getiDVideo(), 1);
		agregarVisitasAlHistorial(KH, video.getiDVideo(), 2);
		
		video = ICU.obtenerInfoAdicVideo(KH, V5);
		agregarVisitasAlHistorial(MB, video.getiDVideo(), 4);
		agregarVisitasAlHistorial(JB, video.getiDVideo(), 1);
		agregarVisitasAlHistorial(DP, video.getiDVideo(), 1);
		agregarVisitasAlHistorial(KH, video.getiDVideo(), 2);
		
		video = ICU.obtenerInfoAdicVideo(HG, V6);
		agregarVisitasAlHistorial(HR, video.getiDVideo(), 2);
		agregarVisitasAlHistorial(MB, video.getiDVideo(), 1);
		agregarVisitasAlHistorial(HG, video.getiDVideo(), 1);
		agregarVisitasAlHistorial(SP, video.getiDVideo(), 5);
		agregarVisitasAlHistorial(AP, video.getiDVideo(), 1);
		
		video = ICU.obtenerInfoAdicVideo(HG, V7);
		agregarVisitasAlHistorial(MB, video.getiDVideo(), 1);
		agregarVisitasAlHistorial(HG, video.getiDVideo(), 1);
		agregarVisitasAlHistorial(SP, video.getiDVideo(), 1);
		agregarVisitasAlHistorial(AR, video.getiDVideo(), 1);
		agregarVisitasAlHistorial(NJ, video.getiDVideo(), 3);
		
		video = ICU.obtenerInfoAdicVideo(HG, V8);
		agregarVisitasAlHistorial(MB, video.getiDVideo(), 1);
		agregarVisitasAlHistorial(HG, video.getiDVideo(), 1);
		agregarVisitasAlHistorial(SP, video.getiDVideo(), 1);
		agregarVisitasAlHistorial(NJ, video.getiDVideo(), 21);
		
		video = ICU.obtenerInfoAdicVideo(CS, V9);
		agregarVisitasAlHistorial(CS, video.getiDVideo(), 1);
		
		video = ICU.obtenerInfoAdicVideo(CS, V10);
		agregarVisitasAlHistorial(CS, video.getiDVideo(), 2);
		agregarVisitasAlHistorial(KH, video.getiDVideo(), 1);
		
		video = ICU.obtenerInfoAdicVideo(JB, V11);
		agregarVisitasAlHistorial(HR, video.getiDVideo(), 4);
		agregarVisitasAlHistorial(MB, video.getiDVideo(), 3);
		agregarVisitasAlHistorial(HG, video.getiDVideo(), 10);
		agregarVisitasAlHistorial(CS, video.getiDVideo(), 5);
		agregarVisitasAlHistorial(JB, video.getiDVideo(), 2);
		agregarVisitasAlHistorial(SP, video.getiDVideo(), 2);
		
		video = ICU.obtenerInfoAdicVideo(TC, V12);
		agregarVisitasAlHistorial(TC, video.getiDVideo(), 1);
		
		video = ICU.obtenerInfoAdicVideo(AP, V12);
		agregarVisitasAlHistorial(TC, video.getiDVideo(), 1);
		
		video = ICU.obtenerInfoAdicVideo(JB, V13);
		agregarVisitasAlHistorial(JB, video.getiDVideo(), 2);
		
		video = ICU.obtenerInfoAdicVideo(AR, V14);
		
		video = ICU.obtenerInfoAdicVideo(NJ, V15);
		agregarVisitasAlHistorial(NJ, video.getiDVideo(), 10);
		
		video = ICU.obtenerInfoAdicVideo(NJ, V16);
		agregarVisitasAlHistorial(NJ, video.getiDVideo(), 4);
		
		
		
	}
	private void agregarVisitasAlHistorial(String nick, int idV, int cantVeces){
		for(int i=cantVeces; i>0;i--){
			ICU.agregarVisita(idV,nick);
		}
	}
	private Date asignarFecha(String fechaConHora){
		SimpleDateFormat sdf = new SimpleDateFormat("dd,MM,yyyy HH:mm");
		Date fecha = null;
		try {
			fecha = sdf.parse(fechaConHora);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return fecha;
	}
	private int obtenerIdComentario(int idVideo,String nick, DtFecha fechaComen){
		DtComentario[] coments= ICV.listarComentarios(idVideo);
		return buscarComentario(coments, nick,fechaComen);
	}
	private int buscarComentario(DtComentario[] coments, String nick, DtFecha fechaComen){
		DtComentario[] comentsHijos;
		int i=0; int idComentario=-1;
		while(i<coments.length){
			if(coments[i].getFecha()==fechaComen && coments[i].getNickUsuario()==nick){
				return coments[i].getIdComentario();
			}
			comentsHijos = coments[i].getRespuestas();
			idComentario = buscarComentario(comentsHijos,nick, fechaComen);
			i++;
		}
		return idComentario;
	}
}
