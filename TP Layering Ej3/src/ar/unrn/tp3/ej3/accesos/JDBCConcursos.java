package ar.unrn.tp3.ej3.accesos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import ar.unrn.tp3.ej3.modelo.Concursante;
import ar.unrn.tp3.ej3.modelo.Concurso;
import ar.unrn.tp3.ej3.modelo.RepositorioConcursos;

public class JDBCConcursos implements RepositorioConcursos {
	private Connection dbConn;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	public JDBCConcursos() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/objetos2_tp1";
		String user = "root";
		String password = "";
		this.dbConn = DriverManager.getConnection(url, user, password);
	}

	public List<Concurso> concursos() {
		List<Concurso> listaConcursos = new ArrayList<Concurso>();
		Concurso concurso = null;
		try {
			PreparedStatement st = dbConn.prepareStatement("SELECT * FROM concursos");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				concurso = new Concurso(rs.getInt("id"), rs.getString("nombre"),
						LocalDate.parse(rs.getString("fecha_inicio"), formatter),
						LocalDate.parse(rs.getString("fecha_fin"), formatter));
				listaConcursos.add(concurso);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return listaConcursos;
	}

	@Override
	public boolean inscribirConcursante(Concursante concursante, Concurso concurso) {
		try {
			PreparedStatement st = dbConn.prepareStatement(
					"insert into inscriptos(nombre, apellido, dni, telefono, email, id_concurso) values(?,?,?,?,?,?)");
			st.setString(1, concursante.nombre());
			st.setString(2, concursante.apellido());
			st.setString(3, concursante.dni());
			st.setString(4, concursante.telefono().telefono());
			st.setString(5, concursante.correo().correo());
			st.setInt(6, concurso.id());
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());

		}
		return true;
	}
}
