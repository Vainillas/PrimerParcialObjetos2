package ar.unrn.tp3.modelo;

import java.sql.SQLException;

public interface RepositorioDeParticipantes {
	public boolean nuevoParticipante(Participante p) throws SQLException;
}
