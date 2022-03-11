
public class TiempoAnemico {
	private int dia;
	private int mes;
	private int a�o;

	// La clase tiempo es solo un contenedor que recibe y entrega variables. No
	// tiene l�gica interna.
	public TiempoAnemico(int dia, int mes, int a�o) {
		this.dia = dia;
		this.mes = mes;
		this.a�o = a�o;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}

}
