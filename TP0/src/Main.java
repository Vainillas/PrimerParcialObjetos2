import java.util.Calendar;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		// Impresión anémica
		Date fechaHoy = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(fechaHoy);
		TiempoAnemico fechaA = new TiempoAnemico(c.get(Calendar.DAY_OF_MONTH), (c.get(Calendar.MONTH) + 1),
				c.get(Calendar.YEAR));
		System.out.println("Impresión fecha modo anémico formato corto: \n" + fechaA.getDia() + "/" + fechaA.getMes()
				+ "/" + fechaA.getAño());
		String mes = "default";
		switch (fechaA.getMes()) {
		case 1: {
			mes = "enero";
			break;
		}
		case 2: {
			mes = "febrero";
			break;
		}
		case 3: {
			mes = "marzo";
			break;
		}
		case 4: {
			mes = "abril";
			break;
		}
		case 5: {
			mes = "mayo";
			break;
		}
		case 6: {
			mes = "junio";
			break;
		}
		case 7: {
			mes = "julio";
			break;
		}
		case 8: {
			mes = "agosto";
			break;
		}
		case 9: {
			mes = "septiembre";
			break;
		}
		case 10: {
			mes = "octubre";
			break;
		}
		case 11: {
			mes = "noviembre";
			break;
		}
		case 12: {
			mes = "diciembre";
			break;
		}
		}
		System.out.println("\nImpresión fecha modo anémico formato largo: \n" + fechaA.getDia() + " de " + mes + " de "
				+ fechaA.getAño());

		/********************************
		 * Tiempo no anémico
		 **********************************/

		TiempoNoAnemico fechaNA = new TiempoNoAnemico(fechaHoy);
		System.out.println("\nImpresión fecha de modo no anémico en formato corto: ");
		fechaNA.ImprimirFormatoCorto();
		System.out.println("\nImpresión fecha de modo no anémico en formato largo: ");
		fechaNA.ImprimirFormatoLargo();
	}
}
