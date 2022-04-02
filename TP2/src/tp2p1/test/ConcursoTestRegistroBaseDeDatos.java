package tp2p1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import tp2.exception.AppException;
import tp2.persistencia.RegistroInscripcionEnBaseDeDatos;
import tp2p1.modelo.Concurso;
import tp2p1.modelo.Participante;
import tp2p1.modelo.RegistroDeInscripcion;

public class ConcursoTestRegistroBaseDeDatos { // Creado un metodo para su respectivo test
	LocalDate fechaIni = LocalDate.of(2022, 3, 13);
	LocalDate fechaFin = LocalDate.of(2022, 3, 23);
	RegistroDeInscripcion registro = new RegistroInscripcionEnBaseDeDatos();

	@Test
	public void inscripcionFechaInicial() {
		// Ini

		Concurso c = new Concurso("Concurso de dibujo", fechaIni, fechaFin, registro);
		Participante p1 = new Participante("Mateo", "Aliberti", "43.303.613");

		// Ejercitación
		try {
			c.inscribirParticipante(p1, fechaIni); // Fecha de inicio del concurso
		} catch (AppException e) {
			System.out.println(e.getMessage());
		}
		// Verificacion
		assertEquals(10, p1.puntaje());
		assertEquals(true, c.estaInscripto(p1));
	}

	@Test
	public void inscripcionFechaExcedida() {
		// Ini
		LocalDate fechaExcedida = LocalDate.of(2022, 3, 24);
		Concurso c = new Concurso("Concurso de dibujo", fechaIni, fechaFin, registro);
		Participante p1 = new Participante("Mateo", "Aliberti", "43.303.613");
		// Ejercitación
		try {
			c.inscribirParticipante(p1, fechaExcedida); // Fecha excedida
		} catch (AppException e) {
			System.out.println(e.getMessage());
		}
		// Verificacion
		assertEquals(0, p1.puntaje());
		assertEquals(false, c.estaInscripto(p1));
	}

	@Test
	public void inscripcionEnTermino() {

		// Ini
		LocalDate fechaInscripcion = LocalDate.of(2022, 3, 17);
		Concurso c = new Concurso("Concurso de dibujo", fechaIni, fechaFin, registro);
		Participante p1 = new Participante("Mateo", "Aliberti", "43.303.613");
		// Ejercitación
		c.inscribirParticipante(p1, fechaInscripcion); // Fecha entre el rango de inicio y de fin
		// Verificacion
		assertEquals(0, p1.puntaje());
		assertEquals(true, c.estaInscripto(p1));
	}

}
