package ar.unrn.tp3.ej2.modelo;

import java.io.IOException;
import java.util.List;

public interface LectorArchivo {
	public List<Empleado> empleadosCumpleaños(String filename) throws IOException;
}
