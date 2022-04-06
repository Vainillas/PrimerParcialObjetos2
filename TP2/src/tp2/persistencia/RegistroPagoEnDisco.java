package tp2.persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import tp2p2.modelo.RegistroDePago;

public class RegistroPagoEnDisco implements RegistroDePago {
	private File archivoDestino;

	public RegistroPagoEnDisco(File archivoDestino) {
		this.archivoDestino = archivoDestino;
	}

	public void registrar(String registro) {
		try {
			FileWriter myWriter = new FileWriter(this.archivoDestino, true);
			myWriter.write(registro + "\n");
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
