package ar.unrn.tp3.ej2.modelo;

import java.time.LocalDate;

public class ProveedorFechas implements ProveedorDeFecha {
	public LocalDate generarFecha() {
		return LocalDate.now();
	}

}
