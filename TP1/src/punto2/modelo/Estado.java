package punto2.modelo;

public class Estado {
	private String estado;
	private static final String PENDIENTE = "PENDIENTE";
	private static final String CONFIRMADO = "CONFIRMADO";

	public Estado() {
		this.estado = PENDIENTE;
	}

	public void confirmar() {
		if (estado.equals(PENDIENTE))
			this.estado = CONFIRMADO;
	}

	public boolean confirmado() {
		return estado.equals(CONFIRMADO);
	}

	public boolean pendiente() {
		return estado.equals(PENDIENTE);
	}

	public String toString() {
		return estado;
	}

}
