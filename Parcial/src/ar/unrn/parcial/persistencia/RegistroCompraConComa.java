package ar.unrn.parcial.persistencia;

import java.io.FileWriter;
import java.io.IOException;

import ar.unrn.parcial.modelo.Compra;
import ar.unrn.parcial.modelo.EmisorEmail;
import ar.unrn.parcial.modelo.RegistroDeCompras;

public class RegistroCompraConComa implements RegistroDeCompras {
	private String pathArchivo;
	private EmisorEmail emailSender;

	public RegistroCompraConComa(EmisorEmail emailSender) {
		this.pathArchivo = "C:\\Mateo\\Universidad\\OO2\\RegistroDeCompraDeRemerasComa.txt";
		this.emailSender = emailSender;
	}

	public boolean registrarCompra(Compra compra) throws IOException {
		FileWriter escritorArchivo = new FileWriter(pathArchivo, true);
		escritorArchivo.write(compra.datosFechaCompra() + "," + compra.cantidadRemerasCompradas() + ","
				+ compra.obtenerMontoCompra() + "\r\n");
		escritorArchivo.close();
		informarCompra(compra);
		return true;
	}

	public boolean informarCompra(Compra compra) {
		return emailSender.enviarCorreoConfirmacionCompra(String.valueOf(compra.cantidadRemerasCompradas()),
				compra.datosFechaCompra(), String.valueOf(compra.obtenerMontoCompra()), compra.emailComprador());
	}

}
