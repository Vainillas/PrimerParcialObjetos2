package ar.unrn.parcial.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import ar.unrn.parcial.modelo.InterfazCompras;
import ar.unrn.parcial.modelo.InterfazProveedorDeFechas;
import ar.unrn.parcial.modelo.RegistroDeCompras;
import ar.unrn.parcial.modelo.Remera;

public class GUICompraRemeras {
	private RegistroDeCompras registro;
	private List<Remera> listaRemerasDisponibles;
	private InterfazProveedorDeFechas proveedorFechaCompra;
	private InterfazCompras compras;

	private JPanel contentPane;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JComboBox<String> comboBox;
	private JButton btnOk;
	private JLabel lblCompetition;
	private JTextField txtMonto;

	public GUICompraRemeras(RegistroDeCompras registro, InterfazProveedorDeFechas proveedorFechaCompra,
			InterfazCompras compras) {
		this.registro = registro;
		this.proveedorFechaCompra = proveedorFechaCompra;
		this.compras = compras;
		initializeFrame();

	}

	private void initializeFrame() {
		var frame = new JFrame("Pantalla de compra de remeras");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 448, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		formElements();
		layout();
		frame.setVisible(true);
	}

	private void formElements() {
		lblCantidad = new JLabel("Cantidad de remeras a comprar:");
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		lblEmail = new JLabel("Email:");
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		btnOk = new JButton("Confirmar Compra");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOk.setEnabled(false);
				registrarCompra(txtCantidad.getText(), txtEmail.getText());
				btnOk.setEnabled(true);
			}
		});
		lblCompetition = new JLabel("Tipo de Remera:");
		comboBox = new JComboBox<String>();
		tiposDeRemeras();
	}

	private void registrarCompra(String cantidad, String email) {
		try {
			registro.registrarCompra(compras.crearCompra(Integer.parseInt(cantidad), proveedorFechaCompra,
					listaRemerasDisponibles.get(comboBox.getSelectedIndex()), email));
		} catch (IOException | NumberFormatException | MessagingException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	private double obtenerMontoCompra(String cantidad) {
		return compras.calcularMontoCompra(Integer.parseInt(cantidad), proveedorFechaCompra,
				listaRemerasDisponibles.get(comboBox.getSelectedIndex()));
	}

	private void tiposDeRemeras() {
		List<Remera> listaTiposDeRemeras = compras.obtenerRemeras(proveedorFechaCompra);
		for (Remera r : listaTiposDeRemeras) {
			comboBox.addItem(r.tipoRemera());
		}
		listaRemerasDisponibles = listaTiposDeRemeras;
	}

	private void layout() {

		JButton btnOk_1 = new JButton("Mostrar Monto");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMonto.setText(String.valueOf(obtenerMontoCompra(txtCantidad.getText())));

			}
		});

		txtMonto = new JTextField();
		txtMonto.setEditable(false);
		txtMonto.setColumns(10);

		JLabel lblNewLabel = new JLabel("Monto compra:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblCantidad, GroupLayout.DEFAULT_SIZE, 174,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblCompetition, GroupLayout.PREFERRED_SIZE, 154,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
										.addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(comboBox, 0, 205, Short.MAX_VALUE)
												.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, 34,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtMonto))
										.addGap(29))))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
								.addComponent(btnOk_1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblEmail)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCompetition))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(txtMonto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE).addGroup(gl_contentPane
								.createParallelGroup(Alignment.BASELINE).addComponent(btnOk).addComponent(btnOk_1))));
		contentPane.setLayout(gl_contentPane);
	}
}
