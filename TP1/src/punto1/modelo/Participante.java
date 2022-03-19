package punto1.modelo;

public class Participante {
	private String nombre;
	private String apellido;
	private String dni;
	private int puntaje; // Eliminados los setters de participante
							// Renombrados los getters

	public Participante(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		puntaje = 0;
	}

	public void sumarPuntaje(int puntosextra) {
		this.puntaje = puntaje + puntosextra;
	}

	public String nombre() {
		return nombre;
	}

	public String apellido() {
		return apellido;
	}

	public String dni() {
		return dni;
	}

	public int puntaje() {
		return puntaje;
	}

	@Override
	public String toString() {
		return "\nParticipante [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", puntaje=" + puntaje
				+ "]";
	}

}
