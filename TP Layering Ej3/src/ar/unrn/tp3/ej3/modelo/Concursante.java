package ar.unrn.tp3.ej3.modelo;

public class Concursante {
	private String nombre;
	private String apellido;
	private String dni;
	private Telefono telefono;
	private Email correo;

	public Concursante(String nombre, String apellido, String dni, Telefono telefono, Email correo) {
		validarConstructor(nombre, apellido, dni);
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.correo = correo;
	}

	private boolean validarConstructor(String nombre, String apellido, String dni) {
		if (nombre.equals(""))
			throw new RuntimeException("Nombre no puede ser vacío");
		if (apellido.equals(""))
			throw new RuntimeException("Apellido no puede ser vacío");
		if (dni.equals(""))
			throw new RuntimeException("DNI no puede ser vacío");
		return true;
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

	public Telefono telefono() {
		return telefono;
	}

	public Email correo() {
		return correo;
	}

}
