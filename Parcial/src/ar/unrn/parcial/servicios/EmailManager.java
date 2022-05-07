package ar.unrn.parcial.servicios;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ar.unrn.parcial.modelo.EmisorEmail;

public class EmailManager implements EmisorEmail {

	public boolean enviarCorreoConfirmacionCompra(String cantidad, String fecha, String monto, String correoDestino)
			throws MessagingException {
		String correoComercio = "blackmarket@sociedadanonima.com";
		String user = "223a00067bab3f";
		String contraseña = "7403366672282e";
		String mensaje = "Detalles de su compra: " + "\nCantidad de remeras compradas: " + cantidad
				+ "\nFecha de la compra: " + fecha + "\nMonto total: " + monto;
		String host = "smtp.mailtrap.io";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");// it’s optional in Mailtrap
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "2525");// use one of the options in the SMTP settings tab in your Mailtrap Inbox

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, contraseña);
			}
		});

		Message message = new MimeMessage(session);

		// Set From: header field
		message.setFrom(new InternetAddress(correoComercio));

		// Set To: header field
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoDestino));

		// Set Subject: header field
		message.setSubject("Gracias por comprar en BlackMarket");

		// Put the content of your message
		message.setText(mensaje);

		// Send message
		Transport.send(message);

		return true;
	}

}
