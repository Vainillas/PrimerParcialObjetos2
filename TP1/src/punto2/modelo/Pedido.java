package punto2.modelo;

import java.util.ArrayList;

import punto2.exception.StateException;

public class Pedido {
	private ArrayList<Item> listaItems;
	private Estado estado;
	private boolean pagado;

	public Pedido(ArrayList<Item> listaItems) {
		this.listaItems = listaItems;
		this.estado = new Estado();
		pagado = false;
	}

	public boolean agregarItem(Item item) {
		if (estado.pendiente() && (!listaItems.contains(item))) {
			return listaItems.add(item);
		} else
			return false;
	}

	public boolean eliminarItem(Item item) {
		if (estado.pendiente() && listaItems.contains(item))
			return listaItems.remove(item);
		else
			return false;
	}

	public double totalPedido() {
		double total = 0;
		for (Item i : listaItems) {
			total = total + i.precioTotal();
		}
		return total;
	}

	public double totalBebidasPedido() {
		double total = 0;
		for (Item i : listaItems) {
			if (i.getConsumible() instanceof Bebida) {
				total = total + i.precioTotal();
			}

		}
		return total;
	}

	public double totalComidaPedido() {
		double total = 0;
		for (Item i : listaItems) {
			if (i.getConsumible() instanceof Comida) {
				total = total + i.precioTotal();
			}

		}
		return total;
	}

	public void confirmarPedido() throws StateException {
		estado.confirmar();
	}

	public boolean confirmado() {
		return this.estado.confirmado();
	}

	public boolean pendiente() {
		return this.estado.pendiente();
	}

	public Pago pagarPedido(TarjetaCredito formaPago, double propina) {
		Pago p = null;
		if (this.confirmado() && pagado == false) {
			p = new Pago(formaPago, this, propina);
			pagado = true;
		}
		return p;

	}

	@Override
	public String toString() {
		return "\n-Pedido- \nLista Items: " + listaItems + "\n Estado=" + estado + "\nTotal Comida: $"
				+ this.totalComidaPedido() + "\nTotal Bebida: $" + this.totalBebidasPedido() + "\nTotal Pedido: $"
				+ this.totalPedido();
	}

}
