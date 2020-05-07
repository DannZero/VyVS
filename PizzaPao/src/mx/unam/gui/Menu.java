package mx.unam.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JPanel {
	
	public static Carrito carrito;
	float precioTotal;
	public JLabel lblTotal;

	/**
	 * Create the panel.
	 */
	public Menu() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		precioTotal = 0;

		JButton btnTotal = new JButton("Total");
		btnTotal.setBounds(33, 377, 117, 29);
		add(btnTotal);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(33, 418, 117, 29);
		add(btnLimpiar);

		JButton btnAgregarCarrito = new JButton("Agregar al Carrito");
		btnAgregarCarrito.setBounds(240, 418, 138, 29);
		add(btnAgregarCarrito);

		lblTotal = new JLabel("Total: $" + precioTotal);
		lblTotal.setBounds(248, 382, 130, 16);
		add(lblTotal);

	}

}
