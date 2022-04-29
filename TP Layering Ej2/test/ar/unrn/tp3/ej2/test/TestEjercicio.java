package ar.unrn.tp3.ej2.test;

import java.io.IOException;

import org.junit.Test;

public class TestEjercicio {
	private ProveedorFechaTest proveedorFecha = new ProveedorFechaTest();
	private ManagerCorreoTest managerCorreo = new ManagerCorreoTest(proveedorFecha);
	private LectorArchivoTest lector = new LectorArchivoTest();

	@Test
	public void testCumpleañosEmpleados() throws IOException {

	}

}
