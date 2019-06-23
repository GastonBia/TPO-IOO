package TPO;

public class Cochera {

	int numero;
	boolean suv,auto,estado;
	//Estado==true cochera libre
	public Cochera (int numero, boolean suv, boolean auto) {
		this.numero = numero;
		this.suv = suv;
		this.auto = auto;
		this.estado = true;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isSuv() {
		return suv;
	}

	public void setSuv(boolean suv) {
		this.suv = suv;
	}

	public boolean isAuto() {
		return auto;
	}

	public void setAuto(boolean auto) {
		this.auto = auto;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
