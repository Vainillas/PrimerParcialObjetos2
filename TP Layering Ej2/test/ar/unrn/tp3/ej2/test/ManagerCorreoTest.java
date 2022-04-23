package ar.unrn.tp3.ej2.test;

import java.util.List;

import ar.unrn.tp3.ej2.modelo.EmisorDeCorreo;
import ar.unrn.tp3.ej2.modelo.Empleado;
import ar.unrn.tp3.ej2.modelo.ProveedorDeFecha;

public class ManagerCorreoTest implements EmisorDeCorreo {
	private ProveedorDeFecha proveedor;

	public ManagerCorreoTest(ProveedorDeFecha proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public boolean enviarCorreoCumpleaños(List<Empleado> listaEmpleados) {
		for (Empleado e : listaEmpleados) {
			System.out.println(e.fecha());
			System.out.println(proveedor.generarFecha());
			if (e.evaluarCumpleaños(proveedor.generarFecha())) {
				return true;
			}

		}
		return false;
	}

}
