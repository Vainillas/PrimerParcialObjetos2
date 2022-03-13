package punto1.modelo;

public class Participante {
	private String nombre;
	private String apellido;
	private String dni;
	private int puntaje; // ¿El puntaje del participante depende del concurso?

	public Participante(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		puntaje = 0;
	}

	public void sumarPuntaje(int puntosextra) {
		this.puntaje = puntaje + puntosextra;
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

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

}
