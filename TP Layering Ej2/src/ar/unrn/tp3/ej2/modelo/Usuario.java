package ar.unrn.tp3.ej2.modelo;

public class Usuario {
	private String usuario;
	private String contraseña;

	public Usuario(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	public String usuario() {
		return usuario;
	}

	public String contraseña() {
		return contraseña;
	}

}
