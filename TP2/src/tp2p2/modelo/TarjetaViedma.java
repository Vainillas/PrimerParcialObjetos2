package tp2p2.modelo;

public class TarjetaViedma implements TarjetaCredito {
	private static final double DESCUENTO = 0;

	public TarjetaViedma() {
	}

	public double aplicarDescuento(double totalComida, double totalBebida) {
		return (totalComida + totalBebida);
	}

}
