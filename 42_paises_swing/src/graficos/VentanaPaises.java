package graficos;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import adaptadores.ListModelContinentesImpl;
import service.PaisesServiceFactory;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class VentanaPaises extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPaises frame = new VentanaPaises();
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
	public VentanaPaises() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Continentes:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(37, 40, 89, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(136, 40, 83, 110);
		contentPane.add(scrollPane);
		
		JList<String> listContinentes = new JList<>();
		listContinentes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				//Variable guarda la selección de la lista
				String seleccionado = listContinentes.getSelectedValue();
				//llamada a la factoria
				var service = PaisesServiceFactory.getPaisesService();
				JOptionPane.showMessageDialog(VentanaPaises.this, "Paises de : " + seleccionado + ":" + service.listaPaisPorContinente(seleccionado).size());
			}
		});
		listContinentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listContinentes);
		//asociamos adaptador a la lista
		listContinentes.setModel(new ListModelContinentesImpl());
	}
}
