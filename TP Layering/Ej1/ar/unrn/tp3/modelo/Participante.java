package ar.unrn.tp3.modelo;

public class Participante {
	private String nombre;
	private Telefono telefono;
	private Region region;

	public Participante(String nombre, Telefono telefono, Region region) {
		validarNombre(nombre);
		this.nombre = nombre;
		this.telefono = telefono;
		this.region = region;
	}

	private boolean validarNombre(String nombre) {
		if (nombre.equals(""))
			throw new RuntimeException("Debe cargar un nombre");
		return true;
	}

	public String nombre() {
		return nombre;
	}

	public Telefono telefono() {
		return telefono;
	}

	public Region region() {
		return region;
	}

}