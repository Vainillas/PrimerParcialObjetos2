package ar.unrn.tp3.ej2.test;

import java.time.LocalDate;

import ar.unrn.tp3.ej2.modelo.ProveedorDeFecha;

public class ProveedorFechaTest implements ProveedorDeFecha {

	public LocalDate generarFecha() {
		return LocalDate.of(2001, 03, 27);
	}

}
