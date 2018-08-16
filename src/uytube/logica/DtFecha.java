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
	public DtFecha(Date fecha){
		DtFecha fechaDt = new DtFecha(fecha.getDay(), fecha.getMonth(), fecha.getYear());
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
	
	public Date pasarDTaDate(){
		Date fecha = new Date();
		fecha.setDate(dia);
		fecha.setMonth(mes);
		fecha.setYear(anio);
		return fecha;
	}
		
}
