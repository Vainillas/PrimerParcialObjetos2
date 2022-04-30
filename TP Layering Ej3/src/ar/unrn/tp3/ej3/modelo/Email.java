package ar.unrn.tp3.ej3.modelo;

public class Email {
	private String correoElectronico;

	public Email(String correoElectronico) {
		validarConstructor(correoElectronico);
		this.correoElectronico = correoElectronico;
	}

	private boolean validarConstructor(String email) {
		if (!validarCorreo(email))
			throw new RuntimeException("El email debe ser válido");
		return true;
	}

	private boolean validarCorreo(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	public String correo() {
		return correoElectronico;
	}

}
