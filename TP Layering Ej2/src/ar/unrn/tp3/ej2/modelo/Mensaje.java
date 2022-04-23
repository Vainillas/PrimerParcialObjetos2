package ar.unrn.tp3.ej2.modelo;

public class Mensaje {

	private String asunto;
	private String cuerpo;

	public Mensaje(String asunto, String cuerpo) {
		this.asunto = asunto;
		this.cuerpo = cuerpo;
	}

	public String asunto() {
		return asunto;
	}

	public String cuerpo() {
		return cuerpo;
	}

}
