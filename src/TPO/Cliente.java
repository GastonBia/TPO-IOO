package TPO;

import java.util.ArrayList;

public class Cliente {
	
	String nombre , apellido , dni;
	ArrayList<VehiculoCliente> arrayVehiculos;
	
	public Cliente (String nombre, String apellido, String dni){
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public ArrayList<VehiculoCliente> getArrayVehiculos() {
		return arrayVehiculos;
	}
	public void setArrayVehiculos(ArrayList<VehiculoCliente> arrayVehiculos) {
		this.arrayVehiculos = arrayVehiculos;
	}
}
