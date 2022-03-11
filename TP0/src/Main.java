
public class Main {
	public static void main(String[] args) {
		// Impresión anémica
		Tiempo fecha = new Tiempo(3, 4, 2020);
		System.out
				.println("Impresión fecha tipo corto: " + fecha.getDia() + "/" + fecha.getMes() + "/" + fecha.getAño());
		String mes = "default";
		switch (fecha.getMes()) {
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
		System.out.println("\nImpresión fecha tipo largo: " + fecha.getDia() + " de " + mes + " de " + fecha.getAño());
	}
}
