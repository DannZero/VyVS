package mx.unam.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import mx.unam.model.Pedido;

public class Checkout extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 * 
	 * @throws ParseException
	 */
	public Checkout() throws ParseException {
		setPreferredSize(new Dimension(590, 570));
		setLayout(null);

		JLabel lblConfirmaTusDatos = new JLabel("Confirma tus datos");
		lblConfirmaTusDatos.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblConfirmaTusDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmaTusDatos.setBounds(6, 6, 583, 79);
		add(lblConfirmaTusDatos);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(89, 102, 61, 16);
		add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setBounds(89, 183, 61, 16);
		add(lblApellidos);

		JLabel lblEmail = new JLabel("Correo electrónico");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(34, 345, 116, 16);
		add(lblEmail);

		JLabel lblTelefono = new JLabel("Teléfono");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setBounds(89, 424, 61, 16);
		add(lblTelefono);

		JTextField textFieldNombre = new JTextField();
		textFieldNombre.setBounds(162, 97, 348, 26);
		add(textFieldNombre);

		JTextField textFieldApellidos = new JTextField();
		textFieldApellidos.setBounds(162, 178, 348, 26);
		add(textFieldApellidos);

		JLabel lblNewLabel = new JLabel("Dirección");
		lblNewLabel.setBounds(89, 264, 61, 16);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(162, 259, 348, 26);
		add(textField);
		textField.setColumns(10);

		JTextField textFieldEmail = new JTextField();
		textFieldEmail.setBounds(162, 340, 348, 26);
		add(textFieldEmail);

		MaskFormatter mascara = new MaskFormatter("## #### ####");
		JFormattedTextField formattedTextFieldTelefono = new JFormattedTextField(mascara);
		formattedTextFieldTelefono.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				formattedTextFieldTelefono.setCaretPosition(0);
			}
		});
		formattedTextFieldTelefono.setBounds(162, 419, 348, 26);
		add(formattedTextFieldTelefono);

		JButton btnEnviarOrden = new JButton("Enviar mi orden");
		btnEnviarOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, Pedido.listarPedido(), "Ticket", JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnEnviarOrden.setBounds(425, 517, 159, 47);
		add(btnEnviarOrden);

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pizza.cardLayout.previous(Pizza.contentPane);
			}
		});
		btnNewButton.setBounds(6, 517, 144, 47);
		add(btnNewButton);

	}
}
