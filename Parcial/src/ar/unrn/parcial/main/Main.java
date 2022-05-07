package ar.unrn.parcial.main;

import ar.unrn.parcial.gui.GUICompraRemeras;
import ar.unrn.parcial.modelo.Compras;
import ar.unrn.parcial.modelo.EmisorEmail;
import ar.unrn.parcial.modelo.InterfazCompras;
import ar.unrn.parcial.modelo.RegistroDeCompras;
import ar.unrn.parcial.persistencia.RegistroCompraConPipe;
import ar.unrn.parcial.servicios.EmailManager;
import ar.unrn.parcial.servicios.StubObjectFechas;

public class Main {

	public static void main(String[] args) {
		EmisorEmail emailSender = new EmailManager();
		RegistroDeCompras rcc = new RegistroCompraConPipe(emailSender);
		StubObjectFechas proveedor = new StubObjectFechas();
		InterfazCompras compras = new Compras();
		GUICompraRemeras gui = new GUICompraRemeras(rcc, proveedor, compras);

	}

}
