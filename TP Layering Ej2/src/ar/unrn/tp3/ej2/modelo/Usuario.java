package ar.unrn.tp3.ej2.modelo;

public class Usuario {
	private String usuario;
	private String contraseņa;

	public Usuario(String usuario, String contraseņa) {
		this.usuario = usuario;
		this.contraseņa = contraseņa;
	}

	public String usuario() {
		return usuario;
	}

	public String contraseņa() {
		return contraseņa;
	}

}
