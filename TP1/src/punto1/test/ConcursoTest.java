package punto1.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import punto1.exception.AppException;
import punto1.modelo.Concurso;
import punto1.modelo.Participante;

public class ConcursoTest {
	@Test
	public void simpleAdd() {
		// Ini
		LocalDate fechaIni = LocalDate.of(2022, 3, 13);
		LocalDate fechaFin = LocalDate.of(2022, 3, 23);
		LocalDate fechaExcedida = LocalDate.of(2022, 3, 24);
		LocalDate fechaInscripcion = LocalDate.of(2022, 3, 17);
		Concurso c = new Concurso("Concurso de dibujo", fechaIni, fechaFin);
		Participante p1 = new Participante("Mateo", "Aliberti", "43.303.613");
		Participante p2 = new Participante("Cosme", "Fulanito", "52.657.154");
		Participante p3 = new Participante("Carlos", "Perez", "37.546.987");
		// Ejercitaci�n
		try {
			c.inscribirParticipante(p3, fechaInscripcion);
			c.inscribirParticipante(p2);
			c.inscribirParticipante(p1, fechaExcedida);
		} catch (AppException e) {
			System.out.println(e.getMessage());
		}
		// Verificacion
		System.out.println(c.getListaParticipantes().toString());
	}

}