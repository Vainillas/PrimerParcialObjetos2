package ar.unrn.tp3.modelo;

public class Telefono {
	private String numeroTelefono;

	public Telefono(String numeroTelefono) {
		validarConstructorTelefono(numeroTelefono);
		this.numeroTelefono = numeroTelefono;
	}

	private boolean validarConstructorTelefono(String numeroTelefono) {
		if (numeroTelefono.equals(""))
			throw new RuntimeException("El número de teléfono no puede ser vacío");
		if (!validarTelefono(numeroTelefono))
			throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		return true;
	}

	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}

	public String telefono() {
		return numeroTelefono;
	}

}
