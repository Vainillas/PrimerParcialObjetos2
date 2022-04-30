package ar.unrn.tp3.ej3.modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Concurso {
	private int id;
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;

	public Concurso(int id, String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
		validarFechas(fechaInicio, fechaFin);
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	private boolean validarFechas(LocalDate fechaInicio, LocalDate fechaFin) {
		if (fechaInicio.isAfter(fechaFin) || fechaInicio.equals(fechaFin))
			throw new RuntimeException(
					"La fecha de inicio de inscripción no puede ser posterior o igual a la fecha de fin de inscripción");
		return true;
	}

	public void sumateSi(List<Concurso> lista, Predicate<Concurso> p) {
		if (p.test(this)) {
			lista.add(this);
		}

	}

	public boolean estaAbierto() {
		boolean var = false;
		if (LocalDate.now().isBefore(fechaFin)
				&& (LocalDate.now().equals(fechaInicio) || LocalDate.now().isAfter(fechaInicio)))
			var = true;
		return var;
	}

	public int id() {
		return id;
	}

	public String nombre() {
		return nombre;
	}

	public LocalDate inicio() {
		return fechaInicio;
	}

	public LocalDate fin() {
		return fechaFin;
	}
}
