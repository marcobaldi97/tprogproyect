package uytube.admin;

import java.util.Date;

import uytube.logica.CategoriaHandler;
import uytube.logica.DtCategoria;
import uytube.logica.DtFecha;
import uytube.logica.DtVideo;
import uytube.logica.Factory;
import uytube.logica.IUsuarioCtrl;
import uytube.logica.IVideoCtrl;
import uytube.logica.VideoHandler;

public class DatosDePrueba {
	public void cargarDatosDePrueba(){
		Factory fabrica = Factory.getInstance();
		IUsuarioCtrl ICU = fabrica.getIUsuarioCtrl();
		IVideoCtrl ICV = fabrica.getIVideoCtrl();
		
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
		Date fecha = new Date();
		//fecha.setTime(666666);
		DtFecha fechaNac;
	
		Integer duracion = 7315;
		//public void nuevoUsuario(String nick, String nom, String ape, String e, DtFecha fn, byte[] fo, String nomCanal,
//		String desc, Boolean privacidadE, String catE)
		fecha.setTime(25021962);
		fechaNac = new DtFecha(fecha);
		String HR="hrubio";
		ICU.nuevoUsuario(HR, "Horacio", "Rubino", "horacio.rubino@guambia.com.uy", fechaNac, null,
				"Canal Horacio", "El canal Horacio es para publicar contenido divertido",true, "Entretenimiento");
		
		fecha.setTime(14061972);
		fechaNac = new DtFecha(fecha);
		String MB ="mbusca";
		ICU.nuevoUsuario(MB, "Martin", "Buscaglia", "Martin.bus@agadu.org.uy", fechaNac, null,
				"El bocha", "Mi canal para colgar cosas", true, null);
		
		fecha.setTime(7011954);
		fechaNac = new DtFecha(fecha);
		String HG="hectorg";
		ICU.nuevoUsuario(HG, "Hector", "Guido", "hector.gui@elgalpon.org.uy", fechaNac, null,
				null, "Canal HG", true, null);
		
		fecha.setTime(24071971);
		fechaNac = new DtFecha(fecha);
		String TC ="tabarec";
		ICU.nuevoUsuario(TC, "Tabare", "Cardozo", "tabare.car@agadu.otg.uy", fechaNac, null,
				"Tabare", "Mi musica e ainda mais", true, "Musica");
		
		fecha.setTime(111947);
		fechaNac = new DtFecha(fecha);
		String CS="cachilas";
		ICU.nuevoUsuario(CS, "Walder 'Cachila'", "Silva", "Cachila.sil@c1080.org.uy", fechaNac, null,
				"El Cachila", "Para juntar cosas", false, null);
		
		fecha.setTime(1631927);
		fechaNac = new DtFecha(fecha);
		String JB="juliob";
		ICU.nuevoUsuario(JB, "Julio", "Bocca", "juliobocca@sodre.com.uy", fechaNac, null,
				null, "Canal de JB", true,null);
		
		fecha.setTime(111975);
		fechaNac = new DtFecha(fecha);
		String DP="diegop";
		ICU.nuevoUsuario(DP, "Diego", "Parodi", "diego@efectocine", fechaNac, null,
				null, "El Canal de DP", true , null);
	
		fecha.setTime(2541840);
		fechaNac = new DtFecha(fecha);
		String KH="kahiroh";
		ICU.nuevoUsuario(KH, "Kairo", "Herrera", "kairoher@pilsenrock.com.uy", fechaNac, null,
				"Kairo Musica", "Videos de grandes canciones de hoy y siempre", true, "Musica");
		
		fecha.setTime(381940);
		fechaNac = new DtFecha(fecha);
		String RH="robinh";
		ICU.nuevoUsuario(RH, "Robin", "Henderson", "robin.h@tinglesa.com.uy", fechaNac, null,
				null, "Henderson", true, null);
		
		fecha.setTime(141960);
		fechaNac = new DtFecha(fecha);
		String MT="marcelot";
		ICU.nuevoUsuario(MT, "Marcelo", "Tinelli", "marcelot@ideasdelsur.com.ar", fechaNac, null,
				"Tinelli total", "Todo lo que querias y mas!", true , "Entretenimiento");
		
		fecha.setTime(1771952);
		fechaNac = new DtFecha(fecha);
		String EN="novick";
		ICU.nuevoUsuario(EN, "Edgardo", "Novick", "edgardo@novick.com.uy", fechaNac, null,
				"Con la gente", "Preparando las elecciones", true, null);
		
		fecha.setTime(2811950);
		fechaNac = new DtFecha(fecha);
		String SP="sergiop";
		ICU.nuevoUsuario(SP, "Sergio", "Puglia", "puglia@alpanpan.com.uy", fechaNac, null,
				"Sergio invita", "Programas del ciclo y videos de cocina mastercheef", true, "Cocina");
		
		fecha.setTime(1731976);
		fechaNac = new DtFecha(fecha);
		String AR="chino";
		ICU.nuevoUsuario(AR, "Alvaro", "Recoba", "chino@trico.org.uy", fechaNac, null,
				"Chino Recoba", "Canal de goles con Nacional", false, "Deportes");
		
		fecha.setTime(1421955);
		fechaNac = new DtFecha(fecha);
		String AP="tonyp";
		ICU.nuevoUsuario(AP, "Antonio", "Pacheco", "eltony@manya.org.uy", fechaNac, null,
				"Tony Pacheco", "Todos los goles con Peñarol", false, "Deportes");
		
		fecha.setTime(981960);
		fechaNac = new DtFecha(fecha);
		String NJ="nicoJ";
		ICU.nuevoUsuario(NJ, "Nicolas", "Jodal", "jodal@artech.com.uy", fechaNac, null,
				"Desde Genexus", "Canal informacion C y T", false, "Ciencia y Tecnologia");
		
		
		//SEGUIDORES seguido/seguidor
		ICU.seguirUsuario(HR,TC);ICU.seguirUsuario(HR,CS);ICU.seguirUsuario(HR,EN);
		ICU.seguirUsuario(MB,HG);ICU.seguirUsuario(MB,JB);ICU.seguirUsuario(MB,SP);
		ICU.seguirUsuario(HG,HR);ICU.seguirUsuario(HG,DP);ICU.seguirUsuario(HG,RH);
		ICU.seguirUsuario(TC,MB);ICU.seguirUsuario(TC,EN);
		ICU.seguirUsuario(CS,MB);ICU.seguirUsuario(CS,TC);ICU.seguirUsuario(CS,MT);ICU.seguirUsuario(CS,EN);
		ICU.seguirUsuario(JB,HG);ICU.seguirUsuario(JB,RH);ICU.seguirUsuario(JB,MT);
		ICU.seguirUsuario(DP,JB);ICU.seguirUsuario(DP,RH);ICU.seguirUsuario(DP,SP);	ICU.seguirUsuario(DP,NJ);
		ICU.seguirUsuario(KH,MB);ICU.seguirUsuario(KH,MT);
		
		
		//VIDEOS
		//public void aniadirVideo(String nickU, String nom, String desc, Integer dur, DtFecha fp, String url,
			//	DtCategoria catE, boolean p) {
		DtCategoria catMUS = new DtCategoria(MUS);
		DtCategoria catNOT = new DtCategoria(NOT);
		DtCategoria catCAR = new DtCategoria(CAR);
		DtCategoria catDEP = new DtCategoria(DEP);
		DtCategoria catCYT = new DtCategoria(CYT);
		
		String V1="Locura celeste";
		ICU.aniadirVideo(TC, V1, null, duracion, fechaNac,"https://youtu.be/PAfbzKcePx0",catMUS, false);
		ICU.aniadirVideo(CS, V1, null, duracion, fechaNac,"https://youtu.be/PAfbzKcePx0",catMUS, false);
		String V2="Niño payaso";
		ICU.aniadirVideo(TC, V2, null, duracion, fechaNac,"https://youtu.be/K-uEIUnyZPg",catMUS, false);
		ICU.aniadirVideo(CS, V2, null, duracion, fechaNac,"https://youtu.be/K-uEIUnyZPg",catMUS, false);
		String V3="Sweet child'o mine";
		ICU.aniadirVideo(JB, V3, null, duracion, fechaNac,"https://youtu.be/1w7OgIMMRc4",catMUS,true);
		ICU.aniadirVideo(KH, V3, null, duracion, fechaNac,"https://youtu.be/1w7OgIMMRc4",catMUS,true);
		String V4="Dancing in the Dark";
		ICU.aniadirVideo(KH, V4, null, duracion, fechaNac,"https://youtu.be/129kuDCQtHs", catMUS, true);
		String V5="Thriler";
		ICU.aniadirVideo(JB, V5, null, duracion, fechaNac,"https://youtu.be/sOnqjkJTMaA",catMUS,true);
		ICU.aniadirVideo(KH, V5, null, duracion, fechaNac,"https://youtu.be/sOnqjkJTMaA",catMUS,true);
		String V6="100 años de FING";
		ICU.aniadirVideo(HG, V6, null, duracion, fechaNac,"https://youtu.be/peGS4TBxSaI",catNOT ,true);
		String V7="50 años del InCo";
		ICU.aniadirVideo(HG, V7, null, duracion, fechaNac,"https://youtu.be/GzOJSk4urlM",catNOT , true);
		String V8="Ingenieria de Muestra 2017";
		ICU.aniadirVideo(HG, V8, null, duracion, fechaNac,"https://youtu.be/RnaYRA1k5j4", catNOT, true);
		String V9="Etapa A contramano Liguilla";
		ICU.aniadirVideo(CS, V9, null, duracion, fechaNac,"https://youtu.be/Es6GRMHXeCQ",catCAR , false);
		String V10="Etapa Don Timoteo Liguilla";
		ICU.aniadirVideo(CS, V10, null, duracion, fechaNac,"https://youtu.be/I_spHBU9ZsI",catCAR , false);
		String V11="Show de Goles";
		ICU.aniadirVideo(JB, V11, null, duracion, fechaNac,"https://youtu.be/g46w4_kD_lA", catDEP, true);
		String V12="Pacheco goles mas recordados";
		ICU.aniadirVideo(TC, V12, null, duracion, fechaNac,"https://youtu.be/wlEd6-HsIxI", catDEP, false);
		ICU.aniadirVideo(AP, V12, null, duracion, fechaNac,"https://youtu.be/wlEd6-HsIxI", catDEP, false);
		String V13="Inaguracion Estadio Peñarol";
		ICU.aniadirVideo(JB, V13, null, duracion, fechaNac,"https://youtu.be/U6XPJ8Vz72A",catDEP ,true);
		String V14="Recoba 20 mejores goles";
		ICU.aniadirVideo(CS, V14, null, duracion, fechaNac,"https://youtu.be/Gy3fZhWdLEQ", catDEP, false);
		ICU.aniadirVideo(AR, V14, null, duracion, fechaNac,"https://youtu.be/Gy3fZhWdLEQ", catDEP, false);
		String V15="Entrevita a director CUTI";
		ICU.aniadirVideo(NJ, V15, null, duracion, fechaNac,"https://youtu.be/Eq5uBEzI6qs",catCYT,true);
		String V16="Ventana al futuro Uruguay y deficit de ingenieros";
		ICU.aniadirVideo(NJ, V16, null, duracion, fechaNac,"https://youtu.be/zBR2pnASlQE",catCYT ,true);
		
		//LISTAS PARTICULARES //tienen categoria??
		//ICU.nuevaListaParticular(String nickU, String nombreL, Boolean privada)
		String LP1="Nostalgia";	ICU.nuevaListaParticular(KH,LP1,true); //MUS LP1
		String LP2="De fiesta"; ICU.nuevaListaParticular(TC,LP2,false);//MUS DEP LP2
 		String LP3="Novedades FING"; ICU.nuevaListaParticular(HG,LP3,true);//NOT LP3
		String LP4="De todo un poco";ICU.nuevaListaParticular(CS,LP4,false);//MUS DEP CAR LP4
		String LP5="Noticias y CYT";ICU.nuevaListaParticular(NJ,LP5,true); //NOT CYT LP5
		String LP6="Solo deportes";ICU.nuevaListaParticular(JB,LP6,true); //dep LP6
		
		//DtVideo video = ICU.obtenerInfoAdicVideo(nicknameAutor, nombreVideo);
	//	int idVideo = video.getIDVideo();
		//ICU.agregarVideoLista(nicknameUsuario, idVideo, nombreListaReproduccion);
		DtVideo video = ICU.obtenerInfoAdicVideo(KH,V3);
		int idVideo = video.getIDVideo();
		ICU.agregarVideoLista(KH,idVideo,LP1);
		
		video = ICU.obtenerInfoAdicVideo(KH,V4);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(KH,idVideo,LP1);
		
		video = ICU.obtenerInfoAdicVideo(JB,V5);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(KH,idVideo,LP1);
		
		video = ICU.obtenerInfoAdicVideo(TC,V1);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(TC,idVideo,LP2);
		
		video = ICU.obtenerInfoAdicVideo(TC,V2);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(TC,idVideo,LP2);
		
		video = ICU.obtenerInfoAdicVideo(CS,V10);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(TC,idVideo,LP2);
		
		video = ICU.obtenerInfoAdicVideo(HG,V6);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(HG,idVideo,LP3);
		
		video = ICU.obtenerInfoAdicVideo(HG,V7);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(HG,idVideo,LP3);
		
		video = ICU.obtenerInfoAdicVideo(HG,V8);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(HG,idVideo,LP3);
		
		video = ICU.obtenerInfoAdicVideo(CS,V1);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(CS,idVideo,LP4);
		
		video = ICU.obtenerInfoAdicVideo(CS,V2);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(CS,idVideo,LP4);
		
		video = ICU.obtenerInfoAdicVideo(CS,V9);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(CS,idVideo,LP4);
		
		video = ICU.obtenerInfoAdicVideo(CS,V10);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(CS,idVideo,LP4);
		
		video = ICU.obtenerInfoAdicVideo(JB,V13);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(CS,idVideo,LP4);
		
		video = ICU.obtenerInfoAdicVideo(HG,V8);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(NJ,idVideo,LP5);
		video = ICU.obtenerInfoAdicVideo(NJ,V16);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(NJ,idVideo,LP5);

		video = ICU.obtenerInfoAdicVideo(JB,V11);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(JB,idVideo,LP6);

		video = ICU.obtenerInfoAdicVideo(JB,V13);
		idVideo = video.getIDVideo();
		ICU.agregarVideoLista(JB,idVideo,LP6);

		//LISTAS POR DEFECTO
		ICU.nuevaListaPorDefecto("Escuchar mas tarde"); //LD1
		ICU.nuevaListaPorDefecto("Deporte total"); //LD2
		ICU.nuevaListaPorDefecto("Novedades generales");//LD3

		VideoHandler vh=VideoHandler.getInstance();
		DtVideo dtVideo =vh.member(V7);
	
		fecha.setDate(5);fecha.setMonth(12);fecha.setYear(17);fecha.setTime(1435);
		DtFecha fechaVideo = new DtFecha(fecha); //5,12,2017,14:35
		ICV.nuevoComentario(dtVideo.getIDVideo(),NJ, fechaVideo,"Fue un gran evento" );
		
		//mal!!
		dtVideo =vh.member(V7);
	   fechaVideo = new DtFecha(fecha); //8,12,2017,01:47
	  // 	ICV.responderComentario(dtVideo.getIDVideo(), 2, "RobertoDeportista", fechaNacRoberto, "Anda al gym gordito"); ???
		ICV.nuevoComentario(1, HR, fechaVideo, "Para el proximo aniversario ofresco vamo con Los Momo");
		
		dtVideo =vh.member(V6);
		fechaVideo = new DtFecha(fecha); //07,09,17, 04:56 am
		ICV.nuevoComentario(dtVideo.getIDVideo(), NJ, fechaVideo, "Felicitaciones FING");
		
		dtVideo =vh.member(V7);
		fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getIDVideo(), , fechaVideo, "");
		
