package mx.unam.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Carrito extends JPanel {

	public JPanel panelScroll;
	public JLabel lblTotal;
	private JTextField textFieldCantidad;

	/**
	 * Create the panel.
	 */
	public Carrito() {
		setMinimumSize(new Dimension(300, 30));
		setPreferredSize(new Dimension(600, 600));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 88, 588, 453);
		add(scrollPane);

		JLabel lblIconCarrito = new JLabel("");
		lblIconCarrito.setBounds(524, 6, 70, 70);
		lblIconCarrito.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/img/carrito.png")).getImage()
				.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
		add(lblIconCarrito);

		JLabel lblCarrito = new JLabel("Carrito");
		lblCarrito.setBounds(6, 6, 506, 70);
		lblCarrito.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarrito.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		add(lblCarrito);

		JButton btnFinalizarPedido = new JButton("Finalizar pedido");
		btnFinalizarPedido.setBounds(447, 553, 147, 41);
		add(btnFinalizarPedido);

		lblTotal = new JLabel("Total: $0");
		lblTotal.setBounds(321, 556, 114, 32);
		add(lblTotal);

		panelScroll = new JPanel();
		scrollPane.setViewportView(panelScroll);
		panelScroll.setLayout(new BoxLayout(panelScroll, BoxLayout.PAGE_AXIS));

		addPanel();

	}

	public void addPanel() {
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 100));
		panelScroll.add(panel);
		panel.setLayout(null);

		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(466, 6, 112, 36);
		panel.add(lblPrecio);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(466, 54, 112, 40);
		panel.add(btnEliminar);

		JLabel lblIcon = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/img/Hawaiana.png")).getImage()
				.getScaledInstance(-88, 88, Image.SCALE_SMOOTH)));
		lblIcon.setBounds(6, 6, 140, 88);
		panel.add(lblIcon);

		JLabel lblPizza = new JLabel("Pizza Hawaiana Grande");
		lblPizza.setBounds(158, 6, 296, 36);
		panel.add(lblPizza);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(158, 54, 61, 40);
		panel.add(lblCantidad);
		
		JButton btnMenos = new JButton("-");
		btnMenos.setBounds(231, 60, 29, 29);
		panel.add(btnMenos);
		
		JButton btnMas = new JButton("+");
		btnMas.setBounds(340, 60, 29, 29);
		panel.add(btnMas);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setEditable(false);
		textFieldCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCantidad.setText("1");
		textFieldCantidad.setBounds(272, 60, 56, 26);
		panel.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
	}
}
