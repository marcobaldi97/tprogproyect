package uytube.logica;

import java.util.Date;

public class DtFecha {	
	private Date fecha;
	
	public DtFecha(Date f){
		fecha = f;
	}
	public Date getFechaNac(){
		return fecha;
	}
	
	public Date pasarDTaDate(){
		Date fecha = new Date();
		return fecha;
	}
		
}
