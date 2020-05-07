package mx.unam.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Pizza extends JFrame {

	private JPanel contentPane;
	public CardLayout cardLayout;

	public static String MENU = "Menu";
	public static String CARRITO = "Carrito";
	public static String CHECKOUT = "Checkout";
	
	Menu menu;
	Carrito pedido;
	Checkout checkout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// System look and feel
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Pizza frame = new Pizza();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public Pizza() throws ParseException {
		setMinimumSize(new Dimension(600, 600));
		setPreferredSize(new Dimension(600, 600));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);

		menu = new Menu();
		contentPane.add(menu, MENU);

		pedido = new Carrito();
		contentPane.add(pedido, CARRITO);
		
		checkout = new Checkout();
		contentPane.add(checkout, CHECKOUT);

		// cardLayout.next(contentPane);

	}

}
