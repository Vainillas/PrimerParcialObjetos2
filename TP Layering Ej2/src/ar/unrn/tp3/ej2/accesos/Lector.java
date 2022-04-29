package ar.unrn.tp3.ej2.accesos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import ar.unrn.tp3.ej2.modelo.Empleado;
import ar.unrn.tp3.ej2.modelo.Empleados;

public class Lector implements Empleados {
	private String pathArchivo;

	public Lector(String filename) {
		this.pathArchivo = filename;
	}

	public List<Empleado> leer() throws IOException {

		List<String> fileData = Files.readAllLines(Paths.get(pathArchivo));
		fileData.remove(0);
		ArrayList<Empleado> listaEmpleados = new ArrayList<>();

		for (String s : fileData) {
			String[] camposFila = s.split(",");
			listaEmpleados.add(new Empleado(camposFila[0], camposFila[1], camposFila[2], camposFila[3]));
		}
		return listaEmpleados;

	}

}
