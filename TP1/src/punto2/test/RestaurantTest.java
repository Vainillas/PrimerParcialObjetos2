package punto2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import punto2.modelo.Bebida;
import punto2.modelo.Comida;
import punto2.modelo.Pago;
import punto2.modelo.Pedido;
import punto2.modelo.TarjetaComarcaPlus;
import punto2.modelo.TarjetaMastercard;
import punto2.modelo.TarjetaViedma;
import punto2.modelo.TarjetaVisa;

public class RestaurantTest {
	@Test
	public void testTarjetaMastercard() {
		// Inicialización
		Bebida b1 = new Bebida("Coca Cola 500ml", 120);
		Bebida b2 = new Bebida("Aquarius 150ml", 70);
		Bebida b3 = new Bebida("Vino Rosado Dadá", 350);
		Comida c1 = new Comida("Pato a la naranja", 1100);
		Comida c2 = new Comida("Milanesa de pescado a la napolitana", 800);
		Comida c3 = new Comida("Cazuela de Mariscos", 1300);

		ArrayList<Comida> listaComidas = new ArrayList<>();
		ArrayList<Bebida> listaBebidas = new ArrayList<>();
		listaComidas.add(c1);
		listaComidas.add(c2);
		listaComidas.add(c3);
		listaBebidas.add(b1);
		listaBebidas.add(b2);
		listaBebidas.add(b3);
		Pedido p1 = new Pedido(listaBebidas, listaComidas);
		p1.confirmarPedido();

		TarjetaMastercard mastercard = new TarjetaMastercard();

		// Ejercitación
		Pago pago1 = p1.pagarPedido(mastercard, 0.05); // $3136 platos con descuento del 2% + $540 = 3676 | Con propina
														// de 5% se va a $3859.8

		// Verificación
		double p = 3859.8;
		assertEquals(p, pago1.total());

	}

	@Test
	public void testTarjetaComarcaPlus() {
		// Inicialización
		Bebida b1 = new Bebida("Coca Cola 500ml", 120);
		Bebida b2 = new Bebida("Aquarius 150ml", 70);
		Bebida b3 = new Bebida("Vino Rosado Dadá", 350);
		Comida c1 = new Comida("Pato a la naranja", 1100);
		Comida c2 = new Comida("Milanesa de pescado a la napolitana", 800);
		Comida c3 = new Comida("Cazuela de Mariscos", 1300);

		ArrayList<Comida> listaComidas = new ArrayList<>();
		ArrayList<Bebida> listaBebidas = new ArrayList<>();
		listaComidas.add(c1);
		listaComidas.add(c2);
		listaComidas.add(c3);
		listaBebidas.add(b1);
		listaBebidas.add(b2);
		listaBebidas.add(b3);
		Pedido p1 = new Pedido(listaBebidas, listaComidas);
		p1.confirmarPedido();

		TarjetaComarcaPlus comarcaPlus = new TarjetaComarcaPlus();

		// Ejercitación
		Pago pago1 = p1.pagarPedido(comarcaPlus, 0.05); // $3665.2 con descuento de 2% | Con propina de 5% se va a
		// $3848.46
		// Verificación
		double p = 3848.46;
		assertEquals(p, pago1.total());
	}

	@Test
	public void testTarjetaViedma() {
		// Inicialización
		Bebida b1 = new Bebida("Coca Cola 500ml", 120);
		Bebida b2 = new Bebida("Aquarius 150ml", 70);
		Bebida b3 = new Bebida("Vino Rosado Dadá", 350);
		Comida c1 = new Comida("Pato a la naranja", 1100);
		Comida c2 = new Comida("Milanesa de pescado a la napolitana", 800);
		Comida c3 = new Comida("Cazuela de Mariscos", 1300);

		ArrayList<Comida> listaComidas = new ArrayList<>();
		ArrayList<Bebida> listaBebidas = new ArrayList<>();
		listaComidas.add(c1);
		listaComidas.add(c2);
		listaComidas.add(c3);
		listaBebidas.add(b1);
		listaBebidas.add(b2);
		listaBebidas.add(b3);
		Pedido p1 = new Pedido(listaBebidas, listaComidas);
		p1.confirmarPedido();
		TarjetaViedma viedma = new TarjetaViedma();
		// Ejercitación
		Pago pago1 = p1.pagarPedido(viedma, 0.05); // $3740 sin descuento | Con propina de 5% se va a $3927
		// Verificación
		double p = 3927;
		assertEquals(p, pago1.total());
	}

	@Test
	public void testTarjetaVisa() {
		// Inicialización
		Bebida b1 = new Bebida("Coca Cola 500ml", 120);
		Bebida b2 = new Bebida("Aquarius 150ml", 70);
		Bebida b3 = new Bebida("Vino Rosado Dadá", 350);
		Comida c1 = new Comida("Pato a la naranja", 1100);
		Comida c2 = new Comida("Milanesa de pescado a la napolitana", 800);
		Comida c3 = new Comida("Cazuela de Mariscos", 1300);

		ArrayList<Comida> listaComidas = new ArrayList<>();
		ArrayList<Bebida> listaBebidas = new ArrayList<>();
		listaComidas.add(c1);
		listaComidas.add(c2);
		listaComidas.add(c3);
		listaBebidas.add(b1);
		listaBebidas.add(b2);
		listaBebidas.add(b3);
		listaBebidas.add(b3); // Tuve que agregar otra bebida porque el calculo me daba con muchísimos
								// decimales y el assert
								// daba false por eso.
		Pedido p1 = new Pedido(listaBebidas, listaComidas);
		p1.confirmarPedido();
		TarjetaVisa visa = new TarjetaVisa();
		// Ejercitación
		Pago pago1 = p1.pagarPedido(visa, 0.05); // $863.3 bebidas con descuento del 3% + $3200 = $4063.3 | Con propina
		// de 5% se va a $4266.465
		// Verificación
		double p = 4266.465;
		assertEquals(p, pago1.total());
	}

}
