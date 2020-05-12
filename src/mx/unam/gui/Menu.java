package mx.unam.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdk.nashorn.internal.runtime.options.Options;
import mx.unam.model.Pedido;
import mx.unam.model.Producto;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JPanel {

	public static Carrito carrito;
	float precioTotal;
	private JButton btnHawaiana;
	private JButton btnMexicana;
	private JButton btnPepperoniEspecial;
	private JButton btnCarnesFrias;
	private JButton btnCuatroQuesos;
	private JButton btnVegetariana;

	/**
	 * Create the panel.
	 */
	public Menu() {
		setPreferredSize(new Dimension(590, 570));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		btnHawaiana = new JButton(new ImageIcon(new ImageIcon(getClass().getResource("/img/Hawaiana.png")).getImage()
				.getScaledInstance(-70, 65, Image.SCALE_SMOOTH)));
		btnHawaiana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPizza(btnHawaiana);
			}
		});

		JButton btnCarrito = new JButton(new ImageIcon(new ImageIcon(getClass().getResource("/img/carrito.png"))
				.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		btnCarrito.setVerticalTextPosition(SwingConstants.TOP);
		btnCarrito.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pizza.cardLayout.next(Pizza.contentPane);
			}
		});
		btnCarrito.setBounds(538, 6, 46, 46);
		add(btnCarrito);
		btnHawaiana.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHawaiana.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnHawaiana.setText("Hawaiana");
		btnHawaiana.setBounds(46, 64, 246, 95);
		add(btnHawaiana);

		btnMexicana = new JButton(new ImageIcon(new ImageIcon(getClass().getResource("/img/Mexicana.png")).getImage()
				.getScaledInstance(-70, 65, Image.SCALE_SMOOTH)));
		btnMexicana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPizza(btnMexicana);
			}
		});
		btnMexicana.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMexicana.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMexicana.setText("Mexicana");
		btnMexicana.setBounds(304, 171, 245, 95);
		add(btnMexicana);

		btnPepperoniEspecial = new JButton(
				new ImageIcon(new ImageIcon(getClass().getResource("/img/PepperoniEspecial.png")).getImage()
						.getScaledInstance(-70, 65, Image.SCALE_SMOOTH)));
		btnPepperoniEspecial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPizza(btnPepperoniEspecial);
			}
		});
		btnPepperoniEspecial.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPepperoniEspecial.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPepperoniEspecial.setText("Pepperoni Especial");
		btnPepperoniEspecial.setBounds(304, 64, 245, 95);
		add(btnPepperoniEspecial);

		btnCarnesFrias = new JButton(new ImageIcon(new ImageIcon(getClass().getResource("/img/CarnesFrias.png"))
				.getImage().getScaledInstance(-70, 65, Image.SCALE_SMOOTH)));
		btnCarnesFrias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPizza(btnCarnesFrias);
			}
		});
		btnCarnesFrias.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCarnesFrias.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCarnesFrias.setText("Carnes Frías");
		btnCarnesFrias.setBounds(304, 278, 245, 95);
		add(btnCarnesFrias);

		btnCuatroQuesos = new JButton(new ImageIcon(new ImageIcon(getClass().getResource("/img/CuatroQuesos.png"))
				.getImage().getScaledInstance(-70, 65, Image.SCALE_SMOOTH)));
		btnCuatroQuesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPizza(btnCuatroQuesos);
			}
		});
		btnCuatroQuesos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCuatroQuesos.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCuatroQuesos.setText("Cuatro Quesos");
		btnCuatroQuesos.setBounds(46, 171, 246, 95);
		add(btnCuatroQuesos);

		btnVegetariana = new JButton(new ImageIcon(new ImageIcon(getClass().getResource("/img/Vegetariana.png"))
				.getImage().getScaledInstance(-70, 65, Image.SCALE_SMOOTH)));
		btnVegetariana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPizza(btnVegetariana);
			}
		});
		btnVegetariana.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVegetariana.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVegetariana.setText("Vegetariana");
		btnVegetariana.setBounds(46, 278, 246, 95);
		add(btnVegetariana);

		JLabel lblNewLabel = new JLabel("PIZZAS");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 578, 46);
		add(lblNewLabel);

		JLabel lblBebidas = new JLabel("BEBIDAS");
		lblBebidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBebidas.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblBebidas.setBounds(6, 396, 578, 46);
		add(lblBebidas);

		JButton btnLipton = new JButton(new ImageIcon(new ImageIcon(getClass().getResource("/img/FLIPTON.png"))
				.getImage().getScaledInstance(-70, 65, Image.SCALE_SMOOTH)));
		btnLipton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBebida(btnLipton);
			}
		});
		btnLipton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLipton.setText("Lipton");
		btnLipton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLipton.setBounds(46, 454, 117, 110);
		add(btnLipton);

		JButton btnPepsi = new JButton(new ImageIcon(new ImageIcon(getClass().getResource("/img/FPEPSI.png")).getImage()
				.getScaledInstance(-70, 65, Image.SCALE_SMOOTH)));
		btnPepsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBebida(btnPepsi);
			}
		});
		btnPepsi.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPepsi.setText("Pepsi");
		btnPepsi.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPepsi.setBounds(175, 454, 117, 110);
		add(btnPepsi);

		JButton btnManzana = new JButton(new ImageIcon(new ImageIcon(getClass().getResource("/img/FPMANZA.png"))
				.getImage().getScaledInstance(-70, 65, Image.SCALE_SMOOTH)));
		btnManzana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBebida(btnManzana);
			}
		});
		btnManzana.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnManzana.setText("Manzanita");
		btnManzana.setHorizontalTextPosition(SwingConstants.CENTER);
		btnManzana.setBounds(304, 454, 117, 110);
		add(btnManzana);

		JButton btnNaranja = new JButton(new ImageIcon(new ImageIcon(getClass().getResource("/img/FPNARAN.png"))
				.getImage().getScaledInstance(-70, 65, Image.SCALE_SMOOTH)));
		btnNaranja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBebida(btnNaranja);
			}
		});
		btnNaranja.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNaranja.setText("Mirinda");
		btnNaranja.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNaranja.setBounds(432, 454, 117, 110);
		add(btnNaranja);

	}

	void addPizza(JButton botonPizza) {
		Object[] options = { "Mediana", "Grande", "Familiar" };
		Object selectedValue = JOptionPane.showInputDialog(null, "Elija el tamaño", "Agregar al carrito", -1, null,
				options, options[1]);

		if (selectedValue != null) {
			double precio = 0;
			switch (selectedValue.toString()) {
			case "Mediana":
				precio = 169;
				break;
			case "Grande":
				precio = 199;
				break;
			case "Familiar":
				precio = 259;
				break;
			}
			Producto prod = new Producto("Pizza " + botonPizza.getText(), selectedValue.toString(), precio,
					botonPizza.getIcon());
			Pedido.addProducto(prod);
			Pizza.carrito.lblTotal.setText("Total: " + Pedido.precioTotal);
			Pizza.carrito.addPanel(prod);
			Pizza.cardLayout.next(Pizza.contentPane);
		}
	}

	void addBebida(JButton botonBebida) {
		Object[] options = { "1.5 L", "600 mL" };
		Object selectedValue = JOptionPane.showInputDialog(null, "Elija el tamaño", "Agregar al carrito", -1, null,
				options, options[0]);

		if (selectedValue != null) {
			double precio = 0;
			switch (selectedValue.toString()) {
			case "1.5 L":
				precio = 40;
				break;
			case "600 mL":
				precio = 20;
				break;
			}
			Producto prod = new Producto(botonBebida.getText(), selectedValue.toString(), precio,
					botonBebida.getIcon());
			Pedido.addProducto(prod);
			Pizza.carrito.lblTotal.setText("Total: $" + Pedido.precioTotal);
			Pizza.carrito.addPanel(prod);
			Pizza.cardLayout.next(Pizza.contentPane);
		}
	}
}
