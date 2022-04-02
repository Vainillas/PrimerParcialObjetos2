package tp2p2.modelo;

public class TarjetaComarcaPlus implements TarjetaCredito {
	private static final double DESCUENTO = 0.02;

	public TarjetaComarcaPlus() {

	}

	public double aplicarDescuento(double totalComida, double totalBebida) {
		return ((totalComida + totalBebida) - ((totalComida + totalBebida) * DESCUENTO));
	}

}
