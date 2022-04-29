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
		String url = "jdbc:mysql://localhost:3306/objetos2_tp1";
		String user = "root";
		String password = "";
		this.dbConn = DriverManager.getConnection(url, user, password);
	}

	@Override
	public boolean nuevoParticipante(Participante p) throws SQLException {
		PreparedStatement st = dbConn
				.prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)");
		try {
			st.setString(1, p.nombre());
			st.setString(2, p.telefono().telefono()); // Como corregir los dos puntos
			st.setString(3, p.region().region());
			st.executeUpdate();
		} finally {
			st.close();
		}
		return true;
	}

}
