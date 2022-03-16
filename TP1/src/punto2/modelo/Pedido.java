package punto2.modelo;

import java.util.ArrayList;

public class Pedido {
	private ArrayList<Item> listaItems;
	private Estado estado;

	public Pedido(ArrayList<Item> listaItems) {
		this.listaItems = listaItems;
		this.estado = new Estado();
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

}
