package tp2p2.modelo;

public class TarjetaMastercard implements TarjetaCredito {
	private static final double DESCUENTO = 0.02;

	public TarjetaMastercard() {

	}

	public double aplicarDescuento(double totalComida, double totalBebida) {
		return ((totalComida + totalBebida) - (totalComida * DESCUENTO));
	}

}
