package punto2.modelo;

public class Pago {
	private TarjetaCredito formaPago;
	private Pedido pedidoAsoc;
	private double total;

	public Pago(TarjetaCredito formaPago, Pedido pedidoAsociado, double propina) {
		this.formaPago = formaPago;
		this.pedidoAsoc = pedidoAsociado;
		total = descuento();
		total = total + propina(propina);
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

	public String toString() {
		return "\nEl pago total es de $" + total + " pesos.";
	}

}
