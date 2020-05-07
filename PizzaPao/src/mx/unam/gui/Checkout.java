package mx.unam.gui;

import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;

public class Checkout extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public Checkout() throws ParseException {
		setLayout(null);
		
		JLabel lblConfirmaTusDatos = new JLabel("Confirma tus datos");
		lblConfirmaTusDatos.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblConfirmaTusDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmaTusDatos.setBounds(6, 6, 588, 79);
		add(lblConfirmaTusDatos);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(16, 102, 61, 16);
		add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setBounds(16, 130, 61, 16);
		add(lblApellidos);
		
		JLabel lblEmail = new JLabel("Correo electrónico");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(305, 130, 116, 16);
		add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Teléfono");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setBounds(360, 158, 61, 16);
		add(lblTelefono);
		
		JFormattedTextField formattedTextFieldNombre = new JFormattedTextField();
		formattedTextFieldNombre.setBounds(89, 97, 204, 26);
		add(formattedTextFieldNombre);
		
		JFormattedTextField formattedTextFieldApellidos = new JFormattedTextField();
		formattedTextFieldApellidos.setBounds(89, 125, 204, 26);
		add(formattedTextFieldApellidos);
		
		JFormattedTextField formattedTextFieldEmail = new JFormattedTextField();
		formattedTextFieldEmail.setBounds(433, 125, 161, 26);
		add(formattedTextFieldEmail);
		
		MaskFormatter mascara = new MaskFormatter("##  #### ####");
		JFormattedTextField formattedTextFieldTelefono = new JFormattedTextField(mascara);
		formattedTextFieldTelefono.setBounds(433, 153, 161, 26);
		add(formattedTextFieldTelefono);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 191, 588, 362);
		add(scrollPane);
		
		JPanel panelScroll = new JPanel();
		scrollPane.setViewportView(panelScroll);
		
		JButton btnEnviarOrden = new JButton("Enviar mi orden");
		btnEnviarOrden.setBounds(452, 565, 142, 29);
		add(btnEnviarOrden);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(0, 565, 117, 29);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(16, 158, 61, 16);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(89, 153, 204, 26);
		add(textField);
		textField.setColumns(10);

	}
}
