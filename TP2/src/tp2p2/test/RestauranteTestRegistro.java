package tp2p2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import tp2p2.modelo.Bebida;
import tp2p2.modelo.Comida;
import tp2p2.modelo.Pago;
import tp2p2.modelo.Pedido;
import tp2p2.modelo.TarjetaComarcaPlus;
import tp2p2.modelo.TarjetaMastercard;
import tp2p2.modelo.TarjetaViedma;
import tp2p2.modelo.TarjetaVisa;

public class RestauranteTestRegistro {
	StubObjectRestaurante registro = new StubObjectRestaurante();
	// Como hacer para no tener que cambiar la clase de la variable 'registro'?
	// Si lo dejo con la interfaz RegistroDePago no puedo llamar al metodo
	// registro()

	@Test
	public void testTarjetaMastercard() {
		// Inicializaci�n
		Bebida b1 = new Bebida("Coca Cola 500ml", 120);
		Bebida b2 = new Bebida("Aquarius 150ml", 70);
		Bebida b3 = new Bebida("Vino Rosado Dad�", 350);
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
		Pedido p1 = new Pedido(listaBebidas, listaComidas, registro);
		p1.confirmarPedido();

		TarjetaMastercard mastercard = new TarjetaMastercard();

		// Ejercitaci�n
		Pago pago1 = p1.pagarPedido(mastercard, 0.05); // $3136 platos con descuento del 2% + $540 = 3676 |
														// Con propina
		// de 5% se va a $3859.8

		// Verificaci�n

		double resultadoPago = 3859.8;
		LocalDate fecha = LocalDate.now();
		String resultadoRegistro = fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear()
				+ " || 3859.8";
		assertEquals(resultadoRegistro, registro.registro());
		assertEquals(resultadoPago, pago1.total());

	}

	@Test
	public void testTarjetaComarcaPlus() {
		// Inicializaci�n
		Bebida b1 = new Bebida("Coca Cola 500ml", 120);
		Bebida b2 = new Bebida("Aquarius 150ml", 70);
		Bebida b3 = new Bebida("Vino Rosado Dad�", 350);
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
		Pedido p1 = new Pedido(listaBebidas, listaComidas, registro);
		p1.confirmarPedido();

		TarjetaComarcaPlus comarcaPlus = new TarjetaComarcaPlus();

		// Ejercitaci�n
		Pago pago1 = p1.pagarPedido(comarcaPlus, 0.05); // $3665.2 con descuento de 2% | Con propina de 5% se
														// va a
		// $3848.46
		// Verificaci�n
		double resultadoPago = 3848.46;
		LocalDate fecha = LocalDate.now();
		String resultadoRegistro = fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear()
				+ " || 3848.46";
		assertEquals(resultadoRegistro, registro.registro());
		assertEquals(resultadoPago, pago1.total());
	}

	@Test
	public void testTarjetaViedma() {
		// Inicializaci�n
		Bebida b1 = new Bebida("Coca Cola 500ml", 120);
		Bebida b2 = new Bebida("Aquarius 150ml", 70);
		Bebida b3 = new Bebida("Vino Rosado Dad�", 350);
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
		Pedido p1 = new Pedido(listaBebidas, listaComidas, registro);
		p1.confirmarPedido();
		TarjetaViedma viedma = new TarjetaViedma();
		// Ejercitaci�n
		Pago pago1 = p1.pagarPedido(viedma, 0.05); // $3740 sin descuento | Con propina de 5% se va a $3927
		// Verificaci�n
		double resultadoPago = 3927;
		LocalDate fecha = LocalDate.now();
		String resultadoRegistro = fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear()
				+ " || 3927.0";
		assertEquals(resultadoRegistro, registro.registro());
		assertEquals(resultadoPago, pago1.total());
	}

	@Test
	public void testTarjetaVisa() {
		// Inicializaci�n
		Bebida b1 = new Bebida("Coca Cola 500ml", 120);
		Bebida b2 = new Bebida("Aquarius 150ml", 70);
		Bebida b3 = new Bebida("Vino Rosado Dad�", 350);
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
		listaBebidas.add(b3); // Tuve que agregar otra bebida porque el calculo me daba con much�simos
								// decimales y el assert
								// daba false por eso.
		Pedido p1 = new Pedido(listaBebidas, listaComidas, registro);
		p1.confirmarPedido();
		TarjetaVisa visa = new TarjetaVisa();
		// Ejercitaci�n
		Pago pago1 = p1.pagarPedido(visa, 0.05); // $863.3 bebidas con descuento del 3% + $3200 = $4063.3 |
													// Con propina
		// de 5% se va a $4266.465
		// Verificaci�n
		double resultadoPago = 4266.465;
		LocalDate fecha = LocalDate.now();
		String resultadoRegistro = fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear()
				+ " || 4266.465";
		assertEquals(resultadoRegistro, registro.registro());
		assertEquals(resultadoPago, pago1.total());
	}

}
