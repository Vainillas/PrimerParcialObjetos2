package tp2p2.modelo;

import java.util.ArrayList;

public class Pedido {
	private RegistroDePago registro;
	private ArrayList<Bebida> listaBebida;
	private ArrayList<Comida> listaComida;
	private Estado estado;
	private boolean pagado;

	public Pedido() {
		listaComida = new ArrayList<>();
		listaBebida = new ArrayList<>();
		this.estado = new Estado();
		pagado = false;
	}

	public Pedido(ArrayList<Bebida> listaBebida, ArrayList<Comida> listaComida, RegistroDePago registro) {
		this();
		this.registro = registro;
		this.listaComida = listaComida;
		this.listaBebida = listaBebida;
	}

	public boolean agregarComida(Comida c) {
		if (estado.pendiente()) {
			return listaComida.add(c);
		} else
			return false;
	}

	public boolean agregarBebida(Bebida b) {
		if (estado.pendiente()) {
			return listaBebida.add(b);
		} else
			return false;
	}

	public boolean eliminarBebida(Bebida b) {
		if (estado.pendiente() && listaBebida.contains(b))
			return listaBebida.remove(b);
		else
			return false;
	}

	public boolean eliminarComida(Comida c) {
		if (estado.pendiente() && listaComida.contains(c))
			return listaComida.remove(c);
		else
			return false;
	}

	public double totalPedido() {
		double total = 0;
		for (Comida c : listaComida) {
			total = total + c.precio();
		}
		for (Bebida b : listaBebida) {
			total = total + b.precio();
		}
		return total;
	}

	public double totalBebidasPedido() {
		double total = 0;
		for (Bebida b : listaBebida) {
			// if (i.getConsumible() instanceof Bebida) {// No va
			total = total + b.precio();

		}
		return total;
	}

	public double totalComidaPedido() {
		double total = 0;
		for (Comida c : listaComida) {
			// if (i.getConsumible() instanceof Comida) { // No va
			total = total + c.precio();

		}
		return total;
	}

	public void confirmarPedido() {
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
			p = new Pago(formaPago, this, propina, registro);
			pagado = true;
			p.archivar();
		}
		return p;

	}

	@Override
	public String toString() {
		return "\n-Pedido- \nLista Platos: " + listaComida + "\nLista Bebidas: " + listaBebida + "\n Estado=" + estado
				+ "\nTotal Comida: $" + this.totalComidaPedido() + "\nTotal Bebida: $" + this.totalBebidasPedido()
				+ "\nTotal Pedido: $" + this.totalPedido();
	}

}
