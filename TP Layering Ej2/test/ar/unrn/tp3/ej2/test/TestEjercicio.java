package ar.unrn.tp3.ej2.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class TestEjercicio {
	private ProveedorFechaTest proveedorFecha = new ProveedorFechaTest();
	private ManagerCorreoTest managerCorreo = new ManagerCorreoTest(proveedorFecha);
	private LectorArchivoTest lector = new LectorArchivoTest();
	private final String pathname = "";

	@Test
	public void testCumpleañosEmpleados() throws IOException {
		var lista = lector.empleadosCumpleaños(pathname);
		Assert.assertEquals(true, managerCorreo.enviarCorreoCumpleaños(lista));

	}

}
