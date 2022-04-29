package ar.unrn.tp3.ej2.modelo;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

public class CumpleañosEmpleado {
	private Empleados empleados;
	private EmisorDeCorreo emisor;
	private ProveedorDeFecha proveedorFecha;

	public CumpleañosEmpleado(Empleados empleados, EmisorDeCorreo emisor, ProveedorDeFecha proveedorFecha) {
		this.empleados = empleados;
		this.emisor = emisor;
		this.proveedorFecha = proveedorFecha;
	}

	public boolean enviarFelicitaciones() throws IOException {
		List<Empleado> listaEmpleados = empleados.leer();
		for (Empleado e : listaEmpleados) {
			if (e.evaluarCumpleaños(proveedorFecha.generarFecha())) {
				try {
					emisor.enviarCorreoCumpleaños(e.correoElectronico());
				} catch (MessagingException e1) {
					throw new RuntimeException(e1.getMessage());
				}
			}
		}
		return true;
	}

}
