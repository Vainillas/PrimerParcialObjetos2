package ar.unrn.tp3.ej2.modelo;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

public class Cumplea�osEmpleado {
	private LectorArchivo lector;
	private EmisorDeCorreo emisor;
	private ProveedorDeFecha proveedorFecha;

	public Cumplea�osEmpleado(LectorArchivo lector, EmisorDeCorreo emisor, ProveedorDeFecha proveedorFecha) {
		this.lector = lector;
		this.emisor = emisor;
		this.proveedorFecha = proveedorFecha;
	}

	public void enviarFelicitaciones() throws IOException {
		List<Empleado> empleados = lector.leerArchivo();

		for (Empleado e : empleados) {
			if (e.evaluarCumplea�os(proveedorFecha.generarFecha())) {
				try {
					emisor.enviarCorreoCumplea�os(e.correoElectronico());
				} catch (MessagingException e1) {
					throw new RuntimeException(e1.getMessage());
				}
			}
		}
	}

}
