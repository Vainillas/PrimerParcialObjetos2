package ar.unrn.tp3.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.RepositorioDeParticipantes;

public class JDBCParticipante implements RepositorioDeParticipantes {
	private Connection dbConn;

	public void setupBaseDeDatos() throws SQLException {
		String url = "jdbc:derby://localhost:1527/participantes";
		String user = "app";
		String password = "app";
		this.dbConn = DriverManager.getConnection(url, user, password);
	}

	@Override
	public boolean nuevoParticipante(Participante p) throws SQLException {
		PreparedStatement st = dbConn
				.prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)");
		try {
			st.setString(1, p.nombre());
			st.setString(2, p.telefono());
			st.setString(3, p.region());
			st.executeUpdate();
		} finally {
			st.close();
		}
		return true;
	}

}
