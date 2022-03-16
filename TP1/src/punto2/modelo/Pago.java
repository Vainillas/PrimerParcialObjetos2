package punto2.modelo;

public class Pago {
	private TarjetaCredito formaPago;
	private Pedido pedidoAsoc;
	private double total;

	public Pago(TarjetaCredito formaPago, Pedido pedidoAsociado) {
		this.formaPago = formaPago;
		this.pedidoAsoc = pedidoAsociado;
		total = aplicarDescuento();
	}

	public double aplicarDescuento() {
		return formaPago.aplicarDescuento(pedidoAsoc.totalComidaPedido(), pedidoAsoc.totalBebidasPedido());
	}

}
