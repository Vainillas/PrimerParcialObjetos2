package tp2p2.modelo;

import java.time.LocalDate;

public class Pago {
	private TarjetaCredito formaPago;
	private Pedido pedidoAsoc;
	private double total;
	private RegistroDePago registro;

	public Pago(TarjetaCredito formaPago, Pedido pedidoAsociado, double propina, RegistroDePago registro) {
		this.formaPago = formaPago;
		this.pedidoAsoc = pedidoAsociado;
		total = descuento();
		total = total + propina(propina);
		this.registro = registro;
	}

	public double descuento() {
		return formaPago.aplicarDescuento(pedidoAsoc.totalComidaPedido(), pedidoAsoc.totalBebidasPedido());
	}

	public double propina(double propina) {
		return (total * propina);
	}

	public double total() {
		return total;
	}

	String datosARegistrar() {
		LocalDate fecha = LocalDate.now();
		return fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear() + " || " + this.total();
	}

	public void archivar() {
		this.registro.registrar(datosARegistrar());
	}

	public String toString() {
		return "\nEl pago total es de $" + total + " pesos.";
	}

}
