package punto2.modelo;

public class Item {
	private Consumible consumible;
	private int cantidad;

	public Item(Consumible consumible, int cantidad) {
		this.consumible = consumible;
		this.cantidad = cantidad;
	}

	public double precioTotal() {
		return consumible.getPrecio() * cantidad;
	}

	public double precioUnitario() {
		return consumible.getPrecio();
	}

	public Consumible getConsumible() {
		return consumible;
	}

	public void setConsumible(Consumible consumible) {
		this.consumible = consumible;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consumible == null) ? 0 : consumible.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (consumible == null) {
			if (other.consumible != null)
				return false;
		} else if (!consumible.equals(other.consumible))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n-Consumible: " + consumible.getNombre() + " Cantidad: " + cantidad + " Precio Unidad: "
				+ precioUnitario() + " Precio Total: " + precioTotal();
	}

}
