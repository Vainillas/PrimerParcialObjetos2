package ar.unrn.tp3.ej2.main;

import java.io.IOException;
import java.util.List;

import ar.unrn.tp3.ej2.accesos.Lector;
import ar.unrn.tp3.ej2.correo.EmailManager;
import ar.unrn.tp3.ej2.modelo.Empleado;
import ar.unrn.tp3.ej2.modelo.ProveedorFechas;

public class Main {

	public static void main(String[] args) {
		ProveedorFechas proveedorFecha = new ProveedorFechas();
		EmailManager managerCorreo = new EmailManager(proveedorFecha);
		// Lector lector = new Lector(managerCorreo);
		Lector lector = new Lector();
		try {
			List<Empleado> empleados = lector
					.empleadosCumpleaños("C:\\Mateo\\Universidad\\OO2\\archivoLayeringEj2.txt");
			managerCorreo.enviarCorreoCumpleaños(empleados);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
