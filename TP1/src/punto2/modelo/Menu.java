package punto2.modelo;

import java.util.ArrayList;

public class Menu {
	ArrayList<Consumible> listaConsumibles;

	public Menu() {
		listaConsumibles = new ArrayList<>();
	}

	public Menu(ArrayList<Consumible> listaConsumibles) {
		this.listaConsumibles = listaConsumibles;
	}

	public boolean agregarConsumible(Consumible consumible) {
		if (!listaConsumibles.contains(consumible)) {
			return listaConsumibles.add(consumible);
		} else
			return false;
	}

	public boolean eliminarConsumible(Consumible consumible) {
		if (listaConsumibles.contains(consumible))
			return listaConsumibles.remove(consumible);
		else
			return false;
	}

	public Consumible getConsumible(int index) {
		return listaConsumibles.get(index);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("\nMenú Disponible: ");

		for (Consumible c : listaConsumibles) {
			sb.append("\n" + listaConsumibles.indexOf(c) + ". ").append(c.toString());
		}

		return sb.toString();

	}

}
