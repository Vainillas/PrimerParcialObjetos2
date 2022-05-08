package ar.unrn.parcial.modelo;

import java.io.IOException;
import java.util.List;

public class Compras implements InterfazCompras {

	public double calcularMontoCompra(int cantidadCompra, InterfazProveedorDeFechas proveedorFechaCompra,
			Remera remeraComprada) {
		Compra compra = new Compra(cantidadCompra, proveedorFechaCompra, remeraComprada,
				new Email("email@stubobject.com"));
		return compra.obtenerMontoCompra();
	}

	public Compra crearCompra(int cantidadCompra, InterfazProveedorDeFechas proveedorFechaCompra, Remera remeraComprada,
			String emailComprador) {
		return new Compra(cantidadCompra, proveedorFechaCompra, remeraComprada, new Email(emailComprador));
	}

	public List<Remera> obtenerRemeras(InterfazProveedorDeFechas proveedorFechaCompra) {
		RemeraLisa rl = new RemeraLisa(proveedorFechaCompra);
		RemeraEstampada re = new RemeraEstampada(proveedorFechaCompra);
		return List.of(rl, re);
	}

	public boolean registrarCompra(int cantidadCompra, InterfazProveedorDeFechas proveedorFechaCompra,
			Remera remeraComprada, String emailComprador, RegistroDeCompras registro) throws IOException {
		Compra compra = crearCompra(cantidadCompra, proveedorFechaCompra, remeraComprada, emailComprador);
		registro.registrarCompra(compra);
		return true;
	}

}
