package ar.unrn.tp3.ej2.test;

import ar.unrn.tp3.ej2.modelo.EmisorDeCorreo;
import ar.unrn.tp3.ej2.modelo.ProveedorDeFecha;

public class ManagerCorreoTest implements EmisorDeCorreo {
	private ProveedorDeFecha proveedor;
	private StringBuffer correos;

	public ManagerCorreoTest(ProveedorDeFecha proveedor) {
		this.proveedor = proveedor;
		correos = new StringBuffer();
	}

	public boolean enviarCorreoCumpleaños(String correoEmpleado) {
		correos.append(correoEmpleado);
		return true;
	}

	public StringBuffer correos() {
		return correos;
	}

}
