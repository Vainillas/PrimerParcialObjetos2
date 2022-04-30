package ar.unrn.tp3.ej3.accesos;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import ar.unrn.tp3.ej3.modelo.Concursante;
import ar.unrn.tp3.ej3.modelo.Concurso;
import ar.unrn.tp3.ej3.modelo.RepositorioConcursos;

public class ArchivoConcursos implements RepositorioConcursos {
	private String pathConcursos;
	private String pathInscriptos;

	public ArchivoConcursos(String pathConcursos, String pathInscriptos) {
		this.pathConcursos = pathConcursos;
		this.pathInscriptos = pathInscriptos;
	}

	public List<Concurso> concursos() throws IOException {
		List<String> fileData = Files.readAllLines(Paths.get(pathConcursos));
		fileData.remove(0);
		ArrayList<Concurso> listaConcursos = new ArrayList<>();

		for (String s : fileData) {
			String[] camposFila = s.split(",");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			listaConcursos.add(new Concurso(Integer.parseInt(camposFila[0]), camposFila[1],
					LocalDate.parse(camposFila[2], formatter), LocalDate.parse(camposFila[3], formatter)));
		}
		return listaConcursos;

	}

	public boolean inscribirConcursante(Concursante concursante, Concurso concurso) throws IOException {
		FileWriter escritorArchivo = new FileWriter(pathInscriptos);
		escritorArchivo.write(concursante.apellido() + "," + concursante.nombre() + ","
				+ concursante.telefono().telefono() + "," + concursante.correo().correo() + "," + concurso.id());
		escritorArchivo.close();
		return true;
	}

}
