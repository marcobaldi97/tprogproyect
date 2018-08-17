package uytube.logica;

import java.util.Date;

public class DtFecha {
	private int dia;
	private int mes;
	private int anio;	
	private Date fecha;
	
	public DtFecha(int d,int m,int a) {
		dia = d;
		mes = m;
		anio = a;
	}
	public DtFecha(Date f){
		fecha = f;
	}
	
	public int getDia() {
		return dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public int getAnio() {
		return anio;
	}
	public Date getFechaNac(){
		return fecha;
	}
	
	public Date pasarDTaDate(){
		Date fecha = new Date();
		fecha.setDate(dia);
		fecha.setMonth(mes);
		fecha.setYear(anio);
		return fecha;
	}
		
}
