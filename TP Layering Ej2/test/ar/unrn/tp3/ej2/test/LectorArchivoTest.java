package ar.unrn.tp3.ej2.test;

import java.io.IOException;
import java.util.List;

import ar.unrn.tp3.ej2.modelo.Empleado;
import ar.unrn.tp3.ej2.modelo.Empleados;

public class LectorArchivoTest implements Empleados {

	public List<Empleado> leer() throws IOException {
		Empleado e1 = new Empleado("Aliberti", "Mateo", "2001-03-27", "mateoaliberti1@gmail.com");
		Empleado e2 = new Empleado("Santiago", "Farah", "2001-03-31", "eliasfarah166@gmail.com");
		Empleado e3 = new Empleado("Remo", "Roma", "2001-08-21", "remo@roma.com");
		Empleado e4 = new Empleado("Romulo", "Roma", "2001-05-03", "romulo@roma.com");
		Empleado e5 = new Empleado("Hades", "Plutón", "2001-03-27", "godofwar@gmail.com");
		Empleado e6 = new Empleado("Hermes", "Mercurio", "2001-03-27", "kishibehater@gmail.com");

		var list = List.of(e1, e2, e3, e4, e5, e6);

		return list;
	}

}
