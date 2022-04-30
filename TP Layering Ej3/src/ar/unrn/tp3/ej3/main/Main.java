package ar.unrn.tp3.ej3.main;

import java.sql.SQLException;

import javax.swing.SwingUtilities;

import ar.unrn.tp3.ej3.accesos.JDBCConcursos;
import ar.unrn.tp3.ej3.modelo.RepositorioConcursos;
import ar.unrn.tp3.ej3.ui.RadioCompetition;

public class Main {
	public static void main(String[] args) throws SQLException {
		RepositorioConcursos repo = new JDBCConcursos();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new Main().start(repo);
				} catch (Exception e) {
// log exception...
					System.out.println(e);
				}
			}
		});
	}

	private void start(RepositorioConcursos repo) {
		new RadioCompetition(repo);
	}
}
