package punto1.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import punto1.exception.AppException;

public class Concurso {
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Participante> getListaParticipantes() {
		return listaParticipantes;
	}

	public void setListaParticipantes(ArrayList<Participante> listaParticipantes) {
		this.listaParticipantes = listaParticipantes;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public static int getPuntosextra() {
		return puntosExtra;
	}

}
