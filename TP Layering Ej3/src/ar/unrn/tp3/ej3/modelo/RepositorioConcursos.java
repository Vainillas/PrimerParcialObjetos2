package ar.unrn.tp3.ej3.modelo;

import java.io.IOException;
import java.util.List;

public interface RepositorioConcursos {
	public List<Concurso> concursos() throws IOException;

	public boolean inscribirConcursante(Concursante concursante, Concurso concurso) throws IOException;
}
