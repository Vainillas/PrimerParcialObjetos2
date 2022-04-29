package ar.unrn.tp3.ej2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import ar.unrn.tp3.ej2.modelo.CumpleañosEmpleado;

public class TestEjercicio {
	private ProveedorFechaTest proveedorFecha = new ProveedorFechaTest();
	private ManagerCorreoTest managerCorreo = new ManagerCorreoTest(proveedorFecha);
	private LectorArchivoTest lector = new LectorArchivoTest();

	@Test
	public void testCumpleañosMultiples() throws IOException {
		CumpleañosEmpleado ce = new CumpleañosEmpleado(lector, managerCorreo, proveedorFecha);
		ce.enviarFelicitaciones();
		StringBuffer test = managerCorreo.correos();
		assertEquals("mateoaliberti1@gmail.com" + "godofwar@gmail.com" + "kishibehater@gmail.com", test.toString());
	}

}
