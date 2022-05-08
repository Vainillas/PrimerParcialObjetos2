package ar.unrn.parcial.modelo;

import java.io.IOException;
import java.util.List;

public interface InterfazCompras {
	public double calcularMontoCompra(int cantidadCompra, InterfazProveedorDeFechas proveedorFechaCompra,
			Remera remeraComprada);

	public Compra crearCompra(int cantidadCompra, InterfazProveedorDeFechas proveedorFechaCompra, Remera remeraComprada,
			String emailComprador);

	public List<Remera> obtenerRemeras(InterfazProveedorDeFechas proveedorFechaCompra);

	public boolean registrarCompra(int cantidadCompra, InterfazProveedorDeFechas proveedorFechaCompra,
			Remera remeraComprada, String emailComprador, RegistroDeCompras registro) throws IOException;

}
