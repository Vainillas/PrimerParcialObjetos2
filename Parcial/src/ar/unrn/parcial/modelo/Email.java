package ar.unrn.parcial.modelo;

public class Email {
	private String correoElectronico;

	public Email(String correoElectronico) {
		validarConstructor(correoElectronico);
		this.correoElectronico = correoElectronico;
	}

	private boolean validarConstructor(String email) {
		if (!validarCorreo(email))
			throw new RuntimeException("El email debe ser v�lido");
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
