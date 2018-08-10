package uytube.logica;

public class Fecha {
	private int dia;
	private int mes;
	private int anio;
	
	public Fecha(int d,int m,int a) {
		dia = d;
		mes = m;
		anio = a;
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
	
}
