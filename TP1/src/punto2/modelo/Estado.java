package punto2.modelo;

import punto2.exception.StateException;

public class Estado {
	private String estado;
	private static final String PENDIENTE = "PENDIENTE";
	private static final String CONFIRMADO = "CONFIRMADO";

	public Estado() {
		this.estado = PENDIENTE;
	}

	public void confirmar() throws StateException {
		if (estado.equals(PENDIENTE)) {
			this.estado = CONFIRMADO;
		} else {
			throw new StateException("El estado del pedido no puede modificarse una vez confirmado");
		}
	}

	public boolean confirmado() {
		return estado.equals(CONFIRMADO);
	}

	public boolean pendiente() {
		return estado.equals(PENDIENTE);
	}

}
