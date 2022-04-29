package ar.unrn.tp3.ej2.test;

import java.io.IOException;
import java.util.List;

import ar.unrn.tp3.ej2.modelo.Empleado;
import ar.unrn.tp3.ej2.modelo.LectorArchivo;

public class LectorArchivoTest implements LectorArchivo {

	public List<Empleado> leerArchivo() throws IOException {
		Empleado e1 = new Empleado("Aliberti", "Mateo", "2001-03-27", "mateoaliberti1@gmail.com");
		Empleado e2 = new Empleado("Santiago", "Farah", "2001-03-31", "eliasfarah166@gmail.com");

		var list = List.of(e1, e2);
		return list;
	}

}
