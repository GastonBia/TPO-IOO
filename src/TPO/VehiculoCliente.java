package TPO;

public class VehiculoCliente extends Vehiculo{

	String marca,modelo;
	int nroCochera;
	
	public VehiculoCliente ( String patente,TipoVechiculo tipo , String marca, String modelo, int nroCochera ) {
		super (patente,tipo);
		this.marca = marca;
		this.modelo = modelo;
		this.nroCochera = nroCochera;
	}
}
