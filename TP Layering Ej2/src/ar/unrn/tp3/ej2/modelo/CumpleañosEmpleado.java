package ar.unrn.tp3.ej2.modelo;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

public class Cumplea�osEmpleado {
	private Empleados empleados;
	private EmisorDeCorreo emisor;
	private ProveedorDeFecha proveedorFecha;

	public Cumplea�osEmpleado(Empleados empleados, EmisorDeCorreo emisor, ProveedorDeFecha proveedorFecha) {
		this.empleados = empleados;
		this.emisor = emisor;
		this.proveedorFecha = proveedorFecha;
	}

	public boolean enviarFelicitaciones() throws IOException {
		List<Empleado> listaEmpleados = empleados.leer();
		for (Empleado e : listaEmpleados) {
			if (e.evaluarCumplea�os(proveedorFecha.generarFecha())) {
				try {
					emisor.enviarCorreoCumplea�os(e.correoElectronico());
				} catch (MessagingException e1) {
					throw new RuntimeException(e1.getMessage());
				}
			}
		}
		return true;
	}

}
