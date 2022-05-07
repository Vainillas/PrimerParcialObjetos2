package ar.unrn.parcial.test;

import java.io.IOException;

import javax.mail.MessagingException;

import ar.unrn.parcial.modelo.Compra;
import ar.unrn.parcial.modelo.RegistroDeCompras;

public class StubObjectRegistro implements RegistroDeCompras {

	public boolean registrarCompra(Compra compra) throws IOException, MessagingException {
		return true;
	}

	public boolean informarCompra(Compra compra) throws MessagingException {
		return true;
	}

}
