package ar.unrn.tp3.ej2.modelo;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

public class CumpleañosEmpleado {
	private LectorArchivo lector;
	private EmisorDeCorreo emisor;
	private ProveedorDeFecha proveedorFecha;

	public CumpleañosEmpleado(LectorArchivo lector, EmisorDeCorreo emisor, ProveedorDeFecha proveedorFecha) {
		this.lector = lector;
		this.emisor = emisor;
		this.proveedorFecha = proveedorFecha;
	}

	public void enviarFelicitaciones() throws IOException {
		List<Empleado> empleados = lector.leerArchivo();

		for (Empleado e : empleados) {
			if (e.evaluarCumpleaños(proveedorFecha.generarFecha())) {
				try {
					emisor.enviarCorreoCumpleaños(e.correoElectronico());
				} catch (MessagingException e1) {
					throw new RuntimeException(e1.getMessage());
				}
			}
		}
	}

}
