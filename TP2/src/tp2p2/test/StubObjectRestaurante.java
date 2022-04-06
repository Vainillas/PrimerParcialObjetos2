package tp2p2.test;

import tp2p2.modelo.RegistroDePago;

public class StubObjectRestaurante implements RegistroDePago {
	private String registro;

	public StubObjectRestaurante() {
	}

	public void registrar(String registro) {
		this.registro = registro;
	}

	public String registro() {
		return this.registro;
	}

}
