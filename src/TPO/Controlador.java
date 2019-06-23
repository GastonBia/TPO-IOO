package TPO;

import java.util.ArrayList;
import java.util.Date;

public class Controlador {
	
	ArrayList<Cliente> arrayCliente;
	ArrayList<Cochera> arrayCocheras;
	ArrayList<VehiculoEventual> arrayVehiculosEventuales;
	Tarifa tarifa;
	
	public Controlador () {
		super ();
		// inicializo estructuras
		this.arrayCliente = new ArrayList<Cliente>();
		this.arrayCocheras = new ArrayList<Cochera>();
		this.arrayVehiculosEventuales = new ArrayList<VehiculoEventual>();
		
		tarifa = new Tarifa(150, 1500);
		inicializarCocheras(arrayCocheras);
		inicializarEventuales(arrayVehiculosEventuales);
	}
	
	// Llamo a la funcion calcular fecha dentro de vehiculo eventual que me devuelve 
	//la resta entre hora de salida y de entrada.
	
	public double cobroEventual (VehiculoEventual ve) {
		double r= 0;
		for ( VehiculoEventual a : arrayVehiculosEventuales) {
			if ( a.patente.equals (ve.patente)){
				r = ve.calcularImporteEventual(tarifa);
				break;
			}
			else
				return 0; // No lo encontro
		}
		return r;
	}
	
	public void crearCochera (int numero, boolean suv, boolean auto, boolean estado) {
		arrayCocheras.add(new Cochera(numero, suv, auto) );
	}
	
	public boolean existeCochera(int nroCochera) {
		for (int i = 0; i < arrayCocheras.size(); i++) {
			if (arrayCocheras.get(i).numero == nroCochera) {
				return true;
			}
		}
		return false;
	}
	
	public int buscarCochera(String tipo){
		int cochera=0;
		for (int i = 0; i < arrayCocheras.size(); i++) {
			if (tipo == "Moto") {
				if(arrayCocheras.get(i).estado == true) {
					arrayCocheras.get(i).setEstado(false);
					return cochera = arrayCocheras.get(i).getNumero();
				}
			} else {
				if (tipo == "Auto"){
					if(arrayCocheras.get(i).estado == true && arrayCocheras.get(i).auto == true) {
						arrayCocheras.get(i).setEstado(false);
						return cochera = arrayCocheras.get(i).getNumero();
					}
				} else {
					if(arrayCocheras.get(i).estado == true && arrayCocheras.get(i).suv == true) {
						arrayCocheras.get(i).setEstado(false);
						return cochera = arrayCocheras.get(i).getNumero();
					}
				}
			}
		}
		return cochera;
	}

	public void crearCliente (String nombre, String apellido, String dni) {
		arrayCliente.add(new Cliente (nombre, apellido, dni));
	}
	
	public boolean existeCliente(String dni) {
		for (int i = 0; i < arrayCliente.size(); i++) {
			if (arrayCliente.get(i).dni.equals(dni)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existeVehiculo(String dni, String patente) {
		ArrayList<VehiculoCliente> arrayVehiculosCliente;
		//HACER
		return false;
	}
	
	public void crearEventual(String patente, TipoVechiculo tipo, Date ingreso, int nroCochera){
		arrayVehiculosEventuales.add(new VehiculoEventual(patente, tipo, ingreso, nroCochera));
	}
	
	public boolean existeEventual(String patente) {
		for (int i = 0; i < arrayVehiculosEventuales.size(); i++) {
			if (arrayVehiculosEventuales.get(i).patente.equals(patente)) {
				return true;
			}
		}
		return false;
	}
	
	// Inicializacion de estructuras
	private void inicializarEventuales (ArrayList<VehiculoEventual> a){
		//VehiculoEventual ve = new VehiculoEventual("AB949KK", TipoVechiculo.Auto, ingreso);
	}
	private void inicializarCocheras(ArrayList<Cochera> arrayCocheras) {
//		arrayCocheras.add(new Cochera(1, true, true));
		arrayCocheras.add(new Cochera(2, false, true));
//		arrayCocheras.add(new Cochera(3, false, false));
//		arrayCocheras.add(new Cochera(4, true, true));
//		arrayCocheras.add(new Cochera(5, false, true));
//		arrayCocheras.add(new Cochera(6, false, false));
//		arrayCocheras.add(new Cochera(7, true, true));
//		arrayCocheras.add(new Cochera(8, false, true));
//		arrayCocheras.add(new Cochera(9, false, false));
//		arrayCocheras.add(new Cochera(10, true, true));
//		arrayCocheras.add(new Cochera(11, false, true));
//		arrayCocheras.add(new Cochera(12, false, false));
	}
}
