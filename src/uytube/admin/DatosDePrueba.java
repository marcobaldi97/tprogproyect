package uytube.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import uytube.logica.CategoriaHandler;
import uytube.logica.DtCategoria;
import uytube.logica.DtComentario;
import uytube.logica.DtFecha;
import uytube.logica.DtVideo;
import uytube.logica.Factory;
import uytube.logica.IUsuarioCtrl;
import uytube.logica.IVideoCtrl;
import uytube.logica.VideoHandler;

public class DatosDePrueba {
	private Factory fabrica = Factory.getInstance();
	private IUsuarioCtrl ICU = fabrica.getIUsuarioCtrl();
	private IVideoCtrl ICV = fabrica.getIVideoCtrl();
	public void cargarDatosDePrueba(){
			
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
		String sFecha;
		DtFecha fechaNac;
		Integer duracion = 1;
		
		//public void nuevoUsuario(String nick, String nom, String ape, String e, DtFecha fn, byte[] fo, String nomCanal,
//		String desc, Boolean privacidadE, String catE)
		fecha = asignarFecha("25,02,1962 00:00");
		fechaNac = new DtFecha(fecha);
		String HR="hrubio";
		ICU.nuevoUsuario(HR, "Horacio", "Rubino", "horacio.rubino@guambia.com.uy", fechaNac, null,
				"Canal Horacio", "El canal Horacio es para publicar contenido divertido",true, "Entretenimiento");
		
		fecha = asignarFecha("14,06,1972 00:00");
		fechaNac = new DtFecha(fecha);
		String MB ="mbusca";
		ICU.nuevoUsuario(MB, "Martin", "Buscaglia", "Martin.bus@agadu.org.uy", fechaNac, null,
				"El bocha", "Mi canal para colgar cosas", true, null);
		
		fecha = asignarFecha("07,01,1954 00:00");
		fechaNac = new DtFecha(fecha);
		String HG="hectorg";
		ICU.nuevoUsuario(HG, "Hector", "Guido", "hector.gui@elgalpon.org.uy", fechaNac, null,
				HG, "Canal HG", true, null);
		
		fecha=asignarFecha("24,07,1971 00:00");
		fechaNac = new DtFecha(fecha);
		String TC ="tabarec";
		ICU.nuevoUsuario(TC, "Tabare", "Cardozo", "tabare.car@agadu.otg.uy", fechaNac, null,
				"Tabare", "Mi musica e ainda mais", true, MUS);
		
		fecha = asignarFecha("01,01,1947 00:00");
		fechaNac = new DtFecha(fecha);
		String CS="cachilas";
		ICU.nuevoUsuario(CS, "Walder 'Cachila'", "Silva", "Cachila.sil@c1080.org.uy", fechaNac, null,
				"El Cachila", "Para juntar cosas", false, null);
		
		fecha =asignarFecha("16,03,1927 00:00");
		fechaNac = new DtFecha(fecha);
		String JB="juliob";
		ICU.nuevoUsuario(JB, "Julio", "Bocca", "juliobocca@sodre.com.uy", fechaNac, null,
				JB, "Canal de JB", true,null);
		
		fecha=asignarFecha("01,01,1975 00:00");
		fechaNac = new DtFecha(fecha);
		String DP="diegop";
		ICU.nuevoUsuario(DP, "Diego", "Parodi", "diego@efectocine", fechaNac, null,
				DP, "El Canal de DP", true , null);
	
		fecha=asignarFecha("25,04,1840 00:00");
		fechaNac = new DtFecha(fecha);
		String KH="kahiroh";
		ICU.nuevoUsuario(KH, "Kairo", "Herrera", "kairoher@pilsenrock.com.uy", fechaNac, null,
				"Kairo Musica", "Videos de grandes canciones de hoy y siempre", true, MUS);
		
		fecha=asignarFecha("03,08,1940 00:00");
		fechaNac = new DtFecha(fecha);
		String RH="robinh";
		ICU.nuevoUsuario(RH, "Robin", "Henderson", "robin.h@tinglesa.com.uy", fechaNac, null,
				RH, "Henderson", true, null);
		
		fecha=asignarFecha("01,04,1960 00:00");
		fechaNac = new DtFecha(fecha);
		String MT="marcelot";
		ICU.nuevoUsuario(MT, "Marcelo", "Tinelli", "marcelot@ideasdelsur.com.ar", fechaNac, null,
				"Tinelli total", "Todo lo que querias y mas!", true , ENT);
		
		fecha=asignarFecha("17,07,1952 00:00");
		fechaNac = new DtFecha(fecha);
		String EN="novick";
		ICU.nuevoUsuario(EN, "Edgardo", "Novick", "edgardo@novick.com.uy", fechaNac, null,
				"Con la gente", "Preparando las elecciones", true, null);
		
		fecha=asignarFecha("28,01,1950 00:00");
		fechaNac = new DtFecha(fecha);
		String SP="sergiop";
		ICU.nuevoUsuario(SP, "Sergio", "Puglia", "puglia@alpanpan.com.uy", fechaNac, null,
				"Sergio invita", "Programas del ciclo y videos de cocina mastercheef", true, COM);
		
		fecha=asignarFecha("17,03,1976 00:00");
		fechaNac = new DtFecha(fecha);
		String AR="chino";
		ICU.nuevoUsuario(AR, "Alvaro", "Recoba", "chino@trico.org.uy", fechaNac, null,
				"Chino Recoba", "Canal de goles con Nacional", false, DEP);
		
		fecha=asignarFecha("14,02,1955 00:00");
		fechaNac = new DtFecha(fecha);
		String AP="tonyp";
		ICU.nuevoUsuario(AP, "Antonio", "Pacheco", "eltony@manya.org.uy", fechaNac, null,
				"Tony Pacheco", "Todos los goles con Peñarol", false, DEP);
		
		fecha=asignarFecha("09,08,1960 00:00");
		fechaNac = new DtFecha(fecha);
		String NJ="nicoJ";
		ICU.nuevoUsuario(NJ, "Nicolas", "Jodal", "jodal@artech.com.uy", fechaNac, null,
				"Desde Genexus", "Canal informacion C y T", false, CYT);
		
		
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
		
		//COMENTARIOS
		int comentarioPadre;
		//video V7
		VideoHandler vh=VideoHandler.getInstance();
		DtVideo dtVideo =vh.member(V7,HG); //propietario del video HG	
		
		fecha=asignarFecha("5,12,2017 14:35"); DtFecha fechaVideo = new DtFecha(fecha); 
		ICV.nuevoComentario(dtVideo.getIDVideo(),NJ, fechaVideo,"Fue un gran evento" );
			
		comentarioPadre=obtenerIdComentario(dtVideo.getIDVideo(),NJ, fechaVideo);
		fecha = asignarFecha("8,12,2017 01:47");fechaVideo = new DtFecha(fecha); 
		ICV.responderComentario(dtVideo.getIDVideo(),comentarioPadre, HR, fechaVideo, "Para el proximo aniversario ofrezco vamo con Los Momo");
		
		comentarioPadre=obtenerIdComentario(dtVideo.getIDVideo(),HR, fechaVideo);
		fecha = asignarFecha("10,12,2017 17:09");fechaVideo = new DtFecha(fecha); 
		ICV.responderComentario(dtVideo.getIDVideo(),comentarioPadre, HR, fechaVideo, "Yo ofrezco a la banda tb");
		
		//otros videos
		dtVideo =vh.member(V6,HG);
		fecha=asignarFecha("07,09,2017 04:56");fechaVideo = new DtFecha(fecha); 
		ICV.nuevoComentario(dtVideo.getIDVideo(), NJ, fechaVideo, "Felicitaciones FING");
		
		dtVideo =vh.member(V8,HG);
		fecha=asignarFecha("23,10,2017 12:58");fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getIDVideo(),KH , fechaVideo, "Un gusto cubrir eventos como este.");
		
