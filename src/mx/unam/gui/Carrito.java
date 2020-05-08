package mx.unam.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mx.unam.model.Pedido;
import mx.unam.model.Producto;

public class Carrito extends JPanel {

	public JLabel lblTotal;
	private JTextField textFieldCantidad;
	public JScrollPane scrollPane;
	public JPanel contenidoCarrito;
	ArrayList<JPanel> listaPanelesProductos;

	/**
	 * Create the panel.
	 */
	public Carrito() {
		setPreferredSize(new Dimension(590, 570));
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 88, 578, 423);
		add(scrollPane);

		contenidoCarrito = new JPanel();
		scrollPane.setViewportView(contenidoCarrito);
		contenidoCarrito.setLayout(new BoxLayout(contenidoCarrito, BoxLayout.Y_AXIS));

		JLabel lblIconCarrito = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/img/carrito.png"))
				.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
		lblIconCarrito.setBounds(514, 6, 70, 70);
		add(lblIconCarrito);

		JLabel lblCarrito = new JLabel("Carrito");
		lblCarrito.setBounds(6, 6, 496, 70);
		lblCarrito.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarrito.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		add(lblCarrito);

		JButton btnFinalizarPedido = new JButton("Finalizar pedido");
		btnFinalizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pizza.cardLayout.next(Pizza.contentPane);

			}
		});
		btnFinalizarPedido.setBounds(437, 520, 147, 41);
		add(btnFinalizarPedido);

		lblTotal = new JLabel("Total: $" + Pedido.precioTotal);
		lblTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTotal.setBounds(296, 523, 129, 32);
		add(lblTotal);

		JButton btnVolver = new JButton("Seguir comprando");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pizza.cardLayout.previous(Pizza.contentPane);
			}
		});
		btnVolver.setBounds(6, 523, 133, 38);
		add(btnVolver);

		JButton btnVaciarCarrito = new JButton("Vaciar carrito");
		btnVaciarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contenidoCarrito.removeAll();
				Pedido.removeAll();
				repaint();
				revalidate();
			}
		});
		btnVaciarCarrito.setContentAreaFilled(false);
		btnVaciarCarrito.setBounds(151, 523, 133, 38);
		add(btnVaciarCarrito);

	}

	public void addPanel(Producto prod) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 100));
		panel.setMaximumSize(new Dimension(32767, 65));
		contenidoCarrito.add(panel);
		panel.setLayout(null);

		int cantidad = Pedido.unidades.get(Pedido.listaProductos.indexOf(prod));
		JLabel lblPrecio = new JLabel("Precio: $" + prod.precio * cantidad);
		lblPrecio.setBounds(446, 6, 102, 16);
		panel.add(lblPrecio);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contenidoCarrito.remove(panel);
				Pedido.removeProducto(prod);
				lblTotal.setText("Total: $" + Pedido.precioTotal);
				repaint();
				revalidate();
			}
		});
		btnEliminar.setBounds(446, 34, 102, 26);
		panel.add(btnEliminar);

		JLabel lblIcon = new JLabel(prod.icono);
		lblIcon.setBounds(0, 0, 140, 65);
		panel.add(lblIcon);

		JLabel lblPizza = new JLabel(prod.nombre + " " + prod.tamaño);
		lblPizza.setBounds(152, 6, 266, 16);
		panel.add(lblPizza);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(152, 33, 61, 26);
		panel.add(lblCantidad);

		JButton btnMenos = new JButton("-");
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reducirCantidad(prod);
			}
		});
		btnMenos.setBounds(225, 32, 29, 27);
		panel.add(btnMenos);

		JButton btnMas = new JButton("+");
		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aumentarCantidad(prod);
			}
		});
		btnMas.setBounds(334, 34, 29, 26);
		panel.add(btnMas);

		textFieldCantidad = new JTextField();
		textFieldCantidad.setEditable(false);
		textFieldCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCantidad.setText(String.valueOf(cantidad));
		textFieldCantidad.setBounds(266, 33, 56, 26);
		panel.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
	}

	void aumentarCantidad(Producto prod) {
		int index = Pedido.listaProductos.indexOf(prod);
		int cantidad = Pedido.unidades.get(index);
		Pedido.actualizarUnidades(prod, ++cantidad);
		JTextField txtField = (JTextField) contenidoCarrito.getComponent(index).getComponentAt(267, 34);
		txtField.setText(String.valueOf(cantidad));
		JLabel lbl = (JLabel) contenidoCarrito.getComponent(index).getComponentAt(447, 7);
		lbl.setText(String.valueOf("Precio: $" + prod.precio * cantidad));
		lblTotal.setText("Total: $" + Pedido.precioTotal);
		repaint();
		revalidate();
	}

	void reducirCantidad(Producto prod) {
		int index = Pedido.listaProductos.indexOf(prod);
		int cantidad = Pedido.unidades.get(index);
		if (cantidad > 1) {
			Pedido.actualizarUnidades(prod, --cantidad);
			JTextField txtField = (JTextField) contenidoCarrito.getComponent(index).getComponentAt(267, 34);
			txtField.setText(String.valueOf(cantidad));
			JLabel lbl = (JLabel) contenidoCarrito.getComponent(index).getComponentAt(447, 7);
			lbl.setText(String.valueOf("Precio: $" + prod.precio * cantidad));
			lblTotal.setText("Total: $" + Pedido.precioTotal);
			repaint();
			revalidate();
		}
	}
}
