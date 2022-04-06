package tp2p1.test;

import java.util.Objects;
import java.util.Optional;

import tp2p1.modelo.RegistroDeInscripcion;

public class StubObjectConcurso implements RegistroDeInscripcion {
	private String registro;

	public StubObjectConcurso() {
	}

	public void registrar(String registro) {
		this.registro = registro;
	}

	public Optional<String> registro() {
		if (Objects.nonNull(registro)) {
			return Optional.of(String.join(" ", registro));
		} else
			return Optional.empty();
	}

}
