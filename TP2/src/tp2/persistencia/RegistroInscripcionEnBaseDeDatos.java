package tp2.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tp2.exception.AppException;
import tp2p1.modelo.RegistroDeInscripcion;

public class RegistroInscripcionEnBaseDeDatos implements RegistroDeInscripcion {
	private Connection conn;

	public void registrar(String registro) {
		try {
			conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn
					.prepareStatement("INSERT INTO registro_inscripciones(data) " + "VALUES (?)");
			statement.setString(1, registro);
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new AppException("No se puedo conectar a la base de datos");
		} finally {
			ConnectionManager.disconnect();
		}
	}

}
