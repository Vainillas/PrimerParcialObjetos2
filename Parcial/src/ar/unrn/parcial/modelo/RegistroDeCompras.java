package ar.unrn.parcial.modelo;

import java.io.IOException;

import javax.mail.MessagingException;

public interface RegistroDeCompras {

	public boolean registrarCompra(Compra compra) throws IOException, MessagingException;

	public boolean informarCompra(Compra compra) throws MessagingException;
}
