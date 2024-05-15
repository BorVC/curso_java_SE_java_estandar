package graficos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import service.ClientesService;
import service.ClientesServiceFactory;

public class JRegistrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfUsu;
	private JTextField jtfPass;
	private JTextField jtfEmail;
	private JTextField jtfPhone;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public JRegistrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(37, 29, 94, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(37, 65, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(37, 102, 94, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Teléfono");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(37, 137, 94, 14);
		contentPane.add(lblNewLabel_3);
		
		jtfUsu = new JTextField();
		jtfUsu.setBounds(153, 28, 86, 20);
		contentPane.add(jtfUsu);
		jtfUsu.setColumns(10);
		
		jtfPass = new JTextField();
		jtfPass.setBounds(153, 64, 86, 20);
		contentPane.add(jtfPass);
		jtfPass.setColumns(10);
		
		jtfEmail = new JTextField();
		jtfEmail.setBounds(153, 101, 86, 20);
		contentPane.add(jtfEmail);
		jtfEmail.setColumns(10);
		
		jtfPhone = new JTextField();
		jtfPhone.setBounds(153, 136, 86, 20);
		contentPane.add(jtfPhone);
		jtfPhone.setColumns(10);
		
		JButton btnRegis = new JButton("Registrar");
		btnRegis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = jtfUsu.getText();
				String password = jtfPass.getText();
				String email = jtfEmail.getText();
				int telefono = Integer.parseInt(jtfPhone.getText());
				String mensaje;
				//Implementación de ClienteService
				ClientesService clientesService = ClientesServiceFactory.getClientesService();
				//Instamciación objeto Cliente
				Cliente cliente = new Cliente();
				cliente.setUsuario(usuario);
				cliente.setPassword(password);
				cliente.setEmail(email);
				cliente.setTelefono(telefono);
				
				//Constructor con parámetros
				/*Cliente cliente1 = new Cliente(0,jtfUsu.getText(),
						jtfPass.getText(),
						jtfEmail.getText(),
						Integer.parseInt(jtfPhone.getText()));*/
				
				if(clientesService.nuevoCliente(cliente)) {
					mensaje = "Cliente registrado!!!";
				}else {
					mensaje = "Error al registrar el cliente!!!";
				}
				JOptionPane.showMessageDialog(JRegistrar.this, mensaje);
				JRegistrar.this.dispose();
			}
		});
		btnRegis.setBounds(150, 202, 89, 23);
		contentPane.add(btnRegis);
	}

}
