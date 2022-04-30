package ar.unrn.tp3.ej3.main;

import javax.swing.SwingUtilities;

import ar.unrn.tp3.ej3.accesos.ArchivoConcursos;
import ar.unrn.tp3.ej3.modelo.RepositorioConcursos;

public class Main {
	public static void main(String[] args) {
		RepositorioConcursos repo = new ArchivoConcursos("C:\\Mateo\\Universidad\\OO2\\concursosLayering.txt",
				"C:\\Mateo\\Universidad\\OO2\\inscriptosLayering.txt");
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
