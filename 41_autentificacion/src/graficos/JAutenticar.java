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

import service.ClientesService;
import service.ClientesServiceFactory;

public class JAutenticar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfUsu;
	private JTextField tjfPass;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	public JAutenticar() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(41, 45, 81, 14);
		contentPane.add(lblNewLabel);
		
		jtfUsu = new JTextField();
		jtfUsu.setBounds(141, 44, 170, 20);
		contentPane.add(jtfUsu);
		jtfUsu.setColumns(10);
		
		JLabel newLabel2 = new JLabel("Password");
		newLabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newLabel2.setBounds(41, 116, 81, 14);
		contentPane.add(newLabel2);
		
		tjfPass = new JTextField();
		tjfPass.setBounds(141, 110, 170, 20);
		contentPane.add(tjfPass);
		tjfPass.setColumns(10);
		
		JButton btnAutentificar = new JButton("Autentificar");
		btnAutentificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensaje;
				String usuario=jtfUsu.getText();
				String password=tjfPass.getText();
				ClientesService service=ClientesServiceFactory.getClientesService();
				if(service.autentificar(usuario, password)) {
					mensaje="Autenticado!";
				}else {
					mensaje="Usuario o contraseña no válidos!";
				}
				JOptionPane.showMessageDialog(JAutenticar.this, mensaje);
			}
		});
		btnAutentificar.setBounds(159, 182, 114, 23);
		contentPane.add(btnAutentificar);
		
		JButton btnRegis = new JButton("Registrar");
		btnRegis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Objeto de la ventana registrar
				JRegistrar jRegistrar = new JRegistrar();
			}
		});
		btnRegis.setBounds(33, 214, 89, 23);
		contentPane.add(btnRegis);
	}

}