		dtVideo =vh.member(V7);
		fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getIDVideo(), , fechaVideo, "");
		dtVideo =vh.member(V7);
		fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getIDVideo(), , fechaVideo, "");
		dtVideo =vh.member(V7);
		fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getIDVideo(), , fechaVideo, "");
		dtVideo =vh.member(V7);
		fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getIDVideo(), , fechaVideo, "");
		dtVideo =vh.member(V7);
		fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getIDVideo(), , fechaVideo, "");
		dtVideo =vh.member(V7);
		fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getIDVideo(), , fechaVideo, "");
		dtVideo =vh.member(V7);
		fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getIDVideo(), , fechaVideo, "");
		
		//ME GUSTA
		video = ICU.obtenerInfoAdicVideo(HG,V7);
		ICV.valorarVideo(video.getIDVideo(),SP, false);
		
		video = ICU.obtenerInfoAdicVideo(HG,V8);
		ICV.valorarVideo(video.getIDVideo(),SP, true);
		
		video = ICU.obtenerInfoAdicVideo(JB,V11);
		ICV.valorarVideo(video.getIDVideo(),SP, true);
		
		video = ICU.obtenerInfoAdicVideo(CS,V1);
		ICV.valorarVideo(video.getIDVideo(),NJ, false);
		
		video = ICU.obtenerInfoAdicVideo(HG,V7);
		ICV.valorarVideo(video.getIDVideo(),NJ, true);
		
		video = ICU.obtenerInfoAdicVideo(HG,V7);
		ICV.valorarVideo(video.getIDVideo(),KH, true);
		
		video = ICU.obtenerInfoAdicVideo(JB,V13);
		ICV.valorarVideo(video.getIDVideo(),KH, true);
		
		video = ICU.obtenerInfoAdicVideo(CS,V1);
		ICV.valorarVideo(video.getIDVideo(),MT, true);
		
		video = ICU.obtenerInfoAdicVideo(KH,V4);
		ICV.valorarVideo(video.getIDVideo(),MT, true);
		
		
		ICV.responderComentario(1, 2, "BokuNoNaruto", fechaNacRoberto, "Noo");
		ICV.responderComentario(1, 3, "BokuNoNaruto", fechaNacRoberto, "PASEN POR MI CANAL");
		ICV.nuevoComentario(1, "pepeDeportes", fechaVideo, "Comenten si alguien lo esta viendo en el 2050");
		// public abstract void responderComentario(Integer IDVideo, Integer IDCR,
		// String nickU, DtFecha fecha, String contenido);
	}
}