		dtVideo =vh.member(V13,JB);
		fecha=asignarFecha("14,11,2016 05:34");fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getIDVideo(),KH,fechaVideo,"Peñarol peñarol!!!");
		
		dtVideo =vh.member(V3,KH);
		fecha=asignarFecha("30,10,2017 02:17");fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getIDVideo(),MT,fechaVideo,"Rock and Rollll");
		dtVideo =vh.member(V3,JB);
		fecha=asignarFecha("30,10,2017 02:17");fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getIDVideo(),MT,fechaVideo,"Rock and Rollll");
		
		dtVideo =vh.member(V4,KH);
		fecha=asignarFecha("25,08,2018 18:00");fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getIDVideo(),MT,fechaVideo,"Anoche explotó!!!");
		
		dtVideo =vh.member(V1,CS);
		fecha=asignarFecha("11,09,2017 03:45");fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getIDVideo(),MT,fechaVideo,"Me encanta este tema");
		comentarioPadre=obtenerIdComentario(dtVideo.getIDVideo(),MT, fechaVideo);
		fecha = asignarFecha("15,09,2017 12:29");fechaVideo = new DtFecha(fecha); 
		ICV.responderComentario(dtVideo.getIDVideo(),comentarioPadre,TC,fechaVideo, "Gracias Marce ;)");
		
		dtVideo =vh.member(V1,TC);
		fecha=asignarFecha("11,09,2017 03:45");fechaVideo = new DtFecha(fecha);
		ICV.nuevoComentario(dtVideo.getIDVideo(),MT,fechaVideo,"Me encanta este tema");
		comentarioPadre=obtenerIdComentario(dtVideo.getIDVideo(),MT, fechaVideo);
		fecha = asignarFecha("15,09,2017 12:29");fechaVideo = new DtFecha(fecha); 
		ICV.responderComentario(dtVideo.getIDVideo(),comentarioPadre,TC,fechaVideo, "Gracias Marce ;)");
		
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
		int i=0;
		Boolean encontro=false;
		while(i<coments.length && !encontro){
			if(coments[i].getFecha()==fechaComen && coments[i].getNickUsuario()==nick){
				encontro=true;
			}
			i++;
		}
		return coments[i-1].getIDComentario();
	}
}
