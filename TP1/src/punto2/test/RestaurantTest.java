package punto2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import punto2.exception.StateException;
import punto2.modelo.Bebida;
import punto2.modelo.Comida;
import punto2.modelo.Consumible;
import punto2.modelo.Item;
import punto2.modelo.Pago;
import punto2.modelo.Pedido;
import punto2.modelo.TarjetaComarcaPlus;
import punto2.modelo.TarjetaMastercard;
import punto2.modelo.TarjetaViedma;
import punto2.modelo.TarjetaVisa;

public class RestaurantTest {
	@Test
	public void main() throws StateException {
		// Inicialización
		Consumible c1 = new Bebida("Coca Cola 500ml", 120);
		Consumible c2 = new Bebida("Aquarius 150ml", 70);
		Consumible c3 = new Bebida("Vino Rosado Dadá", 350);
		Consumible c4 = new Comida("Pato a la naranja", 1100);
		Consumible c5 = new Comida("Milanesa de pescado a la napolitana", 800);
		Consumible c6 = new Comida("Cazuela de Mariscos", 1300);
		ArrayList<Consumible> listaMenu = new ArrayList<>();
		listaMenu.add(c6);
		listaMenu.add(c5);
		listaMenu.add(c4);
		listaMenu.add(c3);
		listaMenu.add(c2);
		listaMenu.add(c1);

		Item i1 = new Item(c2, 5);
		Item i2 = new Item(c3, 2);
		Item i3 = new Item(c4, 1);
		Item i4 = new Item(c6, 1);
		ArrayList<Item> listaPedido = new ArrayList<>();
		listaPedido.add(i1);
		listaPedido.add(i2);
		listaPedido.add(i3);
		listaPedido.add(i4);
		Pedido p1 = new Pedido(listaPedido);
		Pedido p2 = new Pedido(listaPedido);
		Pedido p3 = new Pedido(listaPedido);
		Pedido p4 = new Pedido(listaPedido);
		p1.confirmarPedido();
		p2.confirmarPedido();
		p3.confirmarPedido();
		p4.confirmarPedido();

		TarjetaMastercard mastercard = new TarjetaMastercard();
		TarjetaComarcaPlus comarcaPlus = new TarjetaComarcaPlus();
		TarjetaViedma viedma = new TarjetaViedma();
		TarjetaVisa visa = new TarjetaVisa();
		// Ejercitación
		System.out.println(p1.toString());

		Pago pago1 = p1.pagarPedido(visa, 0.05); // $1018.5 bebidas con descuento del 3% + $2400 = $3418.5 | Con propina
													// de
													// 5% se va a $3589.425
		Pago pago2 = p2.pagarPedido(mastercard, 0.05); // $2352 platos con descuento del 2% + $1050 = 3402 | Con propina
														// de 5% se va a $3572.1
		Pago pago3 = p3.pagarPedido(comarcaPlus, 0.05); // $3381 con descuento de 2% | Con propina de 5% se va a
														// $3350.05
		Pago pago4 = p4.pagarPedido(viedma, 0.05); // $3450 sin descuento | Con propina de 5% se va a $3622.5
		// Verificación
		double p = 3589.425;
		assertEquals(p, pago1.getTotal());
		p = 3572.1;
		assertEquals(p, pago2.getTotal());
		p = 3550.05;
		assertEquals(p, pago3.getTotal());
		p = 3622.5;
		assertEquals(p, pago4.getTotal());

	}

}
