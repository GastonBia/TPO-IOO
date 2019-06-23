package TPO;

// ImporteEventual = Valor hora * cantidad de horas * tipo vehiculo
// Si es moto *0.8, si es auto *1, si es SUV *1.2

public class Tarifa {

	float precioHora,precioCliente;
	
	public Tarifa (float precioHora, float precioCliente ){
		this.precioHora = precioHora;
		this.precioCliente = precioCliente;
	}
}
