package tp2p2.modelo;

public class Consumible {
	private String nombre;
	private double precio;

	public Consumible(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public double precio() {
		return precio;
	}

	public String toString() {
		return "\nConsumible: " + nombre + " - Precio Unitario: $" + precio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumible other = (Consumible) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
			return false;
		return true;
	}

}
