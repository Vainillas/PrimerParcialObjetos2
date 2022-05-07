package ar.unrn.parcial.modelo;

import javax.mail.MessagingException;

public interface EmisorEmail {
	public boolean enviarCorreoConfirmacionCompra(String cantidad, String fecha, String monto, String correoDestino)
			throws MessagingException;
}
