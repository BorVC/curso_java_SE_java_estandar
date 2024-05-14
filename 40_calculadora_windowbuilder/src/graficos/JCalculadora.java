package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtf1;
	private JTextField jtf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCalculadora frame = new JCalculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JCalculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(46, 34, 81, 14);
		contentPane.add(lblNewLabel);
		
		jtf1 = new JTextField();
		jtf1.setBounds(169, 33, 86, 20);
		contentPane.add(jtf1);
		jtf1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Número 2");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(46, 81, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		jtf2 = new JTextField();
		jtf2.setBounds(169, 80, 86, 20);
		contentPane.add(jtf2);
		jtf2.setColumns(10);
		
		JLabel jblResultado = new JLabel("");
		jblResultado.setBounds(146, 214, 128, 20);
		contentPane.add(jblResultado);
		
		JButton btnSuma = new JButton("Sumar");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int suma = Integer.parseInt(jtf1.getText()) + Integer.parseInt(jtf2.getText());
				jblResultado.setText("Suma: " + suma);
			}
		});
		btnSuma.setBounds(81, 155, 89, 23);
		contentPane.add(btnSuma);
		
		JButton btnMulti = new JButton("Multiplicar");
		btnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int multi = Integer.parseInt(jtf1.getText()) + Integer.parseInt(jtf2.getText());
				jblResultado.setText("Multiplicación: " + multi);
			}
		});
		btnMulti.setBounds(236, 155, 89, 23);
		contentPane.add(btnMulti);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCalculadora.this.dispose();//Llamar al objeto ventana desde el propio nombre de la clase + this(esta misma) + llamada a método cerrar(dispose())
			}
		});
		btnSalir.setBounds(324, 214, 89, 23);
		contentPane.add(btnSalir);
		
	}
}
