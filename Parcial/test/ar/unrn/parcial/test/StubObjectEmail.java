package ar.unrn.parcial.test;

import javax.mail.MessagingException;

import ar.unrn.parcial.modelo.EmisorEmail;

public class StubObjectEmail implements EmisorEmail {

	@Override
	public boolean enviarCorreoConfirmacionCompra(String cantidad, String fecha, String monto, String correoDestino)
			throws MessagingException {

		return true;
	}

}
