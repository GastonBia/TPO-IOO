package TPO;

import java.util.Date;

public class VehiculoEventual extends Vehiculo{
	
	int hi,mi,he,me; // hora ingreso, minuto ingreso , hora egreso, minuto egreso
	Date ingreso = new Date();
	int nroCochera;

	public VehiculoEventual (String patente,TipoVechiculo tipo, Date ingreso, int nroCochera) {	
		super (patente,tipo);
	}

	public float calcularFecha (){
		float horas=0, minutos=0;
		horas = this.he-this.hi;
		minutos= this.me - this.mi;
		
		if (minutos < 0){
			minutos = minutos *-1;
		}
		
		minutos = minutos / 100 ; 
		horas = horas + minutos;
		return horas;
	}
	
	public double calcularImporteEventual (Tarifa t){
		double r=0;
		if (this.tipo == this.tipo.Auto){
			r = t.precioHora * this.calcularFecha()* 2.0;
		}
		if (this.tipo == this.tipo.Moto){
			r = t.precioHora * this.calcularFecha()* 1.8;
		}
		if (this.tipo == this.tipo.Suv){
			r = t.precioHora * this.calcularFecha() * 1.2;
		}
		return r;
	}
}
