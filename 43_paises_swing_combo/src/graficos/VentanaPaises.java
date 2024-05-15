package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import adaptadores.ComboBoxModelContinentesImpl;
import adaptadores.TableModelPaisesImpl;
import service.PaisesServiceFactory;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTable;

public class VentanaPaises extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

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
		lblNewLabel.setBounds(30, 27, 81, 14);
		contentPane.add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 114, 319, 120);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		JComboBox<String> comboContinentes = new JComboBox<>();
		comboContinentes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String seleccionado=(String)comboContinentes.getSelectedItem();
					//creamos adaptador con los datos de los paises
					//y lo volcamos en JTable
					var adaptador=new TableModelPaisesImpl(seleccionado);
					table.setModel(adaptador);
				}		
			}
		});
		comboContinentes.setBounds(111, 23, 130, 22);
		contentPane.add(comboContinentes);
		comboContinentes.setModel(new ComboBoxModelContinentesImpl());
		
		JLabel lblNewLabel_1 = new JLabel("Paises:");
		lblNewLabel_1.setBounds(65, 89, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
