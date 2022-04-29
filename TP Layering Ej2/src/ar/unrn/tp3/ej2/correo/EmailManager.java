package ar.unrn.tp3.ej2.correo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ar.unrn.tp3.ej2.modelo.EmisorDeCorreo;
import ar.unrn.tp3.ej2.modelo.Mensaje;
import ar.unrn.tp3.ej2.modelo.ProveedorDeFecha;
import ar.unrn.tp3.ej2.modelo.Usuario;

public class EmailManager implements EmisorDeCorreo {
	private ProveedorDeFecha proveedor;

	public EmailManager(ProveedorDeFecha proveedor) {
		this.proveedor = proveedor;
	}

	public boolean enviarCorreoCumplea�os(String correoEmpleado) throws MessagingException {
		String correoCompa�ia = "compa�ia@company.com";
		Usuario user = new Usuario("223a00067bab3f", "7403366672282e");
		Mensaje msg = new Mensaje("Feliz Cumplea�os", "Le deseamos un muy feliz cumplea�os. \nAtt: La compa�ia.");
		String host = "smtp.mailtrap.io";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");// it�s optional in Mailtrap
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "2525");// use one of the options in the SMTP settings tab in your Mailtrap Inbox

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user.usuario(), user.contrase�a());
			}
		});

		Message message = new MimeMessage(session);

		// Set From: header field
		message.setFrom(new InternetAddress(correoCompa�ia));

		// Set To: header field
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoEmpleado));

		// Set Subject: header field
		message.setSubject(msg.asunto());

		// Put the content of your message
		message.setText(msg.cuerpo());

		// Send message
		Transport.send(message);

		return true;

	}

}
