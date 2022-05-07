package ar.unrn.parcial.modelo;

public class Compra {
	private Remera remeraComprada;
	private int cantidadCompra;
	private Email emailComprador;
	private InterfazProveedorDeFechas proveedorFechaCompra;

	public Compra(int cantidadCompra, InterfazProveedorDeFechas proveedorFechaCompra, Remera remeraComprada,
			Email emailComprador) {
		this.cantidadCompra = cantidadCompra;
		this.proveedorFechaCompra = proveedorFechaCompra;
		this.remeraComprada = remeraComprada;
		this.emailComprador = emailComprador;
	}

	public double obtenerMontoCompra() {
		return remeraComprada.calcularCosto(cantidadCompra);
	}

	public String datosFechaCompra() {
		return proveedorFechaCompra.fecha();
	}

	public int cantidadRemerasCompradas() {
		return cantidadCompra;
	}

	public String emailComprador() {
		return emailComprador.correo();
	}

	public String obtenerDatosCompra() {
		String info = "Fecha de Compra: " + datosFechaCompra() + " Cantidad de remeras compradas: "
				+ cantidadRemerasCompradas() + " Monto total: " + obtenerMontoCompra();
		return info;
	}

}
