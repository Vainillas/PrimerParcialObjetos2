package ar.unrn.tp3.ej2.accesos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import ar.unrn.tp3.ej2.modelo.Empleado;
import ar.unrn.tp3.ej2.modelo.LectorArchivo;

public class Lector implements LectorArchivo {
	// private EmisorDeCorreo correo;
	/*
	 * public Lector(EmisorDeCorreo correo) { this.correo = correo; }
	 */

	public List<Empleado> empleadosCumpleaños(String filename) throws IOException {

		List<String> fileData = Files.readAllLines(Paths.get(filename));
		fileData.remove(0);
		ArrayList<Empleado> listaEmpleados = new ArrayList<>();

		for (String s : fileData) {
			String[] camposFila = s.split(",");
			listaEmpleados.add(new Empleado(camposFila[0], camposFila[1], camposFila[2], camposFila[3]));
		}
		// correo.enviarCorreoCumpleaños(listaEmpleados);
		return listaEmpleados;

	}

}
