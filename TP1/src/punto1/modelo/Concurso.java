package punto1.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import punto1.exception.AppException;

public class Concurso { // Eliminados los setters de concurso
						// Renombrados los getters
						// Eliminados los getters que no se usaban en el test
	public static final int puntosExtra = 10;
	private String nombre;
	private ArrayList<Participante> listaParticipantes;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;

	public Concurso(String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
		this.nombre = nombre;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.listaParticipantes = new ArrayList<>();

	}

	public Concurso(String nombre, ArrayList<Participante> listaParticipantes, LocalDate fechaInicio,
			LocalDate fechaFin) {
		this(nombre, fechaInicio, fechaFin);
		this.listaParticipantes = listaParticipantes;
	}

	public void inscribirParticipante(Participante participante) throws AppException {
		LocalDate fechaHoy = LocalDate.now();
		if (fechaHoy.isEqual(fechaInicio) || ((fechaHoy.isAfter(fechaInicio) && fechaHoy.isBefore(fechaFin)))) {
			listaParticipantes.add(participante);
		} else {
			throw new AppException("El participante no puede inscribirse fuera del rango de fecha de inscripción");
		}
		validarPuntajeExtra(participante, fechaHoy);
	}

	public void inscribirParticipante(Participante participante, LocalDate fechaInscripcion) throws AppException {
		if (!estaInscripto(participante)) {
			if (fechaInscripcion.isEqual(fechaInicio)
					|| ((fechaInscripcion.isAfter(fechaInicio) && fechaInscripcion.isBefore(fechaFin)))) {
				listaParticipantes.add(participante);
			} else {
				throw new AppException("El participante no puede inscribirse fuera del rango de fecha de inscripción");
			}
			validarPuntajeExtra(participante, fechaInscripcion);
		}
	}

	public boolean validarPuntajeExtra(Participante p, LocalDate f) {
		if (fechaInicio.equals(f)) {
			p.sumarPuntaje(puntosExtra);
			return true;
		} else
			return false;
	}

	public boolean estaInscripto(Participante p) {
		return listaParticipantes.contains(p);
	}

}
