package TPO;

	public class Vehiculo {

	String patente;
	TipoVechiculo tipo;
	
	public Vehiculo (String patente,TipoVechiculo tipo){
	
		this.patente = patente;
		this.tipo = tipo;
	}
	
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public TipoVechiculo getTipo() {
		return tipo;
	}
	public void setTipo(TipoVechiculo tipo) {
		this.tipo = tipo;
	}
}
