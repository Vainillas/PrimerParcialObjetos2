import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		// Getters y setters borrados del no anemico
		// Devuelven string en vez del syso
		// Reemplazado el Calendar y Date por LocalDate

		// Impresi�n an�mica
		LocalDate fechaHoy = LocalDate.now();
		TiempoAnemico fechaA = new TiempoAnemico(fechaHoy.getDayOfMonth(), fechaHoy.getMonthValue(),
				fechaHoy.getYear());
		System.out.println("Impresi�n fecha modo an�mico formato corto: \n" + fechaA.getDia() + "/" + fechaA.getMes()
				+ "/" + fechaA.getA�o());
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
		System.out.println("\nImpresi�n fecha modo an�mico formato largo: \n" + fechaA.getDia() + " de " + mes + " de "
				+ fechaA.getA�o());

		/********************************
		 * Tiempo no an�mico
		 **********************************/

		TiempoNoAnemico fechaNA = new TiempoNoAnemico(fechaHoy);
		System.out.println("\nImpresi�n fecha de modo no an�mico en formato corto: ");
		System.out.println(fechaNA.formatoCorto());
		System.out.println("\nImpresi�n fecha de modo no an�mico en formato largo: ");
		System.out.println(fechaNA.formatoLargo());
	}
}
