package ar.unrn.tp3.ej2.modelo;

public class Usuario {
	private String usuario;
	private String contrase�a;

	public Usuario(String usuario, String contrase�a) {
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}

	public String usuario() {
		return usuario;
	}

	public String contrase�a() {
		return contrase�a;
	}

}
