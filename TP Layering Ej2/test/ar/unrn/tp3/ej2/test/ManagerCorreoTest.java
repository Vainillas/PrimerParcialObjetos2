package ar.unrn.tp3.ej2.test;

import ar.unrn.tp3.ej2.modelo.EmisorDeCorreo;
import ar.unrn.tp3.ej2.modelo.ProveedorDeFecha;

public class ManagerCorreoTest implements EmisorDeCorreo {
	private ProveedorDeFecha proveedor;

	public ManagerCorreoTest(ProveedorDeFecha proveedor) {
		this.proveedor = proveedor;
	}

	public boolean enviarCorreoCumpleaños(String correoEmpleado) {
		return true;
	}

}
