package ar.unrn.tp3.main;

import java.awt.EventQueue;
import java.sql.SQLException;

import ar.unrn.tp3.bd.JDBCParticipante;
import ar.unrn.tp3.ui.UIParticipante;

public class Main {
	public static void main(String[] args) throws SQLException {
		JDBCParticipante jdbc = new JDBCParticipante();
		UIParticipante ui = new UIParticipante(jdbc);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ui.setupUIComponents();
					jdbc.setupBaseDeDatos();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
	}

}
