import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TiempoNoAnemico {
	private Date fechaHoy;
	private Calendar c;

	public TiempoNoAnemico(Date fecha) {
		fechaHoy = fecha;
		c = Calendar.getInstance();
		c.setTime(fechaHoy);
	}

	public void ImprimirFormatoCorto() {
		System.out
				.println(c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
	}

	public void ImprimirFormatoLargo() {
		System.out.println(new SimpleDateFormat("EEEE").format(fechaHoy) + " " + (c.get(Calendar.DAY_OF_MONTH)) + " de "
				+ (new SimpleDateFormat("MMMM").format(fechaHoy) + " de " + c.get(Calendar.YEAR)));
	}

	public Date getFechaHoy() {
		return fechaHoy;
	}

	public void setFechaHoy(Date fechaHoy) {
		this.fechaHoy = fechaHoy;
	}

}
