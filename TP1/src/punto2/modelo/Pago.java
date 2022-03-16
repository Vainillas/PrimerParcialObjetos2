package punto2.modelo;

public class Pago {
	private TarjetaCredito formaPago;
	private Pedido pedidoAsoc;
	private double total;

	public Pago(TarjetaCredito formaPago, Pedido pedidoAsociado, double propina) {
		this.formaPago = formaPago;
		this.pedidoAsoc = pedidoAsociado;
		total = Descuento();
		total = total + Propina(propina);
	}

	public double Descuento() {
		return formaPago.aplicarDescuento(pedidoAsoc.totalComidaPedido(), pedidoAsoc.totalBebidasPedido());
	}

	public double Propina(double propina) {
		return (total * propina);
	}

	public TarjetaCredito getFormaPago() {
		return formaPago;
	}

	public Pedido getPedidoAsoc() {
		return pedidoAsoc;
	}

	public double getTotal() {
		return total;
	}

	public String toString() {
		return "\nEl pago total es de $" + total + " pesos.";
	}

}
