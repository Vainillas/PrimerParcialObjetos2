import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TiempoNoAnemico {
	private LocalDate fechaHoy;

	public TiempoNoAnemico(LocalDate fecha) {
		fechaHoy = fecha;
	}

	public String formatoCorto() {
		return (fechaHoy.getDayOfMonth() + "/" + fechaHoy.getMonthValue() + "/" + fechaHoy.getYear());
	}

	public String formatoLargo() {
		DateTimeFormatter formatoDia = DateTimeFormatter.ofPattern("EEEE", new Locale("es", "ES"));
		DateTimeFormatter formatoMes = DateTimeFormatter.ofPattern("MMMM", new Locale("es", "ES"));
		return (fechaHoy.format(formatoDia) + " " + fechaHoy.getDayOfMonth() + " de " + fechaHoy.format(formatoMes)
				+ " de " + fechaHoy.getYear());
	}

}
