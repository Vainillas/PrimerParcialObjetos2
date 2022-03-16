package punto2.modelo;

public class TarjetaVisa implements TarjetaCredito {
	private static final double DESCUENTO = 0.03;

	public TarjetaVisa() {

	}

	public double aplicarDescuento(double totalComida, double totalBebida) {
		return ((totalComida + totalBebida) - (totalBebida * DESCUENTO));
	}

}
