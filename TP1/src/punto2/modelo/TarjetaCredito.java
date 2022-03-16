package punto2.modelo;

public interface TarjetaCredito {// Está mal que las tarjetas sean objetos anémicos?
	// Pensar en otra forma de representar el pago
	// Puede tener datos que no incluyo porque no se relacionan al dominio del
	// problema
	// Ej: Limite, Propietario, Etc.
	public double aplicarDescuento(double totalComida, double totalBebida);
}
